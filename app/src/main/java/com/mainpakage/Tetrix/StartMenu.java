package com.mainpakage.Tetrix;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartMenu extends AppCompatActivity {
    int thm;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menu);
        final Button butCl = (Button) findViewById(R.id.butClassic);
        final Button butSp = (Button) findViewById(R.id.butSpooky);
        final Button butTut = (Button) findViewById(R.id.butTutorial);
        butCl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    butCl.setBackgroundResource(R.drawable.classicpressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    butCl.setBackgroundResource(R.drawable.classic);
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    thm = 0;
                    intent.putExtra("theme", thm);
                    startActivityForResult(intent, 0);
                    return true;
                }
                return false;
            }

            /*@Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                thm=0;
                intent.putExtra("theme", thm);
                startActivityForResult(intent, 0);
            }*/
        });

        butSp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    butSp.setBackgroundResource(R.drawable.choosespookypressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    butSp.setBackgroundResource(R.drawable.choosespooky);
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    thm = 1;
                    intent.putExtra("theme", thm);
                    startActivityForResult(intent, 0);
                    return true;
                }
                return false;
            }
        });
        butTut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Tutorial.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onBackPressed(){

    }

}