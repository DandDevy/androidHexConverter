package com.college_project.hexconverter;

import com.college_project.hexconverter.controllers.HexConverter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HexConverterUnitTesting {
    /**
     * <p>Checks the input of the stringOfIntToStringOfHex method with different numbers as strings</p>
     */
    @Test
    public void stringOfIntToStringOfHex_isCorrect() {
        assertEquals("a",HexConverter.stringOfIntToStringOfHex("10"));
        assertEquals("5",HexConverter.stringOfIntToStringOfHex("5"));
        assertEquals("11",HexConverter.stringOfIntToStringOfHex("17"));
        assertEquals("-11",HexConverter.stringOfIntToStringOfHex("-17"));
        assertEquals("3b9ac9ff",HexConverter.stringOfIntToStringOfHex("999999999"));
    }


    /**
     * <p>Checks the input of the stringOfIntToStringOfHex method with different numbers as strings</p>
     */
    @Test
    public void stringOfHexToStringOfInt_isCorrect() {
        assertEquals("10",HexConverter.stringOfHexToStringOfInt("a"));
        assertEquals("17",HexConverter.stringOfHexToStringOfInt("11"));
        assertEquals("-17",HexConverter.stringOfHexToStringOfInt("-11"));
        assertEquals("999999999",HexConverter.stringOfHexToStringOfInt("3b9ac9ff"));
        assertEquals("1152921504606846975",HexConverter.stringOfHexToStringOfInt("fffffffffffffff"));
    }
}
