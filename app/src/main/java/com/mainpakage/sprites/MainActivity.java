package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
            back.setBackgroundResource(R.drawable.backgroundclassic);

            final ImageButton turn = (ImageButton)findViewById(R.id.girar);     //Set Button turn
            turn.setBackgroundResource(R.drawable.star);    //change on XML
            turn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        turn.setBackgroundResource(R.drawable.pressed);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.girar(customView.getActivePiece());
                        turn.setBackgroundResource(R.drawable.star);
                        return true;
                    }
                    return false;
                }
            });

            final Button right=(Button)findViewById(R.id.flechader);          //Set button right
            right.setBackgroundResource(R.drawable.right);
            right.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        right.setBackgroundResource(R.drawable.sel);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.moverDerechaActiva(customView.getActivePiece());
                        right.setBackgroundResource(R.drawable.right);
                        return true;
                    }
                    return false;
                }
            });

            final Button left=(Button)findViewById(R.id.flechaizq);          //Set button left
            left.setBackgroundResource(R.drawable.right);
            left.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        left.setBackgroundResource(R.drawable.sel);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.moverIzquierdaActiva(customView.getActivePiece());
                        left.setBackgroundResource(R.drawable.right);
                        return true;
                    }
                    return false;
                }
            });

            final Button down=(Button)findViewById(R.id.flechabajo);          //Set button down
            down.setBackgroundResource(R.drawable.right);
            down.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        //IMPLEMENTS
                        down.setBackgroundResource(R.drawable.sel);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        down.setBackgroundResource(R.drawable.right);
                        return true;
                    }
                    return false;
                }
            });

            final Button swi=(Button)findViewById(R.id.Switch);          //Set button switch
            swi.setBackgroundResource(R.drawable.right);
            swi.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {

                        swi.setBackgroundResource(R.drawable.sel);
                        return true;
                    }
                    else if (event.getAction() == MotionEvent.ACTION_UP) {
                        customView.switchPiece();
                        swi.setBackgroundResource(R.drawable.right);
                        return true;
                    }
                    return false;
                }
            });


        }
        else if(thm==1){    //Spooky theme
            ConstraintLayout back=(ConstraintLayout)findViewById(R.id.layout);
            back.setBackgroundResource(R.drawable.ks);
        }



        customView=(CustomView) findViewById(R.id.CustomView);
        customView.setMa(this);
        sc = (TextView) findViewById(R.id.valorPuntuacion);
        iv= (ImageView) findViewById(R.id.nextpiecebackground);
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
                case 0: {//yellow
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
            }
        }
}
