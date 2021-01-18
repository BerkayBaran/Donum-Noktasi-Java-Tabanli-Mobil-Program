package com.hr190032.berkay_baran_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hr190032.berkay_baran_final.R;
import com.hr190032.berkay_baran_final.model.CepheModel;
import com.hr190032.berkay_baran_final.util.Constants;
import com.hr190032.berkay_baran_final.util.GlideUtil;
import com.hr190032.berkay_baran_final.util.ObjectUtil;

public class CepheDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;   //Burada activity_cephe_detay'daki bulunan ogeleri tanıtmak icin yeni itemler olusturuyoruz
    TextView txtDetay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cephe_detay);
        init();
    }

        private void init(){

        String tasinanCepheString = getIntent().getStringExtra(Constants.NAME_OF_THE_SELECTED_CEPHE);
        CepheModel cepheModel = ObjectUtil.jsonStringToCephe(tasinanCepheString);

        imgKapak = findViewById(R.id.imgBannerDetail);
        txtBaslik = findViewById(R.id.txtTitle); //burada ise onları esitliyoruz
        txtDetay = findViewById(R.id.txtDetail);

        txtBaslik.setText(cepheModel.getCephe());
        txtDetay.setText(cepheModel.getAciklama());

            GlideUtil.showImage(getApplicationContext(),cepheModel.getKapakUrl(),imgKapak);
    }
}