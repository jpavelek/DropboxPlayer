package com.afte9.dropboxplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.afte9.dropboxplayer.Songs.FragmentSongs;
import com.afte9.dropboxplayer.Songs.SongsListContent;

public class ActivityAudioPlayback extends AppCompatActivity implements FragmentSongs.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_playback);
    }

    @Override
    public void onListFragmentInteraction(SongsListContent.SongsListItem item) {
        //TODO - implement this actually
        Log.d("DBP", "Method to select song not implemented");
    }
}
