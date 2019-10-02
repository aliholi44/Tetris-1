package com.mainpakage.sprites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.mainpakage.sprites.TetrixPieces.*;

//Esta lista no tiene uso por el momento
import java.util.LinkedList;
import java.util.List;

public class CustomView extends View {

    Bitmap bmp;
    TetrixPiece piece;
    int score;
    private final int LINE_SCORE = 30;
    List<TetrixPiece> piezas = new LinkedList<>(); //Esta lista no tiene uso por el momento
    private TetrixPiece activePiece;
    private GameThread gameThread;


    public CustomView(Context context, AttributeSet attrs){
        super(context,attrs);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.spritetest2);
        piece = randomPiece(bmp);
        score = 0;
        updateScore();
    }


    public void updateScore(){
        score += LINE_SCORE;
    }

    public TetrixPiece randomPiece(Bitmap bmp){
        //activePiece = nextPiece;
        TetrixPiece nextPiece;
        int numPiece = (int) (Math.random() * 7) + 1;
        //ImageView iv = (ImageView) findViewById(R.id.vistaImagen);

        switch(numPiece){
            case 1:
                nextPiece= new CubePiece(bmp,this);
                //piezas.add(nextPiece);
                break;
            case 2:
                nextPiece= new JPiece(bmp,this);
                //piezas.add(nextPiece);
                break;
            case 3:
                nextPiece = new LinePiece(bmp,this);
                //piezas.add(nextPiece);
                break;
            case 4:
                nextPiece = new LPiece(bmp,this);
                //piezas.add(nextPiece);
                break;
            case 5:
                nextPiece = new SPiece(bmp,this);
                //piezas.add(nextPiece);
                break;
            case 6:
                nextPiece = new TPiece(bmp,this);
                //piezas.add(nextPiece);
                break;
            case 7:
                nextPiece = new ZPiece(bmp,this);
                //piezas.add(nextPiece);
                break;
            default:
                nextPiece = randomPiece(bmp);
                break;
        }

        return nextPiece;
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        gameThread = new GameThread(CustomView.this);
        activePiece = randomPiece(bmp);
        activePiece.onDraw(canvas);
        activePiece.changeYSpeed(200);
        activePiece.onDraw(canvas);
        activePiece.changeYSpeed(500);
        activePiece.onDraw(canvas);
        activePiece.changeYSpeed(800);
        activePiece.onDraw(canvas);

        //Falta ajustar el hilo para que su temporizador afecte a una pieza y no cambie la pieza
        //y simplemente vaya bajandola también se puede probar con un for
        //pero el thread nos da un control mucho mayor

        gameThread.setRunning(true);
        gameThread.start();


    }



}
