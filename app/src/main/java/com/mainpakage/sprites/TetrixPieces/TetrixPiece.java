package com.mainpakage.sprites.TetrixPieces;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

public interface TetrixPiece {
    public void rotate90Right();
    public void changeXSpeed(int speed);
    public void changeYSpeed(int speed);
    public void changeColor(int random_color);
    public void removeCube(int y);
    public void onDraw(Canvas canvas);
    public CubeSprite[] getSprites();
    public int getInterSpace();
    public void update();
    public TetrixPiece copyRight(Bitmap bmp, View view);
    public TetrixPiece copyLeft(Bitmap bmp, View view);
    public TetrixPiece copyRotate(Bitmap bmp, View view);
    public void moveRight();
    public void moveLeft();
    public TetrixPiece copyDown(Bitmap bmp, View view);

}
