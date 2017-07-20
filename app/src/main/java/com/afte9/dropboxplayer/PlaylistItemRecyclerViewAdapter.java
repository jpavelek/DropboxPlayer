package com.afte9.dropboxplayer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.afte9.dropboxplayer.FragmentPlaylists.OnListFragmentInteractionListener;
import com.afte9.dropboxplayer.PlaylistListContent.PlaylistListItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a PlalistListItem and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PlaylistItemRecyclerViewAdapter extends RecyclerView.Adapter<PlaylistItemRecyclerViewAdapter.ViewHolder> {

    //private final List<PlaylistListContent> mValues;
    private List<PlaylistListContent.PlaylistListItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public PlaylistItemRecyclerViewAdapter(List<PlaylistListItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_playlists_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //TODO - set custom playlist icon here eventually
        holder.mPlaylistNameView.setText(mValues.get(position).playlist_name);
        holder.mNumberofItemsView.setText(mValues.get(position).nr_items);

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
        public final ImageView mIconView;
        public final TextView mPlaylistNameView;
        public final TextView mNumberofItemsView;
        public PlaylistListItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIconView = (ImageView) view.findViewById(R.id.imageView_playlist_icon);
            mPlaylistNameView = (TextView) view.findViewById(R.id.textView_playlist_name);
            mNumberofItemsView = (TextView) view.findViewById(R.id.textView_number_of_items);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mPlaylistNameView.getText() + "'";
        }
    }
}
