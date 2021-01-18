package com.hr190032.berkay_baran_final.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideUtil {

    //Bu util sayesinde sayfalarimizda resimleri gosteriyoruz.

    public  static  void showImage(Context context, String url, ImageView img)
    {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .into(img);
    }

}
