package com.college_project.hexconverter.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Hashtable;
import java.util.Map;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.models.factories.HexadecimalFactories.HexWithPrefixHexadecimalDisplayFactory;
import com.college_project.hexconverter.models.factories.HexadecimalFactories.OneStringHexadecimalDisplayFactory;
import com.college_project.hexconverter.models.factories.HexadecimalFactories.SpacedHexadecimalDisplayFactory;

import static com.college_project.hexconverter.activites.MainActivity.HEX_OF_VALUE_INTENT_EXTRA_NAME;

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

        getHexOfValue();

        TextView textView = (TextView) findViewById(R.id.hexValue);

        textView.setText(hexOfValue);
    }

    /**
     * <p>Sets the hexOfValue of the integer that the user selected that was passed by intent</p>
     */
    private void getHexOfValue(){
        hexOfValue = getIntent().getStringExtra(HEX_OF_VALUE_INTENT_EXTRA_NAME);

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

        if(key.equals(ONE_STRING)) {
            OneStringHexadecimalDisplayFactory oneStringHexidecimalFactory = new OneStringHexadecimalDisplayFactory();
            String factoryValue = oneStringHexidecimalFactory.getHexadecimal(hexOfValue);
            textView.setText(factoryValue);
        }

        else if(key.equals(HEX_PREFIX_ID)) {
            HexWithPrefixHexadecimalDisplayFactory hexWithPrefixHexidecimalFactory = new HexWithPrefixHexadecimalDisplayFactory();
            String factoryValue = hexWithPrefixHexidecimalFactory.getHexadecimal(hexOfValue);
            textView.setText(factoryValue);
        }

        else {
            SpacedHexadecimalDisplayFactory spacedHexidecimalDisplayFactory = new SpacedHexadecimalDisplayFactory();
            String factoryValue = spacedHexidecimalDisplayFactory.getHexadecimal(hexOfValue);
            textView.setText(factoryValue);
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
