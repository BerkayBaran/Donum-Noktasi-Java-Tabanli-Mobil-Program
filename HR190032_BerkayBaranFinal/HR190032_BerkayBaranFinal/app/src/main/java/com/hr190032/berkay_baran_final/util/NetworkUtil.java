package com.hr190032.berkay_baran_final.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUtil {

    //Bu util de internet baglantisini kontrol ediyoruz

    private static NetworkUtil instance = new NetworkUtil();
    static Context context;
    ConnectivityManager connectivityManager;
    NetworkInfo wifiInfo, mobileInfo;
    boolean connected = false;

    public static NetworkUtil getInstance(Context ctx) {
        context = ctx.getApplicationContext();
        return instance;
    }

    public boolean checkConnection() {
        try {
            connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected();
            return connected;


        } catch (Exception e) {
            System.out.println("Baglanilamadi Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }
        return connected;

    }
}