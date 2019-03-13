package com.clicklabs.makeapi;

import android.app.Application;

import io.paperdb.Paper;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Paper.init(this);
    }
}
