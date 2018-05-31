package com.mycompany.app;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AttributeGenerator {

    private String generate(int n, String chars) {
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        while (builder.length() < n) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }
        return builder.toString();
    }

    private String generateString(int n) {
        return generate(n, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя");
    }

    private String generateNumber(int n) {
        return generate(n, "0123456789");
    }

    private String getTodaysTime(String pattern) {
        final Random random = new Random();
        LocalDateTime time = LocalDateTime.of(LocalDate.now(),
                LocalTime.of(random.nextInt(24), random.nextInt(60),
                        random.nextInt(60), random.nextInt(999999999 + 1)));
        ;
        return formatTime(time, pattern);
    }

    private String formatTime(LocalDateTime time, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        ;
        return time.format(formatter);
    }

    private String getRandomDate(int startYear, int range, String pattern) {
        final Random random = new Random();
        LocalDateTime time = LocalDateTime.of(LocalDate.of(random.nextInt(range) + startYear,
                random.nextInt(12) + 1, random.nextInt(27) + 1), LocalTime.NOON);
        ;
        return formatTime(time, pattern);
    }

    private String getFio() {
        String lastName = generateString(5);
        String firstName = generateString(5);
        String middleName = generateString(5);
        ;
        return lastName + "," + firstName + "," + middleName;
    }

    private String getPassport() {
        String docSer = generateNumber(4);
        String docNum = generateNumber(6);
        ;
        return docSer + "," + docNum;
    }

    private String getAddress() {
        String countryCd = "643";
        String countryName = "РОССИЯ";
        String postcode = generateNumber(6);
        String regionCd = "77";
        String regionName = "г. Москва";
        String city = "Москва";
        String street = generateString(8);
        String house = generateNumber(1);
        String flat = generateNumber(2);
        ;
        return countryCd + "," + countryName + "," + postcode + "," + regionCd + "," +
                regionName + "," + city + "," + street + "," + house + "," + flat;
    }

    private String getTk() {
        String tkSeries = "TK-II";
        String tkNumber = generateNumber(7);
        ;
        return tkSeries + "," + tkNumber;
    }

    private String getPhoneNumber() {
        return "+79" + generateNumber(9);
    }

    public String generateAttribures() {
        String datePattern = "yyyy-MM-dd'T'HH:mm:ss";
        String applicationDate = getTodaysTime(datePattern);
        String signDate = applicationDate;
        String appStatusDate = applicationDate;

        String applicationExternalId = generateNumber(8);

        String numberPattern = "yyyyMMddHHmmss";
        String applicationNumber = "3-" + getTodaysTime(numberPattern) + "-2";

        String participantId = generateNumber(8);

        String applicationCode = "Ввод данных";
        String status = appStatusDate + applicationCode;

        String clientCategory = "5";
        String fio = getFio();
        String prevFio = "";

        String dateOfBirth = getRandomDate(1950, 50, datePattern);

        String passport = getPassport();
        String prevPassport = "";

        String addressLive = getAddress();
        String addressReg = "";
        String addressTimeReg = "";

        String tk = getTk();
        String tkDate = getRandomDate(1995, 20, datePattern);

        String phoneHome = getPhoneNumber();
        String phoneMobile = getPhoneNumber();
        String phoneReg = getPhoneNumber();
        String phoneWork = getPhoneNumber();

        String phoneCompany = getPhoneNumber();
        String startDate = getRandomDate(1995, 20, datePattern);
        String registrationDate = getRandomDate(1995, 20, datePattern);
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
