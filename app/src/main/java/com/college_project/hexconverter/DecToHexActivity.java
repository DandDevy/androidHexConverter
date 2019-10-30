package com.college_project.hexconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Hashtable;
import java.util.Map;

public class DecToHexActivity extends AppCompatActivity {

    private static final String ONE_STRING = "oneString";
    private static final String SPACED = "spaced";
    private static final String SPACE = " ";
    private static final int SPACING = 2;
    private static final String HEX_PREFIX_ID = "hexPrefix";
    private static final String HEX_PREFIX = "0x";
    private static String hexOfValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_to_hex);

        setHexOfValue();

        TextView textView = (TextView) findViewById(R.id.hexValue);

        textView.setText(hexOfValue);
    }

    /**
     * <p>Sets the hexOfValue of the integer that the user selected that was passed by intent</p>
     */
    private void setHexOfValue(){
        String intValueAsString = getIntent().getStringExtra("intValue");

        int intValue = Integer.valueOf(intValueAsString);

        hexOfValue = Integer.toString(intValue, 16);
    }


    /**
     * <p>Go back</p>
     * @param view
     */
    public void returnToMain(View view) {
        onBackPressed();
    }

    /**
     *
     * @param view
     */
    public void changeHexView(View view) {
        System.out.println("Change hex view");
        Hashtable<String, Boolean> rbValues = getButtonValue();

        for (Map.Entry<String, Boolean> entry : rbValues.entrySet()) {
            String k = entry.getKey();
            Boolean v = entry.getValue();
            if (v) {
                setHexViewTo(k);
                break;
            }
        }
    }

    private void setHexViewTo(String key) {
        TextView textView = (TextView) findViewById(R.id.hexValue);
        System.out.println("my key: " + key);

        if(key.equals(ONE_STRING))
            textView.setText(hexOfValue);

        else if(key.equals(HEX_PREFIX_ID))
            textView.setText(HEX_PREFIX + hexOfValue);

        else {
            String value = hexOfValue;
            if(value.length() > 2){

                StringBuilder builder = new StringBuilder(
                        value.length() + SPACE.length() * (value.length()/SPACING)+1);

                int index = 0;
                String prefix = "";
                while (index < value.length())
                {
                    // Don't put the insert in the very first iteration.
                    // This is easier than appending it *after* each substring
                    builder.append(prefix);
                    prefix = SPACE;
                    builder.append(value.substring(index,
                            Math.min(index + SPACING, value.length())));
                    index += SPACING;
                }

                textView.setText(builder.toString());

            } else
                textView.setText(hexOfValue);
        }


    }

    /**
     * <p>Gets a Hashtable of key=String, value=Boolean of the radio buttons in the xml.</p>
     * @return Hashtable<String, Boolean> values
     */
    private Hashtable<String, Boolean> getButtonValue(){

        Hashtable<String, Boolean> values = new Hashtable<String, Boolean>();

        RadioButton oneStringRb = (RadioButton) findViewById(R.id.oneStringRadioButton);
        values.put(ONE_STRING, oneStringRb.isChecked());

        RadioButton spacedRadioButtonRb = (RadioButton) findViewById(R.id.spacedRadioButton);
        values.put(SPACED, spacedRadioButtonRb.isChecked());

        RadioButton hexPrefixRb = (RadioButton) findViewById(R.id.viewWithHexPrefixRadioButton);
        values.put(HEX_PREFIX_ID, hexPrefixRb.isChecked());

        return values;
    }
}
