package com.clicklabs.makeapi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    //Time out for Splash screen 10secs.
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startApp = new Intent(SplashActivity.this, CountryList.class);
                startActivity(startApp);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
