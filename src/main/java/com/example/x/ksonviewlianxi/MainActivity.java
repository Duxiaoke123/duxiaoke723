package com.example.x.ksonviewlianxi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void add(View view) {
        DotRandView dotRandView  = findViewById(R.id.dotview);
        dotRandView.addDot();
    }
}
