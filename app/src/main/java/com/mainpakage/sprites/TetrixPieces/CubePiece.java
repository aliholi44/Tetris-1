package com.mainpakage.sprites.TetrixPieces;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public class CubePiece implements TetrixPiece{

    private CubeSprite[] cubes;
    private int x;
    private int y;

    public CubePiece(Bitmap bmp,View view){
        x=(int)(Math.random()*1000);
        y=72;
        cubes = new CubeSprite[4];

        for(int i=0;i<4;i++){
           cubes[i]= new CubeSprite(bmp,view);
        }

        cubes[0].setX(x);
        cubes[0].setY(y);
        cubes[1].setX(x+72);
        cubes[1].setY(y);
        cubes[2].setX(x);
        cubes[2].setY(y+72);
        cubes[3].setX(x+72);
        cubes[3].setY(y+72);

    }

    @Override
    public void rotate90Right() {
    }

    @Override
    public void rotate90Left() {
    }

    @Override
    public void changeXSpeed(int speed) {
        for(int i=0;i<4;i++){
            cubes[i].setxSpeed(speed);
        }
    }

    @Override
    public void changeYSpeed(int speed) {
        for(int i=0;i<4;i++){
            cubes[i].setxSpeed(speed);
        }
    }

    @Override
    public void removeCube() {

    }

    @Override
    public void onDraw(Canvas canvas) {
        for(int i=0;i<4;i++){
            cubes[i].onDraw(canvas);
        }
    }
}
