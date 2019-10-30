package com.college_project.hexconverter.models.factories.HexidecimalFactories;

import com.college_project.hexconverter.models.factories.InterfaceHexidecimalDisplayFactory;

public class SpacedHexidecimalDisplayFactory implements InterfaceHexidecimalDisplayFactory {

    private static final String SPACED = "spaced";
    private static final String SPACE = " ";
    private static final int SPACING = 2;

    @Override
    public String getHexidecimal(String hexValue) {
        String res = "";
        String value = hexValue;
        if(value.length() > 2) {

            StringBuilder builder = new StringBuilder(
                    value.length() + SPACE.length() * (value.length() / SPACING) + 1);

            int index = 0;
            String prefix = "";
            while (index < value.length()) {
                // Don't put the insert in the very first iteration.
                // This is easier than appending it *after* each substring
                builder.append(prefix);
                prefix = SPACE;
                builder.append(value.substring(index,
                        Math.min(index + SPACING, value.length())));
                index += SPACING;
            }

            res = builder.toString();

        } else {
            res = hexValue;
        }
        return res;
    }
}
