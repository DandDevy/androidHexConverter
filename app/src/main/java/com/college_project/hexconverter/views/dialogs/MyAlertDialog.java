package com.college_project.hexconverter.views.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.NotificationCompat;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.views.activites.MainActivity;

import java.util.Objects;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class MyAlertDialog extends AppCompatDialogFragment {

    private static final String NOTIFICATION_CHANNEL_ID = "notify_001";
    private static final int NOTIFICATION_ID = 999;
    private static final CharSequence NOTIFICATION_CONTENT_TITLE = "hexy Converty notify";
    private static final CharSequence NOTIFICATION_CONTENT_TEXT = "I gotta something for you!";
    private static final CharSequence BIG_TEXT = "I actually don't know why we notified you.. BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH BLAH";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());

        builder.setTitle(getString(R.string.dialogTitle));
        builder.setMessage(getString(R.string.dialogMessage));
        builder.setPositiveButton(getString(R.string.dialogPositiveButtonClose),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(),getString(R.string.dialogPositiveButtonClose),Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setNegativeButton(getString(R.string.dialogPositiveButtonClose),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(),getString(R.string.dialogPositiveButtonClose),Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setNeutralButton(getString(R.string.notify),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        addNotification();
                    }
                });


        return builder.create();
    }


    /**
     * <p>Adds a notification</p>
     */
    private void addNotification() {
        // Building my notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(),NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle(NOTIFICATION_CONTENT_TITLE)
                .setContentText(NOTIFICATION_CONTENT_TEXT)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(BIG_TEXT))
                .setPriority(NotificationCompat.PRIORITY_MAX);


        // Creates the intent needed to show the notification

//        Intent notificationIntent = new Intent(getContext(), MainActivity.class);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0210000000"));

//        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent contentIntent = PendingIntent.getActivity(getContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);


        NotificationManager manager = (NotificationManager) getContext().getSystemService(getContext().NOTIFICATION_SERVICE);

        // Removed some obsoletes
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    "Channel human readable title",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
            builder.setChannelId(NOTIFICATION_CHANNEL_ID);
        }

        // Add as notification

        manager.notify(NOTIFICATION_ID, builder.build());
    }
}
