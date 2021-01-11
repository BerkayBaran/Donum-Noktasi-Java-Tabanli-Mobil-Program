package com.hr190032.berkay_baran_final.network;

import com.hr190032.berkay_baran_final.model.CepheModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("TarihApi.json") //Github sayfamdaki json dosyasını hangi endpoint'inin hangi fonskiyon oldugunu ayarlıyor.
    Observable<List<CepheModel>> CepheleriGetir();
}
