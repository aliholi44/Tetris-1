package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static java.lang.Thread.sleep;


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

    int thm=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ConstraintLayout back=(ConstraintLayout)findViewById(R.id.layout);       //For changing background



        int palette=(int)(Math.random()*3); //  //For each theme there are 3 models of pieces
        if(thm==0){ //Classic Theme

            /*

                CHANGE CANVAS

            */

            /* CHANGE BACKGROUND */
            ConstraintLayout back=(ConstraintLayout)findViewById(R.id.layout);
            back.setBackgroundResource(R.drawable.kaka);
            /*                  */

            switch (palette){   //change palette
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
        else if(thm==1){    //Spooky theme
            ConstraintLayout back=(ConstraintLayout)findViewById(R.id.layout);
            back.setBackgroundResource(R.drawable.ks);
        }
        bmpPiece = BitmapFactory.decodeResource(getResources(), R.drawable.cpn);
        bmpPiece1 = BitmapFactory.decodeResource(getResources(), R.drawable.linepn);
        bmpPiece2 = BitmapFactory.decodeResource(getResources(), R.drawable.zpi);
        bmpPiece3 = BitmapFactory.decodeResource(getResources(), R.drawable.tpi);
        bmpPiece4 = BitmapFactory.decodeResource(getResources(), R.drawable.zpn);
        bmpPiece5 = BitmapFactory.decodeResource(getResources(), R.drawable.lpinv);
        bmpPiece6 = BitmapFactory.decodeResource(getResources(), R.drawable.lpn);
        customView=(CustomView) findViewById(R.id.CustomView);
        customView.setMa(this);
        sc = (TextView) findViewById(R.id.valorPuntuacion);
        iv= (ImageView) findViewById(R.id.vistaImagen);
        customView.st.start();
    }



    public void updateScore(String s){
        sc.setText(s);
    }

        public void onClickDer(View v) {
            customView.moverDerechaActiva(customView.getActivePiece());
        }
        public void onClickIzq(View v) {
            customView.moverIzquierdaActiva(customView.getActivePiece());
        }
        public void onClickGirar(View v) {
            customView.girar(customView.getActivePiece());
        }

        public void onClickSwitch(View v){
            customView.switchPiece();
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
}
