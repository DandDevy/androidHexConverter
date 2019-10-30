package com.college_project.hexconverter.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.controllers.HexConverter;
import com.college_project.hexconverter.controllers.InputValidation;

public class MainActivity extends AppCompatActivity {

    public static final String HEX_OF_VALUE_INTENT_EXTRA_NAME = "hexOfValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * <p>convertDecToHex is called by the button in the activity_main</p>
     * @param view
     */
    public void convertDecToHex(View view) {
        String intValueAsString = ((EditText) findViewById(R.id.intValue)).getText().toString();

        if(InputValidation.isStringConvertibleToHex(intValueAsString)) {

            String hexOfValue = HexConverter.stringOfIntToStringOfHex(intValueAsString);

            Intent decToHexConverter = new Intent(this, DecToHexActivity.class);

            decToHexConverter.putExtra(HEX_OF_VALUE_INTENT_EXTRA_NAME, hexOfValue);

            startActivity(decToHexConverter);
        }
    }

    /**
     * <p>swap converters</p>
     * @param view
     */
    public void swap(View view) {
        Intent hexToDecActivityintent = new Intent(this, HexToDecActivity.class);

        startActivity(hexToDecActivityintent);
    }
}
