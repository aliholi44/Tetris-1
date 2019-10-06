package com.mainpakage.sprites;

import com.mainpakage.sprites.TetrixPieces.CubeSprite;

public class SecondThreat extends Thread {
    private CustomView cv;
    public boolean running;
    private int cont;
    private int bottom;

    public SecondThreat(CustomView customView){
        cv=customView;
        running=true;
        cont=0;
        bottom=1600;    }

    @Override
    public void run(){
        while(running){
            cv.randomPiece(cv.bmp);
            boolean stop=false;
            while(!stop){
                cv.invalidate();
                try {
                    sleep(250);
                    cont++;
                }catch(Exception e){}
                if(cont==1){
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
