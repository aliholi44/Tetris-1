package com.mainpakage.sprites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.mainpakage.sprites.TetrixPieces.CubePiece;
import com.mainpakage.sprites.TetrixPieces.JPiece;
import com.mainpakage.sprites.TetrixPieces.LPiece;
import com.mainpakage.sprites.TetrixPieces.SPiece;
import com.mainpakage.sprites.TetrixPieces.TPiece;
import com.mainpakage.sprites.TetrixPieces.TetrixPiece;
import com.mainpakage.sprites.TetrixPieces.ZPiece;

import java.util.List;

public class CustomView extends View {

    Bitmap bmp;
    TetrixPiece tp;
    int score;
    private final int lineScore=30;
    List<TetrixPiece> piezas;
    private TetrixPiece nextPiece;
    private TetrixPiece activePiece;


    public CustomView(Context context, AttributeSet attrs){
        super(context,attrs);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.spritetest2);
        tp = new TPiece(bmp,this);
        score=0;
        updateScore();
    }


    public void updateScore(){
        score+=lineScore;
    }

    public void randomPiece(Bitmap bmp){
        activePiece=nextPiece;
        int piece = (int)(Math.random()*7);//Cuando se resuelva lo de lp2 poner 7 y quitar comentario de abajo
        ImageView iv = (ImageView) findViewById(R.id.vistaImagen);
        switch(piece){
            case 0:
                nextPiece= new CubePiece(bmp,this);
                piezas.add(nextPiece);
            case 1:
                nextPiece= new CubePiece(bmp,this);
                piezas.add(nextPiece);
            case 2:
                nextPiece = new SPiece(bmp,this);
                piezas.add(nextPiece);
            case 3:
                nextPiece = new TPiece(bmp,this);
                piezas.add(nextPiece);
            case 4:
                nextPiece = new ZPiece(bmp,this);
                piezas.add(nextPiece);
            case 5:
                nextPiece = new JPiece(bmp,this);
                piezas.add(nextPiece);
            case 6:
                nextPiece = new LPiece(bmp,this);
                piezas.add(nextPiece);
        }
        if(activePiece==null){
            randomPiece(bmp);
        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        tp.onDraw(canvas);
    }



}
