package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView sc;
    CustomView customView;
    ImageView iv;
    Bitmap  bmpPiece;
    Bitmap  bmpPiece1;
    Bitmap  bmpPiece2;
    Bitmap  bmpPiece3;
    Bitmap  bmpPiece4;
    Bitmap  bmpPiece5;
    Bitmap  bmpPiece6;
    int thm;
    int palette;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bAux = getIntent().getExtras();

        palette=(int)(Math.random()*3); //  //For each theme there are 3 models of pieces
        thm=bAux.getInt("theme");
        if(thm==0){ //Classic Theme

            selectPalette(palette);

            ConstraintLayout back=(ConstraintLayout)findViewById(R.id.layout);      //set background
            back.setBackgroundResource(R.drawable.bgcl6);

            ImageView scoreBack=(ImageView)findViewById(R.id.scorebackground);
            scoreBack.setImageResource(R.drawable.scorecl);

            ImageView nP=(ImageView)findViewById(R.id.npbackground);
            nP.setImageResource(R.drawable.nextcl);

            TextView numScore=(TextView)findViewById(R.id.valorPuntuacion);
            Typeface golden=Typeface.createFromAsset(getAssets(),"goldenhills.ttf");
            numScore.setTypeface(golden);

            final ImageButton turn = (ImageButton)findViewById(R.id.girar);     //Set Button turn
            turn.setBackgroundResource(R.drawable.rotateclassic);    //change on XML
            turn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        turn.setBackgroundResource(R.drawable.rotatepresclassic);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.girar(customView.getActivePiece());
                        turn.setBackgroundResource(R.drawable.rotateclassic);
                        return true;
                    }
                    return false;
                }
            });

            final Button right=(Button)findViewById(R.id.flechader);          //Set button right
            right.setBackgroundResource(R.drawable.rightbutclassic);
            right.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        right.setBackgroundResource(R.drawable.rightpressclassic);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.moverDerechaActiva(customView.getActivePiece());
                        right.setBackgroundResource(R.drawable.rightbutclassic);
                        return true;
                    }
                    return false;
                }
            });

            final Button left=(Button)findViewById(R.id.flechaizq);          //Set button left
            left.setBackgroundResource(R.drawable.leftbutclassic);
            left.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        left.setBackgroundResource(R.drawable.leftpressclassic);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.moverIzquierdaActiva(customView.getActivePiece());
                        left.setBackgroundResource(R.drawable.leftbutclassic);
                        return true;
                    }
                    return false;
                }
            });

            final Button down=(Button)findViewById(R.id.flechabajo);          //Set button down
            down.setBackgroundResource(R.drawable.downbutclassic);
            down.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        customView.fastFall();
                        down.setBackgroundResource(R.drawable.downpresclassic);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.resetFall();
                        down.setBackgroundResource(R.drawable.downbutclassic);
                        return true;
                    }
                    return false;
                }
            });

            final Button swi=(Button)findViewById(R.id.Switch);          //Set button switch
            swi.setBackgroundResource(R.drawable.switchbutclassic);
            swi.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        swi.setBackgroundResource(R.drawable.switchpressedclassic);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.switchPiece();
                        swi.setBackgroundResource(R.drawable.switchbutclassic);
                        return true;
                    }
                    return false;
                }
            });
        }

        //-----------------------THEME SPOOKY---------------------------------

        else if(thm==1){    //Spooky theme
            palette+=3;
            selectPalette(palette);   //[0-2 (classic), 3-5 (spooky)]

            ConstraintLayout back=(ConstraintLayout)findViewById(R.id.layout);      //set background
            back.setBackgroundResource(R.drawable.bgsp0);

            ImageView scoreBack=(ImageView)findViewById(R.id.scorebackground);
            scoreBack.setImageResource(R.drawable.scoresp);

            ImageView nP=(ImageView)findViewById(R.id.npbackground);
            nP.setImageResource(R.drawable.nextsp);

            TextView numScore=(TextView)findViewById(R.id.valorPuntuacion);
            Typeface golden=Typeface.createFromAsset(getAssets(),"goldenhills.ttf");
            numScore.setTypeface(golden);

            final ImageButton turn = (ImageButton)findViewById(R.id.girar);     //Set Button turn
            turn.setBackgroundResource(R.drawable.rotatespoky);    //change on XML
            turn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        turn.setBackgroundResource(R.drawable.rotatepresspooky);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.girar(customView.getActivePiece());
                        turn.setBackgroundResource(R.drawable.rotatespoky);
                        return true;
                    }
                    return false;
                }
            });

            final Button right=(Button)findViewById(R.id.flechader);          //Set button right
            right.setBackgroundResource(R.drawable.rightbutspooky);
            right.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        right.setBackgroundResource(R.drawable.rightpressspoky);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.moverDerechaActiva(customView.getActivePiece());
                        right.setBackgroundResource(R.drawable.rightbutspooky);
                        return true;
                    }
                    return false;
                }
            });

            final Button left=(Button)findViewById(R.id.flechaizq);          //Set button left
            left.setBackgroundResource(R.drawable.leftbutspooky);
            left.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        left.setBackgroundResource(R.drawable.leftpresspoky);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.moverIzquierdaActiva(customView.getActivePiece());
                        left.setBackgroundResource(R.drawable.leftbutspooky);
                        return true;
                    }
                    return false;
                }
            });

            final Button down=(Button)findViewById(R.id.flechabajo);          //Set button down
            down.setBackgroundResource(R.drawable.downbutspooky);
            down.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        customView.fastFall();
                        down.setBackgroundResource(R.drawable.downpressspoky);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.resetFall();
                        down.setBackgroundResource(R.drawable.downbutspooky);
                        return true;
                    }
                    return false;
                }
            });

            final Button swi=(Button)findViewById(R.id.Switch);          //Set button switch
            swi.setBackgroundResource(R.drawable.switchbutspooky);
            swi.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        swi.setBackgroundResource(R.drawable.switchpressedspooky);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.switchPiece();
                        swi.setBackgroundResource(R.drawable.switchbutspooky);
                        return true;
                    }
                    return false;
                }
            });
        }



        customView=(CustomView) findViewById(R.id.CustomView);
        customView.setMa(this);
        sc = (TextView) findViewById(R.id.valorPuntuacion);
        iv= (ImageView) findViewById(R.id.nextpiecefig);
        Intent intent = new Intent (customView.getContext(), MainActivity.class);
        intent.putExtra("theme", thm);
        customView.st.start();
    }



    public void updateScore(String s){
        sc.setText(s);
    }


    public void changeGameOver(){
        Intent intent = new Intent (customView.getContext(), GameOver.class);
        intent.putExtra("Score", sc.getText().toString());
        startActivityForResult(intent, 0);
    }

    public void printNextPiece(int p){
        switch(p) {
            case 0:
                iv.setImageBitmap(bmpPiece);
                break;
            case 1:
                iv.setImageBitmap(bmpPiece1);
                break;
            case 2:
                iv.setImageBitmap(bmpPiece2);
                break;
            case 3:
                iv.setImageBitmap(bmpPiece3);
                break;
            case 4:
                iv.setImageBitmap(bmpPiece4);
                break;
            case 5:
                iv.setImageBitmap(bmpPiece5);
                break;
            default:
                iv.setImageBitmap(bmpPiece6);
        }

    }

    public void selectPalette(int palette){
        switch (palette){   //change palette
            case 0: case 3: {//yellow
                bmpPiece = BitmapFactory.decodeResource(getResources(), R.drawable.cubey);
                bmpPiece1 = BitmapFactory.decodeResource(getResources(), R.drawable.liney);
                bmpPiece2 = BitmapFactory.decodeResource(getResources(), R.drawable.sy);
                bmpPiece3 = BitmapFactory.decodeResource(getResources(), R.drawable.ty);
                bmpPiece4 = BitmapFactory.decodeResource(getResources(), R.drawable.zy);
                bmpPiece5 = BitmapFactory.decodeResource(getResources(), R.drawable.jy);
                bmpPiece6 = BitmapFactory.decodeResource(getResources(), R.drawable.ly);
                break;}
            case 1:{ //blue
                bmpPiece = BitmapFactory.decodeResource(getResources(), R.drawable.cubeb);
                bmpPiece1 = BitmapFactory.decodeResource(getResources(), R.drawable.lineb);
                bmpPiece2 = BitmapFactory.decodeResource(getResources(), R.drawable.sb);
                bmpPiece3 = BitmapFactory.decodeResource(getResources(), R.drawable.tb);
                bmpPiece4 = BitmapFactory.decodeResource(getResources(), R.drawable.zb);
                bmpPiece5 = BitmapFactory.decodeResource(getResources(), R.drawable.jb);
                bmpPiece6 = BitmapFactory.decodeResource(getResources(), R.drawable.lb);
                break;}
            case 2:{ //pink
                bmpPiece = BitmapFactory.decodeResource(getResources(), R.drawable.cubep);
                bmpPiece1 = BitmapFactory.decodeResource(getResources(), R.drawable.linep);
                bmpPiece2 = BitmapFactory.decodeResource(getResources(), R.drawable.sp);
                bmpPiece3 = BitmapFactory.decodeResource(getResources(), R.drawable.tp);
                bmpPiece4 = BitmapFactory.decodeResource(getResources(), R.drawable.zp);
                bmpPiece5 = BitmapFactory.decodeResource(getResources(), R.drawable.jp);
                bmpPiece6 = BitmapFactory.decodeResource(getResources(), R.drawable.lp);
                break;}
            case 4: {//orange
                bmpPiece = BitmapFactory.decodeResource(getResources(), R.drawable.cubeo);
                bmpPiece1 = BitmapFactory.decodeResource(getResources(), R.drawable.lineo);
                bmpPiece2 = BitmapFactory.decodeResource(getResources(), R.drawable.so);
                bmpPiece3 = BitmapFactory.decodeResource(getResources(), R.drawable.to);
                bmpPiece4 = BitmapFactory.decodeResource(getResources(), R.drawable.zo);
                bmpPiece5 = BitmapFactory.decodeResource(getResources(), R.drawable.jo);
                bmpPiece6 = BitmapFactory.decodeResource(getResources(), R.drawable.lo);
                break;}
            case 5: {//green
                bmpPiece = BitmapFactory.decodeResource(getResources(), R.drawable.cubeg);
                bmpPiece1 = BitmapFactory.decodeResource(getResources(), R.drawable.lineg);
                bmpPiece2 = BitmapFactory.decodeResource(getResources(), R.drawable.sg);
                bmpPiece3 = BitmapFactory.decodeResource(getResources(), R.drawable.tg);
                bmpPiece4 = BitmapFactory.decodeResource(getResources(), R.drawable.zg);
                bmpPiece5 = BitmapFactory.decodeResource(getResources(), R.drawable.jg);
                bmpPiece6 = BitmapFactory.decodeResource(getResources(), R.drawable.lg);
                break;}
        }
    }
    protected void enableSwitch(){
        Button sw=(Button)findViewById(R.id.Switch);
        sw.setVisibility(View.VISIBLE);
    }
    protected void disableSwitch(){
        Button sw=(Button)findViewById(R.id.Switch);
        sw.setVisibility(View.INVISIBLE);
    }
}
