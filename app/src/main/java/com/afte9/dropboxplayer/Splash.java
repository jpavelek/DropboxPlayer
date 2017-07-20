package com.afte9.dropboxplayer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Database db = Database.getInstance();
        db.readFiles();

        CountDownTimer t = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //do nothing
            }

            @Override
            public void onFinish() {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        }.start();


    }
}
