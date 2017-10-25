package com.github.homepunk.soundgrape.presentation.base;

import android.content.Intent;
import android.databinding.BaseObservable;

/**
 * Created by Homepunk on 11.10.2017.
 **/

public abstract class BaseViewModel extends BaseObservable {
    public void onStart() {
        //Override me!
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Override me!
    }

    public void onResume() {
        //Override me!
    }

    public void onBackPressed() {
        //Override me!
    }
}
