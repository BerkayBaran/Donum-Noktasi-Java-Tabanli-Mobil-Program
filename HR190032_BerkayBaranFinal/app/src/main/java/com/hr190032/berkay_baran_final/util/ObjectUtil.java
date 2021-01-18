package com.hr190032.berkay_baran_final.util;

import com.google.gson.Gson;
import com.hr190032.berkay_baran_final.model.CepheModel;

public class ObjectUtil {

    //CepheModel'i Gson ile json ile esitleyip return ediyoruz.

    public  static String cepheToJsonString(CepheModel cepheModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(cepheModel);
    }

    public  static CepheModel jsonStringToCephe(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,CepheModel.class);
    }
}

