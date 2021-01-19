package com.h5190026.nurullah_dogan_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190026.nurullah_dogan_final.R;
import com.h5190026.nurullah_dogan_final.model.YilanBilgiModel;
import com.h5190026.nurullah_dogan_final.util.Constants;
import com.h5190026.nurullah_dogan_final.util.GlideUtil;
import com.h5190026.nurullah_dogan_final.util.ObjectUtil;

public class YilanDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;
    String tasinanYilanString;
    YilanBilgiModel yilanBilgiModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yilan_detay);
        init();
    }
    private void init(){
        initTxtDetayVeriler();
    }
    private void initTxtDetayVeriler(){
        tasinanYilanString =getIntent().getStringExtra(Constants.TIKLANAN_YILAN_TASINANIN_BASLIGI);
        yilanBilgiModel = ObjectUtil.jsonStringToYilan(tasinanYilanString);
        imgKapak = findViewById(R.id.imgKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);

        txtBaslik.setText(yilanBilgiModel.getAdi());
        txtDetay.setText(yilanBilgiModel.getOzelligi());
        GlideUtil.resmiIndiripGoster(getApplicationContext(),yilanBilgiModel.getBuyukResimUrl(),imgKapak);
        txthtmlYilanDetay();
    }
    private void txthtmlYilanDetay(){
        tasinanYilanString = yilanBilgiModel.getOzelligi();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        {
            txtDetay.setText(Html.fromHtml(tasinanYilanString,Html.FROM_HTML_MODE_LEGACY));

        }
        else{
            txtDetay.setText(Html.fromHtml(tasinanYilanString));

        }
    }
}