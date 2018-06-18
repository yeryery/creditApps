package com.mycompany.app;

import java.util.Random;

public class DataGenerationMethods {

    public DataGenerationMethods() {

    }

    private int getRandomNumberInRange(int min, int max) {

        Random randomNumber = new Random();

        return randomNumber.ints(min, (max + 1)).findFirst().getAsInt();
    }

    String getRandomNumberWithSpecificLength(int numberLength) {

        String randomQuerry = "";

        for (int i = 0; i < numberLength; i++) {

            randomQuerry += String.valueOf(getRandomNumberInRange(0, 9));

        }

        return randomQuerry;

    }

    String getRandomNaturalNumberWithSpecificLength(int numberLength) {

        String randomQuerry = "";

        for (int i = 0; i < numberLength; i++) {

            randomQuerry += String.valueOf(getRandomNumberInRange(1, 9));

        }

        return randomQuerry;

    }

    String getRandomString(int stringLength, String type) {

        String randomString = "";

        char[] chars = null;

        if (type.equals("en")) {

            chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        } else if (type.equals("ru")) {

            chars = "абвгдеёжзийклмнопрстуфхцчшщ".toCharArray();

        }

        StringBuilder sb = new StringBuilder();

        Random random = new Random();

        for (int i = 0; i < stringLength; i++) {

            char c = chars[random.nextInt(chars.length)];

            sb.append(c);

        }

        randomString = sb.toString();

        return randomString;

    }

    String getInnULControlNumber(String inn) {

        final int[] factor = { 2, 4, 10, 3, 5, 9, 4, 6, 8 };

        int coef = 0;

        for (int i = 0; i < 9; i++) {

            coef += Character.getNumericValue(inn.charAt(i)) * factor[i];

        }

        coef = coef % 11;

        if (coef >= 10) {

            coef = 0;

        }

        return Integer.toString(coef);

    }

    String getInnFLFirstControlNumber(String inn) {

        final int[] factor = { 7, 2, 4, 10, 3, 5, 9, 4, 6, 8 };

        int coef = 0;

        for (int i = 0; i < 10; i++) {

            coef += Character.getNumericValue(inn.charAt(i)) * factor[i];

        }

        coef = coef % 11;

        if (coef >= 10) {

            coef = 0;

        }

        return Integer.toString(coef);

    }

    String getInnFLSecondControlNumber(String inn) {

        final int[] factor = { 3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8 };

        int coef = 0;

        for (int i = 0; i < 11; i++) {

            coef += Character.getNumericValue(inn.charAt(i)) * factor[i];

        }

        coef = coef % 11;

        if (coef >= 10) {

            coef = 0;

        }

        return Integer.toString(coef);

    }

    String getInnUL() {

        String innUL = "";

        innUL = getRandomNaturalNumberWithSpecificLength(9);

        innUL += getInnULControlNumber(innUL);

        return innUL;

    }

    String getInnUL(String firstDigit) {

        String innUL = firstDigit;

        innUL += getRandomNaturalNumberWithSpecificLength(8);

        innUL += getInnULControlNumber(innUL);

        return innUL;

    }

    String formatInnULByFirstDigit(String firstDigit, String originalInnUL) {

        String innUL = firstDigit;

        innUL += originalInnUL.substring(1, 9);

        innUL += getInnULControlNumber(innUL);

        return innUL;

    }

    String getInnFL() {

        String innFL = "";

        innFL = getRandomNaturalNumberWithSpecificLength(10);

        innFL += getInnFLFirstControlNumber(innFL);

        innFL += getInnFLSecondControlNumber(innFL);

        return innFL;

    }
}

