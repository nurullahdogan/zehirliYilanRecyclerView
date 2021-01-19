package com.h5190026.nurullah_dogan_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import com.h5190026.nurullah_dogan_final.R;

public class GlideUtil {
    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .error(R.drawable.banner)
                .centerCrop()
                .into(img);
    }
}
