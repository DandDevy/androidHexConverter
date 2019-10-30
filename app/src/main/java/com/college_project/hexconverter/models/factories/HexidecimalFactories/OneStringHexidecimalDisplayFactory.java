package com.college_project.hexconverter.models.factories.HexidecimalFactories;

import com.college_project.hexconverter.models.factories.InterfaceHexidecimalDisplayFactory;

public class OneStringHexidecimalDisplayFactory implements InterfaceHexidecimalDisplayFactory {
    @Override
    public String getHexidecimal(String hexValue) {
        return hexValue;
    }
}
