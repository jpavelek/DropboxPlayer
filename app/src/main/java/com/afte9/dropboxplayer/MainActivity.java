package com.afte9.dropboxplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import com.afte9.dropboxplayer.PlaylistListContent.PlaylistListItem;

public class MainActivity extends AppCompatActivity implements FragmentPlaylists.OnListFragmentInteractionListener {

    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec;

        db = Database.getInstance();
        if (db.haveFavorites() == true) {
            //Tab Recent
            spec = host.newTabSpec("Tab recent");
            spec.setContent(R.id.tab_recent);
            spec.setIndicator(getString(R.string.tab_recent));
            host.addTab(spec);
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
    }
}