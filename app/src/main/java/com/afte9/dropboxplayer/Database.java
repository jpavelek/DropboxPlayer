package com.afte9.dropboxplayer;

import java.io.IOException;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

class Database {
    private static final Database ourInstance = new Database();
    private static final String DBX_ACCESS_TOKEN = "gn_DmlOdsXwAAAAAAAAADAm6YDXZGBg6EWb--MzKQtWGWTI74XI1bdpONsNZE7Va";

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

    public void linkDropbox() throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("digitalnoise/0.1");
        DbxClientV2 client = new DbxClientV2(config, DBX_ACCESS_TOKEN);

        // Get current account info
        FullAccount account = client.users().getCurrentAccount();
        System.out.println(account.getName().getDisplayName());

        // Get files and folder metadata from Dropbox root directory
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }


    }
}
