package com.college_project.hexconverter.models.factories.HexidecimalFactories;

import com.college_project.hexconverter.models.factories.InterfaceHexidecimalDisplayFactory;

public class HexWithPrefixHexidecimalDisplayFactory implements InterfaceHexidecimalDisplayFactory {
    public static final String HEX_PREFIX = "0x";
    @Override
    public String getHexidecimal(String hexValue) {
        return HEX_PREFIX + hexValue;
    }
}
