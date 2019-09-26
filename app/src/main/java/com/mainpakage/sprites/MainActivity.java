package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.mainpakage.sprites.TetrixPieces.CubePiece;

public class MainActivity extends AppCompatActivity {

    Bitmap bmp;
    CubePiece cp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new testCanvas(this));
    }

    public class testCanvas extends View{
        public testCanvas(Context context){
            super(context);
            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.spritetest2);
            cp = new CubePiece(bmp,this);
        }

        @Override
        protected void onDraw(Canvas canvas){
            cp.onDraw(canvas);

        }

    }
}
