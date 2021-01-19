package com.h5190026.nurullah_dogan_final.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.h5190026.nurullah_dogan_final.R;
import com.h5190026.nurullah_dogan_final.util.AlertDialogUtil;
import com.h5190026.nurullah_dogan_final.util.Constants;
import com.h5190026.nurullah_dogan_final.util.PrefUtil;

public class SplashActivity extends AppCompatActivity{
    String alertDialogBaslik,alertDialogMessage,alertDialogPositiveButton,alertDialogNegativeButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timerBaslat();

    }

    private void listeActivityAc(){
        Intent listeEkraniActivity = new Intent(getApplicationContext(),ListeActivity.class);
        startActivity(listeEkraniActivity);
        finish();
    }
    private void internetKontrol(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){
            listeActivityAc();
        }
        else{
            alertDialogMessage = String.valueOf(R.string.internetAlertMesaj);
            alertDialogBaslik = String.valueOf(R.string.internetAlertBaslik);
            alertDialogNegativeButton = String.valueOf(R.string.internetAlertNegativeButton);
            alertDialogPositiveButton = String.valueOf(R.string.internetAlertPositiveButton);
            PrefUtil.setStringPref(getApplicationContext(), Constants.ISTENILEN_ALERT_DIALOG, Constants.INTERNET_KONTROL_ALERT_DIALOG);
            AlertDialogUtil.alertDialogTanimla(SplashActivity.this,alertDialogPositiveButton,alertDialogNegativeButton,alertDialogBaslik,alertDialogMessage);
        }
    }
    private void timerBaslat(){
        CountDownTimer countDownTimer = new CountDownTimer(Constants.GECIS_SANIYESI,Constants.COUNT_DOWN) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                internetKontrol();
            }
        }.start();

    }
}