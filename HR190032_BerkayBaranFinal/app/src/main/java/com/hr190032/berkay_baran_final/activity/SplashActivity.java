package com.hr190032.berkay_baran_final.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.hr190032.berkay_baran_final.R;
import com.hr190032.berkay_baran_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000; //Splash Ekranı, öncelikle internet kontrolunu NetworkUtil'den alıp sonra logoyu 3 saniye gostererir ve sonraki ekrana gecer. Internet yoksa gerekli islemler yapilir.
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (NetworkUtil.getInstance(this).checkConnection()){
            Toast.makeText(getApplicationContext(), getString(R.string.interneteBaglanildiTxt), Toast.LENGTH_SHORT).show();
            splashActivity();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
            builder.setTitle(getString(R.string.internetBaglantisiYokTxt));
            builder.setMessage(getString(R.string.interneteBaglanTxt));
            builder.setNegativeButton(getString(R.string.kapatButton), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finishAffinity();
                }
            });
            builder.setPositiveButton(getString(R.string.internetiAcButton), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);

                }
            });
            builder.show();
        }
    }
    public void splashActivity(){

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, ListActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}