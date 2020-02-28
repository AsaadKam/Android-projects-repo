package com.example.native_programmer.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreOverall;
    int questionOne;
    int questionTwo;
    int questionThree;
    int questionFour;
    int checkBoxOne;
    int checkBoxTwo;
    int checkBoxThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void results(View view) {



                 /****This protion of code is for radio button for question one****/
        RadioButton viewTrueQ1 = (RadioButton) findViewById(R.id.true_radio_button_1);
        RadioButton viewFalseQ1 = (RadioButton) findViewById(R.id.false_radio_button_1);
        if(  (viewFalseQ1.isChecked())   &&  (!(viewTrueQ1.isChecked()))   ) questionOne=1;
        else questionOne=0;
                  /****This protion of code is for radio button for question two****/
        RadioButton viewTrueQ2 = (RadioButton) findViewById(R.id.true_radio_button_2);
        RadioButton viewFalseQ2 = (RadioButton) findViewById(R.id.false_radio_button_2);
        if(  (viewTrueQ2.isChecked())    &&  (!(viewFalseQ2.isChecked()))  ) questionTwo=1;
        else questionTwo=0;
                  /****This protion of code is for Check Box for question three****/
        CheckBox notifyMeCheckBoxOne = (CheckBox) findViewById(R.id.notify_me_checkbox_1);
        CheckBox notifyMeCheckBoxTwo = (CheckBox) findViewById(R.id.notify_me_checkbox_2);
        CheckBox notifyMeCheckBoxThree = (CheckBox) findViewById(R.id.notify_me_checkbox_3);
        if((notifyMeCheckBoxOne.isChecked())&&(notifyMeCheckBoxTwo.isChecked())&&(!(notifyMeCheckBoxThree.isChecked()))) questionThree=1;
        else questionThree=0;
                  /****This protion of code is for Check Box for question four****/
        EditText viewEditText = (EditText) findViewById(R.id.editText_1);
        String str=viewEditText.getText().toString();
        if("float".equals(str)) questionFour=1;
        else questionFour=0;
                 /****This protion of code is for dispalying score by toast****/
        scoreOverall = questionOne + questionTwo + questionThree + questionFour;
        Context context = getApplicationContext();
        CharSequence text;
        if(scoreOverall==4)
            text = "Congratulation you succesed!!!";
        else
            text = "Try again, your overall Score=" + scoreOverall + " out of 4.";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }
}


