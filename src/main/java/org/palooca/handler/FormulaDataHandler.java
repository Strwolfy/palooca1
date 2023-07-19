package org.palooca.handler;

import com.jedox.palojlib.interfaces.ICell;
import com.jedox.palojlib.interfaces.ICube;
import com.jedox.palojlib.interfaces.IDatabase;
import com.jedox.palojlib.interfaces.IDimension;
import com.jedox.palojlib.interfaces.IElement;
import com.jedox.palojlib.main.Cell;
import com.sun.star.sheet.XCellRangeFormula;
import com.sun.star.uno.XComponentContext;
import org.palooca.PalOOCaManager;
import org.palooca.PaloLibUtil;
import org.palooca.network.ConnectionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class FormulaDataHandler {
    private static Map<String, Map<String, ICell>> cellLookup = new HashMap<>();
    private static boolean readFromBatchResults = false;
    private static boolean disableBatchFetch = false;   // To disable batching, set this to true
    private static boolean fixMissingCells = false;


    public static void updateCellRangeBatchingValues(XComponentContext context,
                                                     XCellRangeFormula cellRangeFormula,
                                                     String[][] formula,
                                                     Map<String,ICell> lookup, String cubeName) {
        if (disableBatchFetch) {
            cellRangeFormula.setFormulaArray(formula);
        } else {
            PalOOCaManager manager = PalOOCaManager.getInstance(context);
            fixMissingCells = manager.isHideEmptyData();
            cellLookup.put(cubeName, lookup);
            // Now do a second pass to read results from the batch
            FormulaDataHandler.beginReadFromBatchResults();
            cellRangeFormula.setFormulaArray(formula);
            /* done in view now
            manager.recalculateDocument(true);
            FormulaDataHandler.endReadFromBatchResults();
            cellLookup.remove(cubeName);
             * */
        }
    }

    public static void endBatchUpdate(XComponentContext context,String cubeName) {
        FormulaDataHandler.endReadFromBatchResults();
        cellLookup.remove(cubeName);
    }

    public static Object getPaloDataValue(XComponentContext context, String servdb, String cubeName, Object[] coordinates){
        ICell cell = null;
        try {

            // Read results from batch if required
            if (FormulaDataHandler.getReadFromBatchResults()){
                Map<String,ICell> preCalcLookup = cellLookup.get(getServerCubeCombo(servdb,cubeName));
                if (preCalcLookup != null) {
                    cell = preCalcLookup.get(PaloLibUtil.getPathString(coordinates));
                    if (cell == null && fixMissingCells) {
                        cell = new Cell(new int[]{},0, ICell.CellType.CELL_NUMERIC,new IDimension[]{},new String[]{});
                    }
                }
            }
            // Otherwise calculate the value
            else {
                PalOOCaManager manager = PalOOCaManager.getInstance(context);
                ConnectionHandler connectionHandler = manager.getConnectionHandler();

                IDatabase database = connectionHandler.getDatabase(servdb);
                if ( database == null )
                    return null;

                ICube cube = database.getCubeByName(cubeName);
                if ( cube == null )
                    return null;

                IElement[] elementCoords = new IElement[coordinates.length];
                IDimension[] dimensions = cube.getDimensions();

                for (int i = 0; i < coordinates.length; i++) {
                    elementCoords[i] = dimensions[i].getElementByName(coordinates[i].toString(),false);
                    if (elementCoords[i] == null)
                        return null;
                }

                cell = cube.getCell(elementCoords);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CellProcessor.getCellValue(cell);
    }


    private static void beginReadFromBatchResults(){
        readFromBatchResults = true;
    }

    private static void endReadFromBatchResults(){
        readFromBatchResults = false;
    }

    private static boolean getReadFromBatchResults(){
        return readFromBatchResults;
    }

    private static String getServerCubeCombo(String servdb, String cubeName) {
        return servdb + ";" + cubeName;
    }

    private enum CellProcessor {
        NUMBER(ICell.CellType.CELL_NUMERIC, 0d),
        STRING(ICell.CellType.CELL_STRING, "");

        private final ICell.CellType type;
        private final Object defaultValue;

        CellProcessor(ICell.CellType type, Object defaultValue) {
            this.type = type;
            this.defaultValue = defaultValue;
        }

        static Object getCellValue(ICell cell) {
            if (cell == null) {
                return null;
            }
            Optional<CellProcessor> first = Stream.of(values())
                    .filter(x -> x.type == cell.getType())
                    .findFirst();
            if (!first.isPresent()) {
                return null;
            }
            CellProcessor cellProcessor = first.get();
            Object value = cell.getValue();
            return Optional.ofNullable(value)
                    .orElse(cellProcessor.defaultValue);
        }
    }
}
