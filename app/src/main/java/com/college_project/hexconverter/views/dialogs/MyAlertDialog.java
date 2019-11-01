package com.college_project.hexconverter.views.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.app.NotificationCompat;

import com.college_project.hexconverter.R;
import com.college_project.hexconverter.views.activites.MainActivity;

import java.util.Objects;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

public class MyAlertDialog extends AppCompatDialogFragment {

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


//                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext())
//                                .setSmallIcon(R.mipmap.ic_launcher)
//                                .setContentTitle("asd")
//                                .setContentText("asd")
//                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//
//
//
//                        // Creates the intent needed to show the notification
//                        Intent notificationIntent = new Intent(getContext(), MainActivity.class);
//                        PendingIntent contentIntent = PendingIntent.getActivity(getContext(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//                        builder.setContentIntent(contentIntent);
//
//
//                        // Add as notification
//                        String string = getContext().NOTIFICATION_SERVICE;
//                        NotificationManager manager = (NotificationManager) Objects.requireNonNull(getContext()).getSystemService(string);
//                        manager.notify(0, builder.build());

                    }
                });


        return builder.create();
    }
}
