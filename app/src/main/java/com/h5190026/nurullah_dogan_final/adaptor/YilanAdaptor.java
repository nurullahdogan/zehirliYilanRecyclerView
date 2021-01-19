package com.h5190026.nurullah_dogan_final.adaptor;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190026.nurullah_dogan_final.R;
import com.h5190026.nurullah_dogan_final.model.YilanBilgiModel;
import com.h5190026.nurullah_dogan_final.util.GlideUtil;

import java.util.List;

public class YilanAdaptor extends RecyclerView.Adapter<YilanViewHolder> {


    List<YilanBilgiModel> yilanlar;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener{
        void onClick(int position);
    }


    public YilanAdaptor(List<YilanBilgiModel> yilanlar, Context context, OnItemClickListener listener) {
        this.yilanlar = yilanlar;
        this.context = context;
        this.listener =listener;
    }

    @NonNull
    @Override
    public YilanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardwiew_yilan,parent,false);
        return new YilanViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull YilanViewHolder viewHolder, int position) {

        viewHolder.txtYilanAdi.setText(yilanlar.get(position).getAdi());
        viewHolder.txtBoyu.setText(yilanlar.get(position).getBoyu());
        viewHolder.txtAile.setText(yilanlar.get(position).getAilesi());
        GlideUtil.resmiIndiripGoster(context,yilanlar.get(position).getKucukResimUrl(),viewHolder.imgYilanLogo);

    }

    @Override
    public int getItemCount() {
        return yilanlar.size();
    }
}
