package com.college_project.hexconverter.controllers;

/**
 * <h1>HexConverter</h1>
 */
public class HexConverter {
    private static final int HEX_BASE = 16;

    /**
     * <p>convert a string of an int to a hex.</p>
     * @param intValueAsString
     * @return hexOfValue
     */
    public static String stringOfIntToStringOfHex(String intValueAsString) {
        int intValue = Integer.valueOf(intValueAsString);
        return Integer.toString(intValue, HEX_BASE);
    }

    /**
     * <p>converts hex value as string to a long as a string.</p>
     * @param hexValueAsString
     * @return
     */
    public static String stringOfHexToStringOfInt(String hexValueAsString) {
        long decode = Long.parseLong(hexValueAsString, HEX_BASE);
        System.out.println("decode of hex in int: " + decode);
        return String.valueOf(decode);
    }
}
