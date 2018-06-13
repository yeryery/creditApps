package com.mycompany.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InnGenerator {

    public List createInnList() {
        List<String> list = new ArrayList<>();
        DataGenerationMethods generation = new DataGenerationMethods();

        //Крупнейшие работодатели 20 инн по 25000 заявок
        for (int i = 0; i < 20; i++) {
            String inn = generation.getInnUL("1");
            for (int j = 0; j < 25000; j++) {
                list.add(inn);
            }
        }

        //Крупные работодатели 200 инн по 5000 заявок
        for (int i = 0; i < 200; i++) {
            String inn = generation.getInnUL("2");
            for (int j = 0; j < 5000; j++) {
                list.add(inn);
            }
        }
        //Средние 2000 инн по 500 заявок
        for (int i = 0; i < 2000; i++) {
            String inn = generation.getInnUL("3");
            for (int j = 0; j < 500; j++) {
                list.add(inn);
            }
        }

        //Малые 20 000 инн по 50 заявок
        for (int i = 0; i < 20000; i++) {
            String inn = generation.getInnUL("4");
            for (int j = 0; j < 50; j++) {
                list.add(inn);
            }
        }

        //Микро 200 000 инн по 5 заявок
        for (int i = 0; i < 200000; i++) {
            String inn = generation.getInnUL("5");
            for (int j = 0; j < 5; j++) {
                list.add(inn);
            }
        }

        //Уникальные 1000 000 разных инн
        for (int i = 0; i < 1000000; i++) {
            String inn = generation.getInnUL("9");
            list.add(inn);
        }
        //перемешиваем номера
        Collections.shuffle(list);
        ;
        return list;
    }

    public List createMiniInnList() {
        List<String> list = new ArrayList<>();
        DataGenerationMethods generation = new DataGenerationMethods();
        int p = 1;

        for (int i = 0; i < 5; i++) {
            String inn = generation.getInnUL("3");
            for (int j = 0; j < 3; j++) {
                list.add(p + "," + inn);
                p++;
            }
        }
        return list;
    }

}
