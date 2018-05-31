package com.mycompany.app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppsBuilder {

    public List fillList(int uniqueClients) {

        AttributeGenerator generator = new AttributeGenerator();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < uniqueClients * 0.54; i++) {
            String attributes = generator.generateAttribures();
            list.add(attributes);
        }

        for (int i = 0; i < uniqueClients * 0.22; i++) {
            String attributes = generator.generateAttribures();

            for (int j = 0; j < 2; j++) {
                list.add(attributes);
            }
        }

        for (int i = 0; i < uniqueClients * 0.08; i++) {
            String attributes = generator.generateAttribures();

            for (int j = 0; j < 3; j++) {
                list.add(attributes);
            }
        }

        for (int i = 0; i < uniqueClients * 0.06; i++) {
            String attributes = generator.generateAttribures();

            for (int j = 0; j < 4; j++) {
                list.add(attributes);
            }
        }

        for (int i = 0; i < uniqueClients * 0.03; i++) {
            String attributes = generator.generateAttribures();

            for (int j = 0; j < 5; j++) {
                list.add(attributes);
            }
        }

        for (int i = 0; i < uniqueClients * 0.03; i++) {
            String attributes = generator.generateAttribures();

            for (int j = 0; j < 6; j++) {
                list.add(attributes);
            }
        }

        for (int i = 0; i < uniqueClients * 0.04; i++) {
            String attributes = generator.generateAttribures();

            for (int j = 0; j < 20; j++) {
                list.add(attributes);
            }
        }

        Collections.shuffle(list);
        return list;
    }
}
