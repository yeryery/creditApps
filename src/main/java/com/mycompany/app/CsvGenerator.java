package com.mycompany.app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class CsvGenerator {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        String filePath = "C:/Users/DNikonorov/Desktop/gpb/attributes.csv";
        PrintWriter writer = new PrintWriter(filePath, "Cp1251");

        AttributeGenerator ag = new AttributeGenerator();

//      кол-во уникальных клиентов
        int[] clients = {1484042, 619063, 238878, 171078, 85391, 69600, 34940, 29505, 14962, 13179, 6068, 5488, 2594,
                2415, 1080, 1076, 469, 455, 182, 171, 87, 76, 42, 41, 22, 21, 15, 12, 8, 4, 4, 3, 2, 2, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1
        };

//      кол-во заявок на каждого клиента
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26,
                27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 41, 45, 49, 53, 55, 56, 58
        };

//        int[] clients = {4, 3, 1};
//        int[] number = {1, 2, 5};

        for (int i = 0; i < clients.length; i++) {

            for (int j = 0; j < clients[i]; j++) {
                String attributes = generateAttribures(ag);

                for (int k = 0; k < number[i]; k++) {
                    writer.println(attributes);
                }
            }
        }
        writer.close();
    }

    private static String generateAttribures(AttributeGenerator ag) {
        String datePattern = "yyyy-MM-dd'T'HH:mm:ss";
        String applicationDate = ag.getTodaysTime(datePattern);
        String signDate = applicationDate;
        String appStatusDate = applicationDate;

        String applicationExternalId = ag.generateNumber(8);

        String numberPattern = "yyyyMMddHHmmss";
        String applicationNumber = "3-" + ag.getTodaysTime(numberPattern) + "-2";

        String participantId = ag.generateNumber(8);

        String applicationCode = "Ввод данных";
        String status = appStatusDate + applicationCode;

        String clientCategory = "5";
        String fio = ag.getFio();
        String prevFio = "";

        String dateOfBirth = ag.getRandomDate(1950, 50, datePattern);

        String passport = ag.getPassport();
        String prevPassport = "";

        String addressLive = ag.getAddress();
        String addressReg = "";
        String addressTimeReg = "";

        String tk = ag.getTk();
        String tkDate = ag.getRandomDate(1995, 20, datePattern);

        String phoneHome = ag.getPhoneNumber();
        String phoneMobile = ag.getPhoneNumber();
        String phoneReg = ag.getPhoneNumber();
        String phoneWork = ag.getPhoneNumber();

        String phoneCompany = ag.getPhoneNumber();
        String startDate = ag.getRandomDate(1995, 20, datePattern);
        String registrationDate = ag.getRandomDate(1995, 20, datePattern);
        String jobTitleType = "Руководитель среднего звена";

        return applicationDate + "," + applicationExternalId + "," + applicationNumber + "," + signDate + "," +
                status + "," + participantId + "," + clientCategory + "," + fio + "," + prevFio + "," + dateOfBirth + "," +
                passport + "," + prevPassport + "," + addressLive + "," + addressReg + "," + addressTimeReg + "," +
                tk + "," + tkDate + "," + phoneHome + "," + phoneMobile + "," + phoneReg + "," + phoneWork + "," +
                phoneCompany + "," + startDate + "," + registrationDate + "," + jobTitleType;
        /*
            applicationDate, applicationExternalId, applicationNumber, signDate, status (appStatusDate, appStatusCode),
            participantId, clientCategory?, fio(lastName, firstName, middleName), prevfio, dateOfBirth,
            passport(docSer, docNum), prevPassport(docSer, docNum),
            addressLive(countryCd, countryName, postcode, regionCd, regionName, city, street, house, flat),
            addressReg, addressTimeReg, tkSeries, tkNumber, tkDate, phoneHome, phoneMobile, phoneReg, phoneWork,
            phoneCompany, decisionCode?, codeValue?, startDate, registrationDate, jobTitleType?
            */
    }

}
