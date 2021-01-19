package com.h5190026.nurullah_dogan_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.h5190026.nurullah_dogan_final.R;
import com.h5190026.nurullah_dogan_final.adaptor.YilanAdaptor;
import com.h5190026.nurullah_dogan_final.model.YilanBilgiModel;
import com.h5190026.nurullah_dogan_final.network.Service;
import com.h5190026.nurullah_dogan_final.util.AlertDialogUtil;
import com.h5190026.nurullah_dogan_final.util.Constants;
import com.h5190026.nurullah_dogan_final.util.ObjectUtil;
import com.h5190026.nurullah_dogan_final.util.PrefUtil;
import com.h5190026.nurullah_dogan_final.util.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressDialog progressDialog;
    String tiklananYilanString;
    Intent yilanDetayEkrani;
    String alertDialogBaslik,alertDialogMessage,alertDialogPositiveButton,alertDialogNegativeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();
    }

    private  void  init()
    {
        yilanlariGetir();
        progresDialogCagirimi();
    }
    private  void  progresDialogCagirimi()
    {
        progressDialog= ProgressDialogUtil.progressDialog(ListeActivity.this,getResources().getString(R.string.progressDialogBaslik));
    }

    void  yilanlariGetir()
    {

        new Service().getServiceApi().yilanlariGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<YilanBilgiModel>>() {

                    List<YilanBilgiModel> yilanlar=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<YilanBilgiModel> yilanBilgiModelList) {
                        yilanlar=yilanBilgiModelList;
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete()
                    {
                        for (int index =0; index<=yilanlar.size(); index++){
                            if(index==yilanlar.size()){
                                progressDialog.dismiss();
                            }
                        }
                        if(yilanlar.size()>0) {
                            initRecycleView(yilanlar);
                        }
                    }
                });
    }
    private  void  initRecycleView(List<YilanBilgiModel> yilanList)
    {
        recyclerView =findViewById(R.id.rcvYilanlar);
        YilanAdaptor yilanAdaptor =new YilanAdaptor(yilanList,getApplicationContext(), new YilanAdaptor.OnItemClickListener()  {
            @Override
            public void onClick(int position){

                YilanBilgiModel tiklananYilan =yilanList.get(position);
                yilanDetayActivityAc(tiklananYilan);

            }
    });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(yilanAdaptor);
    }

    private void yilanDetayActivityAc(YilanBilgiModel tiklananYilan){
        yilanDetayEkrani = new Intent(getApplicationContext(),YilanDetayActivity.class);
        tiklananYilanString= ObjectUtil.yilanToJsonString(tiklananYilan);
        yilanDetayEkrani.putExtra(Constants.TIKLANAN_YILAN_TASINANIN_BASLIGI,tiklananYilanString);
        startActivity(yilanDetayEkrani);
    }

    @Override
    public void onBackPressed() {
        alertDialogMessage = String.valueOf(R.string.cikisAlertMesaj);
        alertDialogBaslik = String.valueOf(R.string.cikisAlertBaslik);
        alertDialogNegativeButton = String.valueOf(R.string.cikisAlertNegativeButton);
        alertDialogPositiveButton = String.valueOf(R.string.cikisAlertPositiveButton);
        PrefUtil.setStringPref(getApplicationContext(), Constants.ISTENILEN_ALERT_DIALOG, Constants.CIKIS_ALERT_DIALOG);
        AlertDialogUtil.alertDialogTanimla(ListeActivity.this,alertDialogPositiveButton,alertDialogNegativeButton,alertDialogBaslik,alertDialogMessage);
    }
}
