package com.college_project.hexconverter.controllers;

/**
 * <h1>InputValidation controller</h1>
 */
public class InputValidation {

    /**
     * <p>validates input for the convertDecToHex in the MainActivity before creating Intent.</p>
     * @param intValueAsString
     * @return
     */
    public static boolean isStringConvertibleToHex(String intValueAsString) {

        boolean res = true;

        if(intValueAsString.length() == 0){
            res = false;
        }
        return res;
    }

    /**
     * <p>validates input for the convertHexToDec in the HexToDecActivity before creating Intent.</p>
     * @param hexValueAsString
     * @return
     */
    public static boolean isStringConvertibleFromHexToDec(String hexValueAsString) {
        boolean res = true;

        return res;
    }
}
