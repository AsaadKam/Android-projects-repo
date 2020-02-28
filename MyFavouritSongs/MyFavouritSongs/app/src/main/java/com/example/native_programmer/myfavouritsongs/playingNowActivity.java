package com.example.native_programmer.myfavouritsongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class playingNowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_playing_now );

        Intent songListsRequest = getIntent();
        String songName = songListsRequest.getStringExtra( "Song" );
        TextView nowPlayingSongName = (TextView) findViewById( R.id.songName );
        nowPlayingSongName.setText( songName );

        Button homeButton = (Button) findViewById( R.id.HomeButton );
        homeButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent retrunHome = new Intent( playingNowActivity.this, MainActivity.class );
                startActivity( retrunHome );


            }
        } );
    }
}
