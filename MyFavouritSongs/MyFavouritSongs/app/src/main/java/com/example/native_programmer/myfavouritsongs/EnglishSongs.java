package com.example.native_programmer.myfavouritsongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EnglishSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_english_songs );


        final ArrayList<androidMusic> androidMusics = new ArrayList<androidMusic>();
        androidMusics.add( new androidMusic( "Love Song", "Sara Bareilles", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "Love Story", "Taylor Swift", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "Part-Time Lover", "Stevie Wonder ", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "You've Lost That Lovin' Feelin", "The Righteous Brothers", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "This Guy's In Love With You", "Herb Alpert", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "That's The Way Love Goes", "Janet Jackson ", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "The Power of Love", "Celine Dion", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "I Love You Always Forever", "Donna Lewis", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "Love Hangover", "Diana Ross ", R.drawable.playbuttonone ) );
        androidMusics.add( new androidMusic( "What’s Love Got to Do With It", "Tina Turner", R.drawable.playbuttonone ) );

        // Create an {@link MusicAdapter}, whose data source is a list of
        // {@link AndroidMusic}s. The adapter knows how to create list item views for each item
        // in the list.
        MusicAdapter EnglishSongAdapter = new MusicAdapter( this, androidMusics );

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView englishListView = (ListView) findViewById( R.id.listview_English_Song );
        englishListView.setAdapter( EnglishSongAdapter );
        englishListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                androidMusic listRow = androidMusics.get( position );
                Intent playingNow = new Intent( EnglishSongs.this, playingNowActivity.class );
                playingNow.putExtra( "Song", listRow.getSongName() );
                startActivity( playingNow );
            }

        } );
    }


}
