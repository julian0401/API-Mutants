package com.mutant.api.utils;

public class Utils {
    public static double roundTwoDecimals(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
