package com.example.native_programmer.myfavouritsongs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        addListenerOnButton( R.id.EnglishSongButton );
        addListenerOnButton( R.id.ArabicSongButton );
    }


    public void addListenerOnButton(int IdButton) {

        Button button = (Button) findViewById( IdButton );
        if (IdButton == R.id.EnglishSongButton) {
            button.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    Intent EnglishActivity = new Intent( MainActivity.this, EnglishSongs.class );
                    startActivity( EnglishActivity );

                }

            } );

        } else {
            button.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    Intent ArabicActivity = new Intent( MainActivity.this, ArabicSongs.class );
                    startActivity( ArabicActivity );

                }

            } );

        }


    }


}

