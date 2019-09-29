package com.mainpakage.sprites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import com.mainpakage.sprites.TetrixPieces.*;

public class CustomView extends View {

    Bitmap bmp;
    CubePiece cp;
    LinePiece lp;
    SPiece sp;
    TPiece tp;
    ZPiece zp;


    public CustomView(Context context){
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
