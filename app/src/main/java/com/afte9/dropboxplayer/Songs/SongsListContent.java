package com.afte9.dropboxplayer.FragmentSongs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class SongsListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<SongsListItem> ITEMS = new ArrayList<SongsListItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, SongsListItem> ITEM_MAP = new HashMap<String, SongsListItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createSongsItem(i));
        }
    }

    private static void addItem(SongsListItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static SongsListItem createSongsItem(int position) {
        //FIXME - this is creating dummy items, make it create real ones
        Random rand = new Random();
        int r = rand.nextInt(99);

        return new SongsListItem(String.valueOf(position), "Item " + position, "Nirvana ", "1:23:45");
    }

    /**
     * Item representing a piece of content.
     */
    public static class SongsListItem {
        public final String id; //Used for the hash function
        public final String song_name;
        public final String playtime;
        public final String artist;

        public SongsListItem(String id, String song_name, String artist, String playtime) {
            this.id = id;
            this.song_name = song_name;
            this.artist = artist;
            this.playtime = playtime;
        }

        @Override
        public String toString() {
            return song_name;
        }
    }
}
