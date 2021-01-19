package com.h5190026.nurullah_dogan_final.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

public class AlertDialogUtil {
    public static void alertDialogTanimla(Activity activity, String positiveButtonText, String negativeButtonText, String title, String message){
        AlertDialog.Builder alertDialog= new AlertDialog.Builder(activity);
        alertDialog.setMessage(Integer.parseInt(message));
        alertDialog.setTitle(Integer.parseInt(title));
        alertDialog.setPositiveButton(Integer.parseInt(positiveButtonText), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if((PrefUtil.getStringPref(activity.getApplicationContext(), Constants.ISTENILEN_ALERT_DIALOG)).equals(Constants.CIKIS_ALERT_DIALOG)){
                    System.exit(0);
                }
                else if((PrefUtil.getStringPref(activity.getApplicationContext(), Constants.ISTENILEN_ALERT_DIALOG)).equals(Constants.INTERNET_KONTROL_ALERT_DIALOG)){
                    activity.startActivity(new Intent(Settings.ACTION_SETTINGS));
                }

            }
        });
        alertDialog.setNegativeButton(Integer.parseInt(negativeButtonText), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if((PrefUtil.getStringPref(activity.getApplicationContext(), Constants.ISTENILEN_ALERT_DIALOG)).equals(Constants.INTERNET_KONTROL_ALERT_DIALOG)){
                    activity.finish();
                }

            }
        }).show();
    }
}
