package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        v = (View) findViewById(R.id.view);

        CustomView cv = new CustomView(this);

        v = cv;

        setContentView(R.layout.activity_main);
    }








}
