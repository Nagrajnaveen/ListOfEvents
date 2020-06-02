package com.app.bookmyevent.activities;

import android.app.Application;

import timber.log.Timber;

public class PusherApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
