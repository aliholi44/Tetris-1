package com.mainpakage.sprites.TetrixPieces;

import android.graphics.Canvas;
import com.mainpakage.sprites.CustomView;

public interface TetrixPiece {
    void rotate90Right();
    void changeXSpeed(int speed);
    void changeYSpeed(int speed);
    void removeCube(CubeSprite cubeSprite);
    void onDraw(Canvas canvas);
    void moveDown(CustomView view, Canvas canvas);
}
