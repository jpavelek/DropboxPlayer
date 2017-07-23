package com.afte9.dropboxplayer.FragmentSongs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afte9.dropboxplayer.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a PlalistListItem and makes a call to the
 * specified {@link FragmentSongs.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SongsItemRecyclerViewAdapter extends RecyclerView.Adapter<SongsItemRecyclerViewAdapter.ViewHolder> {

    //private final List<SongsListContent> mValues;
    private List<SongsListContent.SongsListItem> mValues;
    private final FragmentSongs.OnListFragmentInteractionListener mListener;

    public SongsItemRecyclerViewAdapter(List<SongsListContent.SongsListItem> items, FragmentSongs.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_songlist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mSongNameView.setText(mValues.get(position).song_name);
        holder.mSongArtistView.setText(mValues.get(position).artist);
        holder.mPlaytimeView.setText(mValues.get(position).playtime);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mSongNameView;
        public final TextView mSongArtistView;
        public final TextView mPlaytimeView;
        public SongsListContent.SongsListItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSongNameView = (TextView) view.findViewById(R.id.textView_song_name);
            mSongArtistView = (TextView) view.findViewById(R.id.textView_song_artist);
            mPlaytimeView = (TextView) view.findViewById(R.id.textView_playtime);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSongNameView.getText() + "'";
        }
    }
}
