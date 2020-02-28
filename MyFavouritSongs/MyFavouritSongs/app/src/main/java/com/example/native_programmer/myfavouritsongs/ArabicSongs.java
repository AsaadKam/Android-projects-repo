package com.example.native_programmer.myfavouritsongs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ArabicSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_arabic_songs );

        final ArrayList<androidMusic> androidMusics = new ArrayList<androidMusic>();
        androidMusics.add( new androidMusic( "Number One", "Mohamed Ramadan", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Atawe3", " Mahmoud El Leithy", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Al Akhdar", "Dyler", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Yarohe", "Mohamed Alsalim", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Ana Ana", "Rashed Almajid, Majid Al Mohandis & Waleed Al Shami", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Ibiza", "Somadina", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Lmjanin", "Ali Deek & Layal Abboud", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "DJ Hamida ft. Dakka Tiiw Tiiw & Abdo Commando", "Chaabi do Brasil", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Elli Baana", "Ragheb Alama", R.drawable.playbuttontwo ) );
        androidMusics.add( new androidMusic( "Chafoni m3aha", "Mido Belahbib", R.drawable.playbuttontwo ) );

        // Create an {@link MusicAdapter}, whose data source is a list of
        // {@link AndroidMusic}s. The adapter knows how to create list item views for each item
        // in the list.
        MusicAdapter ArabicSongAdapter = new MusicAdapter( this, androidMusics );

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView arabicListView = (ListView) findViewById( R.id.listview_Arabic_Song );
        arabicListView.setAdapter( ArabicSongAdapter );
        arabicListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                androidMusic listRow = androidMusics.get( position );
                Intent playingNow = new Intent( ArabicSongs.this, playingNowActivity.class );
                playingNow.putExtra( "Song", listRow.getSongName() );
                startActivity( playingNow );
            }

        } );
    }

}
