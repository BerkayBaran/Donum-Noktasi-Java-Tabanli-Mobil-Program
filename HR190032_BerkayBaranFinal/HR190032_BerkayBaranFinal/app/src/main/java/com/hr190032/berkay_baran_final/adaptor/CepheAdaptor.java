package com.hr190032.berkay_baran_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hr190032.berkay_baran_final.R;
import com.hr190032.berkay_baran_final.model.CepheModel;
import com.hr190032.berkay_baran_final.util.GlideUtil;

import java.util.List;


public class CepheAdaptor extends RecyclerView.Adapter<CepheViewHolder>{

    List<CepheModel> cepheler;
    Context context;
    OnItemClickListener listener;


    public interface OnItemClickListener {
        void onClick(int position);
    }


    public CepheAdaptor(List<CepheModel> cepheler, Context context, OnItemClickListener listener) {
        this.cepheler = cepheler;
        this.context = context;     //Burada CepheModel'deki itemleri burada olusturdugumuz itemler ile esitliyoruz
        this.listener = listener;
    }

    @NonNull
    @Override
    public CepheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_cephe,parent,false);
        return new CepheViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CepheViewHolder viewHolder, int position) {

        viewHolder.txtCepheTarihi.setText(cepheler.get(position).getTarih());
        viewHolder.txtCepheIsmi.setText(cepheler.get(position).getCephe());
        GlideUtil.showImage(context,cepheler.get(position).getLogoUrl(),viewHolder.imgCepheLogosu);
    }

    @Override
    public int getItemCount() {
        return cepheler.size();
    }
}
