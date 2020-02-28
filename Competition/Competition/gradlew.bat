package com.example.native_programmer.competition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int goals_liver=0;
    int red_liver=0;
    int yellow_liver=0;
    int goals_city=0;
    int red_city=0;
    int yellow_city=0;
    TextView view_liver_goals=(TextView)findViewById(R.id.goals_ID_liver);
    TextView view_city_goals=(TextView)findViewById(R.id.goals_ID_city);
    TextView view_liver_red=(TextView)findViewById(R.id.red_ID_liver);
    TextView view_liver_yellow=(TextView)findViewById(R.id.yellow_ID_liver);
    TextView view_city_red=(TextView)findViewById(R.id.red_ID_city);
    TextView view_city_yellow=(TextView)findViewById(R.id.yellow_ID_city);

    public void incr_goals_for_liver()
    {
        goals_liver++;
        view_liver_goals.setText(goals_liver);
    }
    public void  incr_goals_for_city()
    {
        goals_city++;
        view_city_goals.setText(goals_city);

    }

    public void incr_red_cards_for_Liver()
    {
        red_liver++;
        view_liver_red.setText((red_liver+"Red cards.");

    }

    public void incr_red_cards_for_city()
    {
        red_city++;
        view_city_red.setText(red_city+"Red cards.");
    }

    public void incr_yellow_cards_for_Liver()
    {
        yellow_liver++;
        view_liver_yellow.setText(yellow_liver+"Yellow cards.");
    }

    public void incr_yellow_cards_for_city()
    {
        yellow_city++;
        view_city_yellow.setText(yellow_city+"Yellow cards.");
    }


}
                                                                                                                                                                                                                                                                                                                                                                                                                                                 