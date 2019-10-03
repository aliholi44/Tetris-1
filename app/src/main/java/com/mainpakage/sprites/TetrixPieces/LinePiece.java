package com.mainpakage.sprites.TetrixPieces;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;

import com.mainpakage.sprites.CustomView;

public class LinePiece implements TetrixPiece{


    private CubeSprite[] cubes;
    private final int xIni;
    private final int yIni;
    private final int spriteLength;
    private final int interpieceSpace;
    private int status=0;

    public LinePiece(Bitmap bmp, View view){
        xIni=100;
        yIni=40;
        spriteLength=bmp.getWidth();
        interpieceSpace=5;
        cubes = new CubeSprite[4];

        for(int i=0;i<4;i++) {
            cubes[i] = new CubeSprite(bmp, view);
            cubes[i].setX(xIni + (spriteLength + interpieceSpace) * i);
            cubes[i].setY(yIni);
        }
    }

    private void changeStatus(){
        if (this.status == 0){
            this.status++;
        }
        else{
            this.status=0;
        }
    }

    @Override
    public void rotate90Right() {
        int x=cubes[1].getX();
        int y=cubes[1].getY();
        if(status==0){
            cubes[0].setX(x);
            cubes[0].setY(y-(spriteLength+interpieceSpace));
            cubes[2].setX(x);
            cubes[2].setY(y+(spriteLength+interpieceSpace));
            cubes[3].setX(x);
            cubes[3].setY(y+(spriteLength+interpieceSpace)*2);
        }else{
            cubes[0].setX(x - (spriteLength + interpieceSpace));
            cubes[0].setY(y);
            cubes[2].setX(x + (spriteLength + interpieceSpace));
            cubes[2].setY(y);
            cubes[3].setX(x + (spriteLength + interpieceSpace) * 2);
            cubes[3].setY(y);
        }
        changeStatus();
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
