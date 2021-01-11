package com.hr190032.berkay_baran_final.network;

import com.hr190032.berkay_baran_final.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {

    //Retrofitler ile ilgili ayarlar burada yapiliyor.
    private static Retrofit retrofit;
    private static Retrofit getRetrofit() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(getOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    static OkHttpClient okHttpClient;
    private static OkHttpClient getOkHttpClient()
    {
        if(okHttpClient == null) {
            okHttpClient =  new OkHttpClient().newBuilder().build();
        }

        return okHttpClient;
    }

    ServiceApi serviceApi;
    public ServiceApi getServiceApi() { //Endpoint'leri belirttigimiz dosyanın ayarlarını yapıyoruz.

        if(serviceApi == null) {
            serviceApi = getRetrofit().create(ServiceApi.class);
        }

        return serviceApi;
    }

}
