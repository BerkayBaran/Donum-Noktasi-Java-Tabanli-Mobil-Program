package com.hr190032.berkay_baran_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.app.ProgressDialog;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import com.hr190032.berkay_baran_final.R;
import com.hr190032.berkay_baran_final.adaptor.CepheAdaptor;
import com.hr190032.berkay_baran_final.model.CepheModel;
import com.hr190032.berkay_baran_final.network.Service;
import com.hr190032.berkay_baran_final.util.Constants;
import com.hr190032.berkay_baran_final.util.ObjectUtil;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;  //Bu Activity'de Cardview'i getirir ve kullanıcıdan komut bekler. Secilen card'in bilgilerini sonraki ekranda gosterir.
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        init();
        showDialog();
    }

    private  void  init()
    {
        cepheleriGetir();
    }

    void  cepheleriGetir()
    {

        new Service().getServiceApi().CepheleriGetir().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CepheModel>>() {

                    List<CepheModel> cepheler=new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("RETROFIT","onSubscribe : ");
                    }

                    @Override
                    public void onNext(List<CepheModel> cepheList) {
                        Log.e("RETROFIT","onNext : ");
                        cepheler=cepheList;
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("RETROFIT","onError : " + e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete()
                    {
                        Log.e("RETROFIT","onComplete : ");

                        if(cepheler.size()>0) {
                            initRecycleView(cepheler);
                        }
                    }
                });
    }
    private  void  initRecycleView(List<CepheModel> cepheList)
    {
        recyclerView =findViewById(R.id.rcvCephe);
        CepheAdaptor cepheAdaptor =new CepheAdaptor(cepheList, getApplicationContext(), new CepheAdaptor.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                CepheModel tiklananCephe = cepheList.get(position);
                showDialog();
                opennextActivity(tiklananCephe);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(cepheAdaptor);
    }
    private void opennextActivity(CepheModel tiklananCephe){
        Intent secondActivityIntent=new Intent(getApplicationContext(),CepheDetayActivity.class);
        String tiklananCepheString = ObjectUtil.cepheToJsonString(tiklananCephe);
        secondActivityIntent.putExtra(Constants.NAME_OF_THE_SELECTED_CEPHE,tiklananCepheString);
        startActivity(secondActivityIntent);
    }

    private void showDialog(){
        progressDialog = new ProgressDialog(ListActivity.this);
        progressDialog.setMessage(getString(R.string.lutfenBekleyinizTxt));
        progressDialog.setTitle(getString(R.string.progressDialog));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
    }
    public class BackButtonClosed extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);
        }
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(getString(R.string.cikisTxt));
        builder.setPositiveButton(getString(R.string.evetButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton(getString(R.string.hayirButton), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
