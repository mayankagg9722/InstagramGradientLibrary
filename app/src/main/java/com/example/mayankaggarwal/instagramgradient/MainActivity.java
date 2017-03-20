package com.example.mayankaggarwal.instagramgradient;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((com.example.animatebackground.AnimateActivity)findViewById(R.id.mylayout)).setColor(Color.parseColor("#f754e1"));
    }

}
