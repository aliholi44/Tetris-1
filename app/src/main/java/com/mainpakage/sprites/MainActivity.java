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
import com.mainpakage.sprites.TetrixPieces.LinePiece;
import com.mainpakage.sprites.TetrixPieces.SPiece;
import com.mainpakage.sprites.TetrixPieces.TPiece;
import com.mainpakage.sprites.TetrixPieces.ZPiece;

public class MainActivity extends AppCompatActivity {

    Bitmap bmp;
    CubePiece cp;
    LinePiece lp;
    SPiece sp;
    TPiece tp;
    ZPiece zp;



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
            lp = new LinePiece(bmp, this);
            sp = new SPiece(bmp,this);
            tp = new TPiece(bmp,this);
            zp= new ZPiece(bmp,this);
        }

        @Override
        protected void onDraw(Canvas canvas){
            lp.onDraw(canvas);
            lp.changeYSpeed(300);
            lp.rotate90Right();
            lp.onDraw(canvas);
            lp.changeYSpeed(300);
            lp.rotate90Right();
            lp.onDraw(canvas);

        }

    }
}
