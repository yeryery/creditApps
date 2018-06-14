package com.mycompany.app;

import java.util.*;

public class InnGenerator {

    public List formatInnList(List<String> innList) {
        List<String> list = new LinkedList<>();
        DataGenerationMethods generation = new DataGenerationMethods();

        //Крупнейшие работодатели 20 инн по 25000 заявок
        for (int i = 0; i < 20; i++) {
            String inn = formatInnFromTable("1", innList);
            for (int j = 0; j < 25000; j++) {
                list.add(inn);
            }
        }

        //Крупные работодатели 200 инн по 5000 заявок
        for (int i = 0; i < 200; i++) {
            String inn = formatInnFromTable("2", innList);
            for (int j = 0; j < 5000; j++) {
                list.add(inn);
            }
        }
        //Средние 2000 инн по 500 заявок
        for (int i = 0; i < 2000; i++) {
            String inn = formatInnFromTable("3", innList);
            for (int j = 0; j < 500; j++) {
                list.add(inn);
            }
        }

        //Малые 20 000 инн по 50 заявок
        for (int i = 0; i < 20000; i++) {
            String inn = formatInnFromTable("4", innList);
            for (int j = 0; j < 50; j++) {
                list.add(inn);
            }
        }

        //Микро 200 000 инн по 5 заявок
        for (int i = 0; i < 200000; i++) {
            String inn = formatInnFromTable("5", innList);
            for (int j = 0; j < 5; j++) {
                list.add(inn);
            }
        }

        //Уникальные 1000 000 разных инн
        for (int i = 0; i < 1000000; i++) {
            String inn = formatInnFromTable("6", innList);
            list.add(inn);
        }
        //перемешиваем номера
        Collections.shuffle(list);
        ;
        return list;
    }

//    private String formatInnFromTable(int firstDigit, List<String> innValues) {
//        String inn = innValues.remove(0);
//        //меняем 1-ую цифру
//        return firstDigit + inn.substring(1);
//    }

    private String formatInnFromTable(String firstDigit, List<String> innValues) {
        DataGenerationMethods methods = new DataGenerationMethods();
        String inn = innValues.remove(0);
        //меняем 1-ую и последнюю цифру
        return methods.formatInnUL(firstDigit, inn);
    }

    public List demoFormatInnList(List<String> innList) {
        List<String> list = new LinkedList<>();
        DataGenerationMethods generation = new DataGenerationMethods();

        for (int i = 0; i < 1; i++) {
            String inn = formatInnFromTable("1", innList);
            for (int j = 0; j < 5; j++) {
                list.add(inn);
            }
            list.add(" ");
        }

        for (int i = 0; i < 3; i++) {
            String inn = formatInnFromTable("3", innList);
            for (int j = 0; j < 3; j++) {
                list.add(inn);
            }
            list.add(" ");
        }

        for (int i = 0; i < 15; i++) {
            String inn = formatInnFromTable("6", innList);
            list.add(inn);
        }
        return list;
    }

}
