package com.college_project.hexconverter.views.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.os.Build.VERSION_CODES;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.controllers.HexConverter;
import com.college_project.hexconverter.controllers.InputValidation;
import com.college_project.hexconverter.views.dialogs.MyAlertDialog;

import java.util.Objects;

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

    public void notication(View view) {
        // make a notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My notification")
                .setContentText("Much longer text that cannot fit one line...")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);



        // Creates the intent needed to show the notification
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(contentIntent);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pendingIntent);


        // Add as notification
//        String string = this.NOTIFICATION_SERVICE;
//        NotificationManager manager = (NotificationManager) Objects.requireNonNull(this).getSystemService(string);
//        manager.notify(0, builder.build());
//        Toast.makeText(this,getString(R.string.dialogPositiveButtonClose),Toast.LENGTH_SHORT).show();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(999, builder.build());
    }


    public void addNotification(View view) {
        // Builds your notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"notify_001")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("John's Android Studio Tutorials")
                .setContentText("A video has just arrived!")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        // Creates the intent needed to show the notification
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);


        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // === Removed some obsoletes
        if (Build.VERSION.SDK_INT >= VERSION_CODES.O)
        {
            String channelId = "Your_channel_id";
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "Channel human readable title",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder.setChannelId(channelId);
        }

        // Add as notification

        manager.notify(9863, builder.build());
    }
}
