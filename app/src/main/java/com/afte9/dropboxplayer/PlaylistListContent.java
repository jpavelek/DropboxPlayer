package com.afte9.dropboxplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(PlaylistListItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaylistListItem createDummyItem(int position) {
        return new PlaylistListItem(String.valueOf(position), "Item " + position, "23", makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class PlaylistListItem {
        public final String id;
        public final String playlist_name;
        public final String nr_items;
        public final String details;

        public PlaylistListItem(String id, String playlist, String items, String details) {
            this.id = id;
            this.playlist_name = playlist;
            this.details = details;
            this.nr_items = items;
        }

        @Override
        public String toString() {
            return playlist_name;
        }
    }
}
