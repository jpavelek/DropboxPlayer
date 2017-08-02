package com.afte9.dropboxplayer;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.dropbox.core.DbxException;
import com.dropbox.core.android.AuthActivity;

import java.io.IOException;

public class Splash extends AuthActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //FIXME - this is a hack - we should not do networking / long running operations in UI thread but spin new thread instead
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        Database db = Database.getInstance();
        db.readFiles();
        try {
            db.linkDropbox();
        } catch (DbxException e){
            Log.d("DigiNoise", "Dropbox exception" + e);
            //TODO - handle Dropbox exception
        } catch (IOException e) {
            Log.d("DigiNoise", "IOException" + e);
            //TODO - handle IO exception
        }

        CountDownTimer t = new CountDownTimer(1000, 1000) {
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
