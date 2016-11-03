package com.afte9.dropboxplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Now read files
        readDBFolder();


    }
    private void readDBFolder() {
        //Will likely need some magic and probing to find Dropbox folder first
        File dbdir = new File("/");

        if (!dbdir.exists()) {
            System.out.println("Could not open the directory");
            return;
        }

        if (dbdir.isFile()) {
            System.out.println("Opened location should be a Dropbox directory, not a file.");
            return;
        }

        File dbcontents[] = dbdir.listFiles();

        if (dbcontents == null) {
            System.out.println("Opened Dropbox folder is empty.");
            return;
        }

        for (File dbdiritem : dbcontents) {
            if (dbdiritem.isFile()) {
                Playable tmpp = new Playable();
                System.out.println("FILE " + dbdiritem.getAbsolutePath());
                tmpp.filename = dbdiritem.getAbsolutePath();
            }
        }

    }
}
