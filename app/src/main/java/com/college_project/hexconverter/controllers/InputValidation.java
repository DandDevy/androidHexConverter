package com.college_project.hexconverter.controllers;

public class InputValidation {

    public static boolean isStringConvertibleToHex(String intValueAsString) {

        boolean res = true;

        if(intValueAsString.length() == 0){
            res = false;
        }
        return res;
    }
}
