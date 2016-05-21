package com.example.euibp.alpha;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by euibp on 20/05/2016.
 */
public class SplashStart extends AppCompatActivity {
    private static int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(SplashStart.this,Main.class);
                startActivity(splashIntent);
                finish();
            }
        },SPLASH_TIME);

    }
}
