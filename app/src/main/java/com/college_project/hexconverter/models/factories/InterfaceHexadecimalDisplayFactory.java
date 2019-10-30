package com.college_project.hexconverter.models.factories;

/**
 * <h1>InterfaceHexadecimalDisplayFactory</h1>
 * <p>This interface is for the different hexadecimal display Strings. Using the factory method pattern.</p>
 */
public interface InterfaceHexadecimalDisplayFactory {

    /**
     * <p>Gets the String for the hexadecimal display.</p>
     * @param hexValue
     * @return
     */
    public String getHexadecimal(String hexValue);

}
