package com.college_project.hexconverter.models.factories.HexadecimalFactories;

import com.college_project.hexconverter.models.factories.InterfaceHexadecimalDisplayFactory;

/**
 * <h1>SpacedHexadecimalDisplayFactory</h1>
 * <p>SpacedHexadecimalDisplayFactory implements InterfaceHexadecimalDisplayFactory. For spaced hexadecimal display</p>
 */
public class SpacedHexadecimalDisplayFactory implements InterfaceHexadecimalDisplayFactory {

    private static final String SPACE = " ";
    private static final int SPACING = 2;


    /**
     * <p>returns a String with spaces for every period</p>
     * @param hexValue
     * @return
     */
    @Override
    public String getHexadecimal(String hexValue) {
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
