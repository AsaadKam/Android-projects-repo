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
public class Museums extends Fragment {


    public Museums() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.places_list , container, false);



        final ArrayList<androidPlace> androidPlaces = new ArrayList<androidPlace>();
        androidPlaces.add( new androidPlace("Egyptian Museum "                                , "In Cairo"       , R.drawable.firstmuseuem )     );
        androidPlaces.add( new androidPlace( "Alexandria National Museum"                     , "In Alexandria"  , R.drawable.secondmuseuem)     );
        androidPlaces.add( new androidPlace("Greeko Roman museum"                             , "In Alexandria"  , R.drawable.thirdmuseuem )     );
        androidPlaces.add( new androidPlace( "Luxor Museumt"                                  , "In Luxor"       , R.drawable.forthmuseuem )     );


        // Create an {@link PlaceAdapter}, whose data source is a list of
        // {@link AndroidPlace}s. The adapter knows how to create list item views for each item
        // in the list.
        PlaceAdapter MuseumsAdapter = new PlaceAdapter(getActivity(), androidPlaces,R.color.green );

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView MuseumsListView = (ListView) rootView.findViewById( R.id.list );
        MuseumsListView.setAdapter( (ListAdapter) MuseumsAdapter );
        return rootView;
    }


}
