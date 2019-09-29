package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomView v = new CustomView(this);


        //this.setContentView(v);
        this.setContentView(R.layout.activity_main);
    }








}
