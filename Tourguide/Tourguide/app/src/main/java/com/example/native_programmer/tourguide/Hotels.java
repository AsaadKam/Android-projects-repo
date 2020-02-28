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
public class Hotels extends Fragment {


    public Hotels() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate( R.layout.places_list , container, false);


        final ArrayList<androidPlace> androidPlaces = new ArrayList<androidPlace>();
        androidPlaces.add( new androidPlace("Baron Palace Sahl Hasheesh"          , "5 stars"    , R.drawable.firsthotel     )   );
        androidPlaces.add( new androidPlace( "Stella Di Mare Beach Hotel & Spa"   , "4 stars"    , R.drawable.secondhotel    )   );
        androidPlaces.add( new androidPlace("Hilton Luxor Resort & Spa "          , "3 stars"    , R.drawable.thirdhotel     )   );
        androidPlaces.add( new androidPlace( "Barcelo Tiran Sharm  "              , "6 stars"    , R.drawable.fourthhotel    )   );



        // Create an {@link PlaceAdapter}, whose data source is a list of
        // {@link AndroidPlace}s. The adapter knows how to create list item views for each item
        // in the list.
        PlaceAdapter HotelsAdapter = new PlaceAdapter(getActivity(), androidPlaces,R.color.coral );

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView HotelsListView = (ListView) rootView.findViewById( R.id.list );
        HotelsListView.setAdapter( (ListAdapter) HotelsAdapter );
        return rootView;
    }


}
