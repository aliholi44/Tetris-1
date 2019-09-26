package com.mainpakage.sprites.TetrixPieces;

import android.graphics.Canvas;

public interface TetrixPiece {
    public void rotate90Right();
    public void rotate90Left();
    public void changeXSpeed(int speed);
    public void changeYSpeed(int speed);
    public void removeCube();
    public void onDraw(Canvas canvas);
}
