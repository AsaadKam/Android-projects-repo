package com.example.native_programmer.footplaycompetition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int goals_liver = 0;
    private int red_liver = 0;
    private int yellow_liver = 0;
    private int goals_city = 0;
    private int red_city = 0;
    private int yellow_city = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incr_goals_for_liver(View view) {
        display_liver_goals(++goals_liver);
    }

    public void incr_goals_for_city(View view) {
        display_city_goals(++goals_city);
    }

    public void incr_red_cards_for_Liver(View view) {
        display_liver_red(++red_liver);
    }

    public void incr_yellow_cards_for_Liver(View view) {
        display_liver_yellow(++yellow_liver);
    }

    public void incr_red_cards_for_city(View view) {
        display_city_red(++red_city);
    }

    public void incr_yellow_cards_for_city(View view) {
        display_city_yellow(++yellow_city);
    }

    public void reset(View view) {
        display_liver_goals(goals_liver = 0);
        display_city_goals(goals_city = 0);
        display_liver_red(red_liver = 0);
        display_liver_yellow(yellow_liver = 0);
        display_city_red(red_city = 0);
        display_city_yellow(yellow_city = 0);
    }

    public void display_liver_goals(int number) {
        TextView view_liver_goals = (TextView) findViewById(R.id.goals_ID_liver);
        view_liver_goals.setText("" + number);
    }

    public void display_city_goals(int number) {
        TextView view_city_goals = (TextView) findViewById(R.id.goals_ID_city);
        view_city_goals.setText("" + number);
    }

    public void display_liver_red(int number) {
        TextView view_liver_red = (TextView) findViewById(R.id.red_ID_liver);
        view_liver_red.setText(number + " Red cards   ");
    }

    public void display_liver_yellow(int number) {
        TextView view_liver_yellow = (TextView) findViewById(R.id.yellow_ID_liver);
        view_liver_yellow.setText(number + " Yellow cards");
    }

    public void display_city_red(int number) {
        TextView view_city_red = (TextView) findViewById(R.id.red_ID_city);
        view_city_red.setText(number + " Red cards   ");
    }

    public void display_city_yellow(int number) {
        TextView view_city_yellow = (TextView) findViewById(R.id.yellow_ID_city);
        view_city_yellow.setText(number + " Yellow cards");
    }
}