package com.mainpakage.sprites.TetrixPieces;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;

import com.mainpakage.sprites.CustomView;

public class CubePiece implements TetrixPiece{

    private CubeSprite[] cubes;
    private final int xIni;
    private final int yIni;
    private final int spriteLength;
    private final int interpieceSpace;

    public CubePiece(Bitmap bmp,View view){
        xIni=100;
        yIni=40;
        spriteLength=bmp.getWidth();
        interpieceSpace=5;
        cubes = new CubeSprite[4];

        for(int i=0;i<4;i++){
           cubes[i]= new CubeSprite(bmp,view);
        }

        cubes[0].setX(xIni);
        cubes[0].setY(yIni);
        cubes[1].setX(xIni+spriteLength+interpieceSpace);
        cubes[1].setY(yIni);
        cubes[2].setX(xIni);
        cubes[2].setY(yIni+spriteLength+interpieceSpace);
        cubes[3].setX(xIni+spriteLength+interpieceSpace);
        cubes[3].setY(yIni+spriteLength+interpieceSpace);


    }

    @Override
    public void rotate90Right() {
    }

    @Override
    public void changeXSpeed(int speed) {
        for(int i=0;i<4;i++){
            if(cubes[i]!=null)
            cubes[i].setxSpeed(speed);
        }
    }

    @Override
    public void changeYSpeed(int speed) {
        for(int i=0;i<4;i++){
            if(cubes[i]!=null)
            cubes[i].setySpeed(speed);
        }
    }

    @Override
    public void removeCube(CubeSprite cubeSprite) {
        for(int i=0;i<4;i++){
            if(cubes[i]==cubeSprite)
                cubes[i]=null;
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        for(int i=0;i<4;i++){
            if(cubes[i]!=null)
            cubes[i].onDraw(canvas);
        }
    }

    @Override
    public void moveDown(CustomView view, Canvas canvas) {
        for (int i=0; i < view.getWidth(); i++) {
            this.changeYSpeed(i);
            this.onDraw(canvas);
        }
    }
}
