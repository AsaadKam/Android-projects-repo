package com.example.native_programmer.tourguide;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class PlaceAdapter extends ArrayAdapter<androidPlace> {
    private static final String LOG_TAG = PlaceAdapter.class.getSimpleName();
    private final ArrayList<androidPlace> androidMusics;
    private final int adapterColorId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context       The current context. Used to inflate the layout file.
     * @param androidPlaces A List of AndroidPlace objects to display in a list
     */
    public PlaceAdapter(Activity context, ArrayList<androidPlace> androidPlaces, int colorId ) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super( context, 0, androidPlaces );
        adapterColorId=colorId;
        this.androidMusics = androidPlaces;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from( getContext() ).inflate(R.layout.list_item, parent, false );
        }

        // Get the {@link AndroidPlace} object located at this position in the list
        androidPlace currentAndroidPlace = getItem( position );
        int color=ContextCompat.getColor( getContext(),adapterColorId );
        listItemView.findViewById( R.id.listItem ).setBackgroundColor( color );

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView PlaceNameTextView = (TextView) listItemView.findViewById( R.id.list_item_place_name );

        // Get the version name from the current AndroidPlace object and
        // set this text on the name of place TextView
        PlaceNameTextView.setText( currentAndroidPlace.getPlaceName() );

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView InformationNameTextView = (TextView) listItemView.findViewById( R.id.list_item_information_name );
        // Get the version number from the current AndroidPlace object and
        // set this text on the Place name TextView
        InformationNameTextView.setText( currentAndroidPlace.getInformationName() );

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById( R.id.list_item_image );
        // Get the image resource ID from the current AndroidPlace object and
        // set the image to place
        iconView.setImageResource( currentAndroidPlace.getImageResourceId() );

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}


