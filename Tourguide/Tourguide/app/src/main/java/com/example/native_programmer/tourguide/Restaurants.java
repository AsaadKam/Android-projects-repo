package com.example.native_programmer.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Restaurants extends Fragment {


    public Restaurants() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.places_list , container, false);
        final ArrayList<androidPlace> androidPlaces = new ArrayList<androidPlace>();
        androidPlaces.add( new androidPlace("aestro Italian Restaurant"                       ,"medium rate"     , R.drawable.firstrestaurants )     );
        androidPlaces.add( new androidPlace( "Birdcage"                                       , "medium rate"    , R.drawable.secondrestaurants)     );
        androidPlaces.add( new androidPlace("The Grill Restaurant & Lounge"                   , "high rate"      , R.drawable.thirdrestaurants )     );
        androidPlaces.add( new androidPlace( "Fayruz Lebanese Restaurant"                     , "medium rate"    , R.drawable.forthrestaurants )     );




        // Create an {@link PlaceAdapter}, whose data source is a list of
        // {@link AndroidPlace}s. The adapter knows how to create list item views for each item
        // in the list.
        PlaceAdapter RestaurantsAdapter = new PlaceAdapter(getActivity(), androidPlaces,R.color.gray);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView RestaurantsListView = (ListView) rootView.findViewById( R.id.list );
        RestaurantsListView.setAdapter( (ListAdapter) RestaurantsAdapter );
        return rootView;
    }


}
