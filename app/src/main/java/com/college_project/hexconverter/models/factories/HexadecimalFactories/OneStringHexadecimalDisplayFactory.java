package com.college_project.hexconverter.models.factories.HexadecimalFactories;

import com.college_project.hexconverter.models.factories.InterfaceHexadecimalDisplayFactory;

/**
 * <h1>OneStringHexadecimalDisplayFactory</h1>
 * <p>For a single String.</p>
 */
public class OneStringHexadecimalDisplayFactory implements InterfaceHexadecimalDisplayFactory {
    /**
     * <p>returns a String for display.</p>
     * @param hexValue
     * @return
     */
    @Override
    public String getHexadecimal(String hexValue) {
        return hexValue;
    }
}
