package ru.roman.calculatorgittest.utils;

public class Calculation {

    public String workCalculation (String a, String b) {

        int result = Integer.parseInt(a)+Integer.parseInt(b);
        String s = String.valueOf(result);
        return s;
    }
}
