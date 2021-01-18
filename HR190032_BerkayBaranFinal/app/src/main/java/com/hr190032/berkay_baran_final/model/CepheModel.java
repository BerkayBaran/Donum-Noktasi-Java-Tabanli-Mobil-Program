package com.hr190032.berkay_baran_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CepheModel {
    //Json modeli için yazılmıs olan kod.
    @SerializedName("Cephe")
    @Expose
    private String cephe;
    @SerializedName("Tarih")
    @Expose
    private String tarih;
    @SerializedName("Sehit Sayisi")
    @Expose
    private String sehitSayisi;
    @SerializedName("Sonuc")
    @Expose
    private String sonuc;
    @SerializedName("KapakUrl")
    @Expose
    private String kapakUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;

    public String getCephe() {
        return cephe;
    }

    public void setCephe(String cephe) {
        this.cephe = cephe;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSehitSayisi() {
        return sehitSayisi;
    }

    public void setSehitSayisi(String sehitSayisi) {
        this.sehitSayisi = sehitSayisi;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public String getKapakUrl() {
        return kapakUrl;
    }

    public void setKapakUrl(String kapakUrl) {
        this.kapakUrl = kapakUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

}
