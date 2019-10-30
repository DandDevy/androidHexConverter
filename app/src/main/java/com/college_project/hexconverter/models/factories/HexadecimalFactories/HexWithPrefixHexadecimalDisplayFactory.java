package com.college_project.hexconverter.models.factories.HexadecimalFactories;

import com.college_project.hexconverter.models.factories.InterfaceHexadecimalDisplayFactory;

/**
 * <h1>HexWithPrefixHexadecimalDisplayFactory</h1>
 * <p>For a String with the hexadecimal prefix before it.</p>
 */
public class HexWithPrefixHexadecimalDisplayFactory implements InterfaceHexadecimalDisplayFactory {
    public static final String HEX_PREFIX = "0x";

    /**
     * <p>returns a hexadecimal with the prefix for it.</p>
     * @param hexValue
     * @return
     */
    @Override
    public String getHexadecimal(String hexValue) {
        return HEX_PREFIX + hexValue;
    }
}
