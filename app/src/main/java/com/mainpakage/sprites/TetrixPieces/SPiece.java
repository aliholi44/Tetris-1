package com.mainpakage.sprites.TetrixPieces;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class SPiece implements TetrixPiece {



    private CubeSprite[] cubes;
    private final int xIni;
    private final int yIni;
    private final int spriteLength;
    private final int interpieceSpace;
    private int status=0;

    public SPiece(Bitmap bmp, View view){
        xIni=50;
        yIni=40;
        spriteLength=bmp.getWidth();
        interpieceSpace=5;
        cubes = new CubeSprite[4];

        for(int i=0;i<4;i++) {
            cubes[i] = new CubeSprite(bmp, view);
        }

        cubes[0].setX(xIni);
        cubes[0].setY(yIni + (spriteLength + interpieceSpace));
        cubes[1].setX(xIni + (spriteLength + interpieceSpace));
        cubes[1].setY(yIni + (spriteLength + interpieceSpace));
        cubes[2].setX(xIni + (spriteLength + interpieceSpace));
        cubes[2].setY(yIni);
        cubes[3].setX(xIni + (spriteLength + interpieceSpace)*2);
        cubes[3].setY(yIni);
    }

    private void changeStatus(){
        if (this.status <3){
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
            cubes[2].setX(x+(spriteLength+interpieceSpace));
            cubes[2].setY(y);
            cubes[3].setX(x+(spriteLength+interpieceSpace));
            cubes[3].setY(y+(spriteLength+interpieceSpace));
        }else if (status==1){
            cubes[0].setX(cubes[2].getX());
            cubes[0].setY(cubes[2].getY());
            cubes[2].setX(x);
            cubes[2].setY(y+(spriteLength+interpieceSpace));
            cubes[3].setX(x-(spriteLength+interpieceSpace));
            cubes[3].setY(y+(spriteLength+interpieceSpace));
        }else if(status==2){
            cubes[0].setX(cubes[2].getX());
            cubes[0].setY(cubes[2].getY());
            cubes[2].setX(x-(spriteLength+interpieceSpace));
            cubes[2].setY(y);
            cubes[3].setX(x-(spriteLength+interpieceSpace));
            cubes[3].setY(y-(spriteLength+interpieceSpace));
        }else{
            cubes[0].setX(cubes[2].getX());
            cubes[0].setY(cubes[2].getY());
            cubes[2].setX(x);
            cubes[2].setY(y-(spriteLength+interpieceSpace));
            cubes[3].setX(x+(spriteLength+interpieceSpace));
            cubes[3].setY(y-(spriteLength+interpieceSpace));
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

}
