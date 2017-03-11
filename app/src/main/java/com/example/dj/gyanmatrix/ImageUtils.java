package com.example.dj.gyanmatrix;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by DJ on 11-03-2017.
 */

public class ImageUtils {


    public static void setCircularImage(Context context, String url, ImageView imageView, int stubImage) {
        Picasso.with(context).load(url).
                transform(new CircleImageTransformer()).
                centerCrop().fit()
                .placeholder(ContextCompat.getDrawable(context, stubImage))
                .error(stubImage).
                into(imageView);
    }

    public static void setImage(Context context, String url, ImageView imageView, int stubImage) {
        Picasso.with(context).load(url).
                placeholder(ContextCompat.getDrawable(context, stubImage))
                .error(stubImage).centerCrop().fit().
                into(imageView);
    }
}