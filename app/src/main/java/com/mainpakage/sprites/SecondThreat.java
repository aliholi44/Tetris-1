package com.mainpakage.sprites;

import com.mainpakage.sprites.TetrixPieces.CubeSprite;

public class SecondThreat extends Thread {
    private CustomView cv;
    public boolean running;
    private int cont;
    private int contDownLine;
    private int bottom;
    private final int gameSpeed=10;
    private final int downLineSpeed=500;

    public SecondThreat(CustomView customView){
        cv=customView;
        running=true;
        cont=0;
        contDownLine=0;
        bottom=1600;    }

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
                    contDownLine++;
                }catch(Exception e){}
                if(contDownLine==downLineSpeed){
                    cv.downTop();
                    cv.gameOver();
                    contDownLine=0;
                }
                if(!running){
                    break;
                }
                if(cont==gameSpeed){
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
