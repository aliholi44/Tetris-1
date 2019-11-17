package com.mainpakage.Tetrix;

import com.mainpakage.Tetrix.TetrixPieces.CubeSprite;

public class SecondThreadAlter extends Thread{
    private CustomView cv;
    public boolean running;
    private int cont;
    private int bottom;
    private int gameSpeed;

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public SecondThreadAlter(CustomView customView){
        cv=customView;
        this.running=true;
        this.cont=0;
        this.bottom=1600;
        gameSpeed=7;
        }

    @Override
    public void run(){
        while(running){
            cv.randomPiece(cv.bmp);
            boolean stop=false;
            while(!stop){
                cv.invalidate();
                try {
                    sleep(100);
                    cont++;
                }catch(Exception e){}
                if(cont>=gameSpeed){
                    cv.getActivePiece().update();
                    cont=0;
                    CubeSprite[] caux=cv.getActivePiece().getSprites();
                    bottom=(cv.cheight-caux[0].getLength());
                }
                int i=0;
                CubeSprite[] aux=cv.getActivePiece().getSprites();
                stop = !cv.moverAbajoActiva(cv.getActivePiece());
                while(!stop&&i<4){
                    stop = bottom <= (aux[i].getY()+aux[i].getLength());
                    i++;
                }
            }
            cv.getActivePiece().changeYSpeed(0);
            cv.linesUpdate(cv.getActivePiece());
            cv.gameOver();
        }
    }
}
