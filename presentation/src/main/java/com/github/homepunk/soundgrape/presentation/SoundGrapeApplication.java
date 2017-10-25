package com.github.homepunk.soundgrape.presentation;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Homepunk on 18.10.2017.
 **/

public class SoundGrapeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
