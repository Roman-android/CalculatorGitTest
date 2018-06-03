package ru.roman.calculatorgittest.utils;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {

    public String workCalculation (String leftField, String rightField) {

        String stringOfResult="";

        Boolean recognizeTextLeft = compareText(leftField);
        Boolean recognizeTextRight = compareText(rightField);
        Log.d("CalculationLog", String.valueOf(recognizeTextLeft));
        if (recognizeTextLeft || recognizeTextRight){
            String result = leftField+", "+rightField;
            return result;
        }else {
            int result = Integer.parseInt(leftField)+Integer.parseInt(rightField);
            stringOfResult = String.valueOf(result);
            return stringOfResult;
        }


    }

    private static boolean compareText(String dataLeft){
        Pattern pattern = Pattern.compile("([a-zA-Z])*");
        Matcher matcher = pattern.matcher(dataLeft);
        Boolean b = matcher.matches();
        return b;
    }
}
