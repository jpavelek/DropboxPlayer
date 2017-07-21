package com.afte9.dropboxplayer.FragmentPlaylists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 */
public class PlaylistListContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<PlaylistListItem> ITEMS = new ArrayList<PlaylistListItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, PlaylistListItem> ITEM_MAP = new HashMap<String, PlaylistListItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaylistItem(i));
        }
    }

    private static void addItem(PlaylistListItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaylistListItem createPlaylistItem(int position) {
        //FIXME - this is creating dummy items, make it create real ones
        Random rand = new Random();
        int r = rand.nextInt(99);

        return new PlaylistListItem(String.valueOf(position), "Item " + position, String.valueOf(r), "Abba, Queen and Nirvana ", "1:23:45");
    }

    /**
     * Item representing a piece of content.
     */
    public static class PlaylistListItem {
        public final String id; //Used for the hash function
        public final String playlist_name;
        public final String nr_items;
        public final String playtime;
        public final String artists;

        public PlaylistListItem(String id, String playlist_name, String nr_items, String artists, String playtime) {
            this.id = id;
            this.playlist_name = playlist_name;
            this.nr_items = nr_items;
            this.artists = artists;
            this.playtime = playtime;
        }

        @Override
        public String toString() {
            return playlist_name;
        }
    }
}
