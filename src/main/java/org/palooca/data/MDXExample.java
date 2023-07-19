package org.palooca.data;

import com.jedox.palojlib.main.ConnectionConfiguration;
import org.olap4j.OlapConnection;
import org.olap4j.OlapWrapper;

import java.sql.Connection;
import java.sql.DriverManager;

public class MDXExample {
    static String port = "7080";
    static String username = "ADMIN";
    static String password = "KYLIN";
    static String database = "sales";
    static OlapConnection olapConnection;
    public OlapConnection getOlapConnection() {
        return  olapConnection;
    }

    static String host = "http://192.168.169.3:7080/mdx/xmla/learn_kylin";
    public static void main(String[] args) throws Exception {

        MDXExample mdxExample = new MDXExample();

        // 1. Подключение к MDX-совместимой базе данных
        Class.forName("org.olap4j.driver.xmla.XmlaOlap4jDriver");
        String connectionUrl = "jdbc:xmla:Server=" + host;

        // 2. Кладём пароли в конфигурацию
        ConnectionConfiguration configuration = new ConnectionConfiguration();
        configuration.setPassword(password);
        configuration.setUsername(username);

        // 3. Создание соединения
        Connection connection = DriverManager.getConnection(connectionUrl,
                configuration.getUsername(),configuration.getPassword());

        // 4. Обрётка
        olapConnection = connection.unwrap(OlapConnection.class);

        // 5. Запуск, получение базы
        mdxExample.getOlapConnection().getDatabase();

        // Создание объекта Statement
        //Connections connections = connection.unwrap(Connections.class);
       // Statement statement = olapConnection.createStatement();

        // Выполнение MDX-запроса
        //CellSet cellSet = statement.executeOlapQuery("SELECT [Measures].[Sales Amount] ON COLUMNS, [Product].[Category].Members ON ROWS FROM [Adventure Works]");

        // Обработка результатов запроса
        //CellSetAxis columnsAxis = cellSet.getAxes().get(Axis.COLUMNS);
        //CellSetAxis rowsAxis = cellSet.getAxes().get(Axis.ROWS);

//        for (Position columnPosition : columnsAxis.getPositions()) {
//            for (Member columnMember : columnPosition.getMembers()) {
//                System.out.print(columnMember.getUniqueName() + "\t");
//            }
//            System.out.println();
//        }

//        for (Position rowPosition : rowsAxis.getPositions()) {
//            for (Member rowMember : rowPosition.getMembers()) {
//                System.out.print(rowMember.getUniqueName() + "\t");
//            }
//            System.out.println();
//        }

        // Закрытие подключения
        connection.close();
    }
}
