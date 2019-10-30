package com.college_project.hexconverter;

import com.college_project.hexconverter.controllers.InputValidation;
import com.college_project.hexconverter.models.factories.HexadecimalFactories.HexWithPrefixHexadecimalDisplayFactory;
import com.college_project.hexconverter.models.factories.HexadecimalFactories.OneStringHexadecimalDisplayFactory;
import com.college_project.hexconverter.models.factories.HexadecimalFactories.SpacedHexadecimalDisplayFactory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HexadecimalFactoryTesting {
    /**
     * <p>Checks the input of the method of getHexadecimal in OneStringHexadecimalDisplayFactory factory with a string</p>
     */
    @Test
    public void OneStringHexadecimalDisplayFactory_isCorrect() {
        OneStringHexadecimalDisplayFactory oneStringHexadecimalDisplayFactory = new OneStringHexadecimalDisplayFactory();
        assertEquals("asd", oneStringHexadecimalDisplayFactory.getHexadecimal("asd"));
    }


    /**
     * <p>Checks the input of the method of getHexadecimal in HexWithPrefixHexadecimalDisplayFactory factory with a string</p>
     */
    @Test
    public void HexWithPrefixHexadecimalDisplayFactory_isCorrect() {
        HexWithPrefixHexadecimalDisplayFactory hexadecimalDisplayFactory = new HexWithPrefixHexadecimalDisplayFactory();
        assertEquals("0xasd", hexadecimalDisplayFactory.getHexadecimal("asd"));
    }

    /**
     * <p>Checks the input of the method of getHexadecimal in SpacedHexadecimalDisplayFactory factory with a string</p>
     */
    @Test
    public void SpacedHexadecimalDisplayFactory_isCorrect() {
        SpacedHexadecimalDisplayFactory hexadecimalDisplayFactory = new SpacedHexadecimalDisplayFactory();
        assertEquals("as d", hexadecimalDisplayFactory.getHexadecimal("asd"));
    }

}
