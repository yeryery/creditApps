package com.mycompany.app;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

public class TableGenerator {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, SQLException {

        JdbcManager manager = new JdbcManager();
        manager.connect("TutorialDB", "name", "pass");
        InnGenerator generator = new InnGenerator();

        String tableName = "Original_Inn_List";
        List<String> innList = manager.getInnFromOriginalTable(tableName, "Inn");
        List formattedInnList = generator.demoFormatInnList(innList);

        String formatted_Table = "Formatted_Inn";
        manager.cleanTable(formatted_Table);

        for (Object app:formattedInnList) {
            manager.insertValues(formatted_Table, (String) app);
        }

        printValues(manager, tableName);
        System.out.println("____________________");
        printValues(manager, formatted_Table);

        manager.closeOpenedConnection();
    }

    private static void printValues(JdbcManager manager, String tableName) throws SQLException {
        List<String> values = manager.getValues(tableName, "Inn");
        for (String value:values) {
            System.out.println(value);
        }
    }

    private static void fillAttributes(JdbcManager manager, String tableName) throws SQLException {
        int uniqueClients = 50;
        AppsBuilder appsBuilder = new AppsBuilder();
        List appsList = appsBuilder.fillList(uniqueClients);

        for (Object app:appsList) {
            manager.insertValues(tableName, (String) app);
        }
    }

/*
//      кол-во уникальных клиентов
        int[] clients = {1484042, 619063, 238878, 171078, 85391, 69600, 34940, 29505, 14962, 13179, 6068, 5488, 2594,
                2415, 1080, 1076, 469, 455, 182, 171, 87, 76, 42, 41, 22, 21, 15, 12, 8, 4, 4, 3, 2, 2, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1
        };

//      кол-во заявок на каждого клиента
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 41, 45, 49, 53, 55, 56, 58
        };
*/
}
