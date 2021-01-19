package com.h5190026.nurullah_dogan_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.h5190026.nurullah_dogan_final.R;


public class YilanViewHolder extends RecyclerView.ViewHolder {

    ImageView imgYilanLogo;
    TextView txtYilanAdi;
    TextView txtBoyu;
    TextView txtAile;

    public YilanViewHolder(@NonNull View cardView, YilanAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgYilanLogo =cardView.findViewById(R.id.imgYilanLogo);
        txtYilanAdi =cardView.findViewById(R.id.txtYilanAdi);
        txtBoyu =cardView.findViewById(R.id.txtBoyu);
        txtAile =cardView.findViewById(R.id.txtAile);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(getAdapterPosition());
            }
        });
    }
}
