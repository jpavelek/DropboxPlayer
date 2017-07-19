package com.afte9.dropboxplayer;



class Database {
    private static final Database ourInstance = new Database();

    static Database getInstance() {
        return ourInstance;
    }

    private static String[] db;

    private Database() {
    }

    //This is fake now  - just made string array for listViews
    //In future this should be some observer pattern updating database with filesystem changes
    protected void readFiles() {
        //FIXME - this needs real implementation one day
        db = new String[] {"Hallo", "There", "Many more", "Weekend and more", "Mas que nada", "Scratch the pitch", "Nevermind"};
    }

    protected boolean haveFavorites() {
        return false; //FIXME - implement favorites checks
    }

    protected String[] getPlaylists() {
        return db;
    }
}
