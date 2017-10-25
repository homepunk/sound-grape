package com.github.homepunk.soundgrape.presentation.browser.adapter.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Homepunk on 11.10.2017.
 **/

public class HolderBindingAdapter {
    @BindingAdapter("app:src")
    public static void setBackgroundColor(CircleImageView view, int colorResId) {
        int color = ContextCompat.getColor(view.getContext(), colorResId);
        ColorDrawable colorDrawable = new ColorDrawable(color);
        view.setImageDrawable(colorDrawable);
    }
}
