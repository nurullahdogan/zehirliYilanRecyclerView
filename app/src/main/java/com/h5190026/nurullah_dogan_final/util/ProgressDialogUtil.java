package com.h5190026.nurullah_dogan_final.util;

import android.app.ProgressDialog;
import android.content.Context;

public class ProgressDialogUtil {

    public static ProgressDialog progressDialog(Context context, String message){
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.getListView();
        progressDialog.show();
        return progressDialog;
    }
}
