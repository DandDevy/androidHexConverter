package com.college_project.hexconverter.views.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.college_project.hexconverter.R;

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

        builder.setNeutralButton(getString(R.string.dialogPositiveButtonClose),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(),getString(R.string.dialogPositiveButtonClose),Toast.LENGTH_SHORT).show();
                    }
                });


        return builder.create();
    }
}
