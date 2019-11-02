package com.college_project.hexconverter.views.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.controllers.HexConverter;
import  com.college_project.hexconverter.controllers.InputValidation;

public class HexToDecActivity extends AppCompatActivity {

    public static final String STRING_OF_INT_CONVERTED_FROM_HEX_INTENT_NAME = "convertedHexToInt";
    private static final String OUTSTATE_HEX_KEY = "hexKey";
    private String userHexValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_to_dec);
    }


    public void convertHexToDec(View view) {
        String hexValueAsString = ((EditText) findViewById(R.id.hexValue)).getText().toString();
        if(InputValidation.isStringConvertibleFromHexToDec(hexValueAsString)){

            String conversionResult = HexConverter.stringOfHexToStringOfInt(hexValueAsString);

            Intent convertHexToDec = new Intent(this, MainActivity.class);
            convertHexToDec.putExtra(STRING_OF_INT_CONVERTED_FROM_HEX_INTENT_NAME, conversionResult);
            startActivity(convertHexToDec);
        }
    }


    /**
     * <p>swap converters</p>
     * @param view
     */
    public void swap(View view) {
        Intent MainActivityIntent = new Intent(this, MainActivity.class);

        startActivity(MainActivityIntent);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        userHexValue = savedInstanceState.getString(OUTSTATE_HEX_KEY);
        if(userHexValue!=null){
            EditText editTextHexValue = (EditText) findViewById(R.id.hexValue);
            editTextHexValue.setText(userHexValue);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String hexValueAsString = ((EditText) findViewById(R.id.hexValue)).getText().toString();
        userHexValue = hexValueAsString;
        outState.putString(OUTSTATE_HEX_KEY, hexValueAsString);
    }
}
