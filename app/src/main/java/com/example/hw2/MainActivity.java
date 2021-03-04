package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        Face face = findViewById(R.id.surfaceView);

        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(face);

        //SeekBar
        SeekBar redBar = (SeekBar)findViewById(R.id.R_Bar);
        redBar.setOnSeekBarChangeListener(face);


        SeekBar blueBar = (SeekBar)findViewById(R.id.B_Bar);
        blueBar.setOnSeekBarChangeListener(face);

        SeekBar greenBar = (SeekBar)findViewById(R.id.G_bar);
        greenBar.setOnSeekBarChangeListener(face);

        //Radio Group
        RadioGroup group = (RadioGroup) findViewById(R.id.Radio_Group);
        group.setOnCheckedChangeListener(face);



        //Button
        Button Rand = (Button)findViewById(R.id.Random_Button);
        Rand.setOnClickListener(face);
    }


}