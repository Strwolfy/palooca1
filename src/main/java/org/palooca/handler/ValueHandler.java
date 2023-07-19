package org.palooca.handler;

import com.jedox.palojlib.interfaces.ICell;
import com.jedox.palojlib.interfaces.ICube;
import com.jedox.palojlib.interfaces.IDatabase;
import com.sun.star.sheet.XCellRangeFormula;
import com.sun.star.uno.XComponentContext;
import org.palooca.PalOOCaManager;
import org.palooca.network.ConnectionHandler;

import java.util.Map;
import java.util.Objects;

public class ValueHandler {

    public static void updateCellRangeBatchingValues(XComponentContext context,
                                                     XCellRangeFormula cellRangeFormula,
                                                     String[][] formula,
                                                     Map<String, ICell> lookup, String cubeName) {
        // nothing to do
    }

    public static void endBatchUpdate(XComponentContext context,
                                      String cubeName) {
        // nothing to do
    }

//    public static Object getPaloDataValue(XComponentContext context,
//                                          String servdb,
//                                          String cubeName,
//                                          Object[] coordinates) {
//        PalOOCaManager manager = PalOOCaManager.getInstance(context);
//        ConnectionHandler connectionHandler = manager.getConnectionHandler();
//
//        IDatabase database = connectionHandler.getDatabase(servdb);
//        if (Objects.isNull(database)) {
//            return null;
//        }
//        ICube cube = database.getCubeByName(cubeName);
//        if (Objects.isNull(cube)) {
//            return null;
//        }
//        return cube.getCell();
//    }
}
