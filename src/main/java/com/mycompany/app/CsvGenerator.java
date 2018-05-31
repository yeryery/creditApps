package com.mycompany.app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvGenerator {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String filePath = "C:\\Users\\DNikonorov\\Documents\\gpb\\attributes1.csv";
        PrintWriter pw = new PrintWriter(filePath, "Cp1251");

        int uniqueClients = 100;
        AppsBuilder appsBuilder = new AppsBuilder();
        List appsList = appsBuilder.fillList(uniqueClients);

        for (Object app:appsList) {
            pw.write((String) app + "\n");
        }
        pw.close();

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

}
