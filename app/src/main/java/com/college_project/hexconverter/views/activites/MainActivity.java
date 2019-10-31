package com.college_project.hexconverter.views.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.controllers.HexConverter;
import com.college_project.hexconverter.controllers.InputValidation;
import com.college_project.hexconverter.views.dialogs.MyAlertDialog;

import static com.college_project.hexconverter.views.activites.HexToDecActivity.STRING_OF_INT_CONVERTED_FROM_HEX_INTENT_NAME;

public class MainActivity extends AppCompatActivity {

    public static final String HEX_OF_VALUE_INTENT_EXTRA_NAME = "hexOfValue";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkForIntentFromHexToDec();
    }

    /**
     * <p>if an intent is sent it will set the field to it</p>
     */
    private void checkForIntentFromHexToDec() {
        String convertedHexToString = getIntent().getStringExtra(STRING_OF_INT_CONVERTED_FROM_HEX_INTENT_NAME);
        
        if(convertedHexToString != null){
            EditText editTextforInValue = (EditText) findViewById(R.id.intValue);
            editTextforInValue.setText(convertedHexToString);
        }
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

    public void alert(View view) {
        MyAlertDialog myAlertDialog = new MyAlertDialog();
        myAlertDialog.show(getSupportFragmentManager(), "my alert dialog");
    }
}
