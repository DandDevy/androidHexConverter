package com.college_project.hexconverter;
import com.college_project.hexconverter.controllers.InputValidation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class InputValidationUnitTesting {

    /**
     * <p>Checks the input of the isStringConvertibleToHex method with an empty string</p>
     */
    @Test
    public void isStringConvertibleToHex_emptyString_isCorrect() {
        assertFalse(InputValidation.isStringConvertibleToHex(""));
    }
    /**
     * <p>Checks the input of the isStringConvertibleToHex method with an empty string</p>
     */
    @Test
    public void isStringConvertibleFromHexToDec_isCorrect() {
        assertFalse(InputValidation.isStringConvertibleFromHexToDec(""));
        assertFalse(InputValidation.isStringConvertibleFromHexToDec("asd"));
    }
}
