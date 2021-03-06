package com.afte9.dropboxplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;

import com.afte9.dropboxplayer.Playlists.FragmentPlaylists;
import com.afte9.dropboxplayer.Playlists.PlaylistListContent.PlaylistListItem;

public class MainActivity extends AppCompatActivity implements FragmentPlaylists.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec;

        Database db = Database.getInstance();
        if (db.haveFavorites()) {
            //Tab Recent
            spec = host.newTabSpec("Tab recent");
            spec.setContent(R.id.tab_recent);
            spec.setIndicator(getString(R.string.tab_recent));
            host.addTab(spec);
        } else {
            findViewById(R.id.f_recent_playlists).setVisibility(View.INVISIBLE);
        }

        //Tab Music
        spec = host.newTabSpec("Tab music");
        spec.setContent(R.id.tab_music);
        spec.setIndicator(getString(R.string.tab_music));
        host.addTab(spec);

        //Tab Videos
        spec = host.newTabSpec("Tab video");
        spec.setContent(R.id.tab_video);
        spec.setIndicator(getString(R.string.tab_videos));
        host.addTab(spec);


        //Tab All
        spec = host.newTabSpec("Tab all");
        spec.setContent(R.id.tab_all);
        spec.setIndicator(getString(R.string.tab_all));
        host.addTab(spec);

    }


    @Override
    public void onListFragmentInteraction(PlaylistListItem item) {
        Log.d("DBP", "List fragment callback");
        //TODO - implement playlist selection, launch Audio/Video playback activity
        Intent i = new Intent(this, ActivityAudioPlayback.class);
        startActivity(i);
    }
}