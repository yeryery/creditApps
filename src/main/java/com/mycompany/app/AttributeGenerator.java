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

    public String generateNumber(int n) {
        return generate(n, "0123456789");
    }

    public String getTodaysTime(String pattern) {
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

    public String getRandomDate(int startYear, int range, String pattern) {
        final Random random = new Random();
        LocalDateTime time = LocalDateTime.of(LocalDate.of(random.nextInt(range) + startYear,
                random.nextInt(12) + 1, random.nextInt(27) + 1), LocalTime.NOON);
        ;
        return formatTime(time, pattern);
    }

    public String getFio() {
        String lastName = generateString(5);
        String firstName = generateString(5);
        String middleName = generateString(5);
        ;
        return lastName + "," + firstName + "," + middleName;
    }

    public String getPassport() {
        String docSer = generateNumber(4);
        String docNum = generateNumber(6);
        ;
        return docSer + "," + docNum;
    }

    public String getInn(List list) {
        return (String) list.remove(0);
    }

    public String getAddress() {
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

    public String getTk() {
        String tkSeries = "TK-II";
        String tkNumber = generateNumber(7);
        ;
        return tkSeries + "," + tkNumber;
    }

    public String getPhoneNumber() {
        return "+79" + generateNumber(9);
    }

    public List createInnList() {
        List<String> list = new ArrayList<>();

        //Крупнейшие работодатели 20 инн по 25000 заявок
        for (int i = 0; i < 20; i++) {
            String inn = "1" + generateNumber(9);
            for (int j = 0; j < 25000; j++) {
                list.add(inn);
            }
        }

        //Крупные работодатели 200 инн по 5000 заявок
        for (int i = 0; i < 200; i++) {
            String inn = "2" + generateNumber(9);
            for (int j = 0; j < 5000; j++) {
                list.add(inn);
            }
        }
        //Средние 2000 инн по 500 заявок
        for (int i = 0; i < 2000; i++) {
            String inn = "3" + generateNumber(9);
            for (int j = 0; j < 500; j++) {
                list.add(inn);
            }
        }

        //Малые 20 000 инн по 50 заявок
        for (int i = 0; i < 20000; i++) {
            String inn = "4" + generateNumber(9);
            for (int j = 0; j < 50; j++) {
                list.add(inn);
            }
        }

        //Микро 200 000 инн по 5 заявок
        for (int i = 0; i < 200000; i++) {
            String inn = "5" + generateNumber(9);
            for (int j = 0; j < 5; j++) {
                list.add(inn);
            }
        }

        //Уникальные 1000 000 разных инн
        for (int i = 0; i < 1000000; i++) {
            String inn = "9" + generateNumber(9);
            list.add(inn);
        }
        Collections.shuffle(list);
        ;
        return list;
    }

    public List createTestList() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            String inn = "1" + generateNumber(9);
            for (int j = 0; j < 50; j++) {
                list.add(inn);
            }
        }

        for (int i = 0; i < 5; i++) {
            String inn = "2" + generateNumber(9);
            for (int j = 0; j < 10; j++) {
                list.add(inn);
            }
        }

        for (int i = 0; i < 20; i++) {
            String inn = "3" + generateNumber(9);
            for (int j = 0; j < 5; j++) {
                list.add(inn);
            }
        }

        for (int i = 0; i < 50; i++) {
            String inn = "9" + generateNumber(9);
            list.add(inn);
        }

        Collections.shuffle(list);
        ;
        return list;
    }
}
