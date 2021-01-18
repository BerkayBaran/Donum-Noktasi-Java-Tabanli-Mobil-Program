package com.hr190032.berkay_baran_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hr190032.berkay_baran_final.R;

public class CepheViewHolder extends RecyclerView.ViewHolder {
    //Burada cardview_cephe'deki bulunan ogeleri tanıtmak icin yeni itemler olusturuyoruz
    ImageView imgCepheLogosu;
    TextView txtCepheIsmi;
    TextView txtCepheTarihi;

    public CepheViewHolder(@NonNull View cardView, CepheAdaptor.OnItemClickListener listener) {
        super(cardView);

        imgCepheLogosu =cardView.findViewById(R.id.imgCepheLogo);
        txtCepheIsmi =cardView.findViewById(R.id.txtCepheAdi);      //burada ise onları esitliyoruz
        txtCepheTarihi =cardView.findViewById(R.id.txtCepheTarihi);

        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onClick(getAdapterPosition());
            }
        });

    }

}
