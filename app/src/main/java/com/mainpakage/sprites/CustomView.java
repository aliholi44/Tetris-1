package com.mainpakage.sprites;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


import com.mainpakage.sprites.TetrixPieces.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class CustomView extends View {

    Bitmap bmp;
    int score;
    public SecondThreat st;
    private final int lineScore=30;
    List<TetrixPiece> piezas;
    private int nextPiece;
    private TetrixPiece activePiece;
    private int [] LinesInfo;
    MainActivity ma;
    int cwidth;
    int cheight;
    int top; //Línea superior
    Paint paint1;
    private final int cubelength;

    public CustomView(Context context, AttributeSet attrs){
        super(context,attrs);
        piezas = new ArrayList<>();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.spritetest2);
        score=0;
        LinesInfo=new int[50];  //20 is the number of available lines (matrix height)
        st= new SecondThreat(this);
        nextPiece=0;
        cwidth=0;
        cheight=0;
        CubeSprite caux = new CubeSprite(bmp,this);
        cubelength=caux.getLength();
        top=cubelength;
        paint1 = new Paint();
        paint1.setARGB(255, 255, 0, 0);
        paint1.setStrokeWidth(4);
    }

    public TetrixPiece getActivePiece() {
        return activePiece;
    }


    public void setMa(MainActivity mainActivity){
        ma=mainActivity;
    }

    public void updateScore(){
        score+=lineScore;
        ma.updateScore(""+score);
    }

    public void randomPiece(Bitmap bmp){
        randomPiece(bmp,nextPiece);
        nextPiece = (int)(Math.random()*7);
        ma.printNextPiece(nextPiece);

    }

    public void randomPiece(Bitmap bmp,int piece){
        switch(piece){
            case 0:
                activePiece= new CubePiece(bmp,this,top-cubelength);
                break;
            case 1:
                activePiece= new LinePiece(bmp,this,top-cubelength);
                break;
            case 2:
                activePiece = new SPiece(bmp,this,top-cubelength);
                break;
            case 3:
                activePiece = new TPiece(bmp,this,top-cubelength);
                break;
            case 4:
                activePiece = new ZPiece(bmp,this,top-cubelength);
                break;
            case 5:
                activePiece = new JPiece(bmp,this,top-cubelength);
                break;
            case 6:
                activePiece = new LPiece(bmp,this,top-cubelength);
                break;
        }
        activePiece.changeYSpeed(bmp.getWidth());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.cwidth = w;
        this.cheight = h;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawLine(0,top-cubelength,cwidth,top-cubelength,paint1);
        for(TetrixPiece tp:piezas){
            tp.onDraw(canvas);
        }
        activePiece.onDraw(canvas);
    }


    public boolean isCollisionPiece (TetrixPiece a, TetrixPiece b) {
        CubeSprite[] cubosa = a.getSprites();
        CubeSprite[] cubosb = b.getSprites();
        boolean aux = false;
        int i = 0;
        while (i<=3 && !aux) {
            int j=0;
            while (j<=3 && !aux) {
                if(cubosb[j]!=null){
                    aux = isCollisionCube(cubosa[i], cubosb[j]);
                }
                j++;
            }
            i++;
        }
        return aux;
    }


    private boolean isCollisionCube(CubeSprite cubeSprite1, CubeSprite cubeSprite2) {
        return (cubeSprite1.getX() == cubeSprite2.getX() && cubeSprite1.getY() == cubeSprite2.getY());
    }



    public void moverDerechaActiva (TetrixPiece pieza) {
        TetrixPiece nueva = pieza.copyRight(bmp,this);
        boolean nochocan = true;
        for (TetrixPiece ptablero : piezas) {
            if(ptablero!=pieza)
            nochocan = nochocan && (!isCollisionPiece(nueva, ptablero));
        }
        boolean nofuera = true;
        CubeSprite[] cube = activePiece.getSprites();
        for (CubeSprite c: nueva.getSprites()) {
            nofuera = nofuera && ((c.getX()>=0) && (c.getX()<=cwidth-cube[0].getLength()));
        }
        if (nochocan && nofuera) {
            activePiece.moveRight();
        }
    }

    public void moverIzquierdaActiva (TetrixPiece pieza) {
        TetrixPiece nueva = pieza.copyLeft(bmp,this);
        boolean nochocan = true;
        for (TetrixPiece ptablero : piezas) {
            if(ptablero!=pieza)
                nochocan = nochocan && (!isCollisionPiece(nueva, ptablero));
        }
        boolean nofuera = true;
        CubeSprite[] cube = activePiece.getSprites();
        for (CubeSprite c: nueva.getSprites()) {
            nofuera = nofuera && ((c.getX()>=0) && (c.getX()<=cwidth-cube[0].getLength()));
        }
        if (nochocan && nofuera) {
            activePiece.moveLeft();
        }
    }

    public void girar (TetrixPiece pieza) {
        TetrixPiece nueva = pieza.copyRotate(bmp,this);
        boolean nochocan = true;
        for (TetrixPiece ptablero : piezas) {
            if(ptablero!=pieza)
                nochocan = nochocan && (!isCollisionPiece(nueva, ptablero));
        }
        boolean nofuera = true;
        CubeSprite[] cube = activePiece.getSprites();
        for (CubeSprite c: nueva.getSprites()) {
            nofuera = nofuera && ((c.getX()>=0) && (c.getX()<=cwidth-cube[0].getLength()));
        }
        if (nochocan && nofuera) {
            activePiece.rotate90Right();
        }
    }

    public boolean moverAbajoActiva (TetrixPiece pieza) {
        TetrixPiece nueva = pieza.copyDown(bmp,this);
        boolean nochocan = true;
        for (TetrixPiece ptablero : piezas) {
            if(ptablero!=pieza)
                nochocan = nochocan && (!isCollisionPiece(nueva, ptablero));
        }

            return nochocan;
    }


    public void linesUpdate(TetrixPiece piece) {//coordinates of the last piece set
        piezas.add(activePiece);
        CubeSprite []cubos=piece.getSprites();

        for(int i=0;i<4;i++) {   //Recorre los sprites de la figura última posicionada
            int cy = cubos[i].getY()/cubos[i].getLength();
            LinesInfo[cy]++;    //Esta línea tiene un nuevo sprite.
        }
        CubeSprite[] cube = activePiece.getSprites();
        int aux=(cheight/cube[0].getLength());
        int aux2=(cwidth/cube[0].getLength())-1;
        for(int j=0;j<aux;j++){      //Recorre todas las líneas de la matriz
            if(LinesInfo[j]==aux2){
               deleteLine(j,cubos[0].getLength(),piece.getInterSpace());
                j--;
            }
        }


    }
    private void deleteLine(int linea, int spriteLength, int interSpace){   //eliminar la línea completa y bajar las piezas
        LinesInfo[linea]=0;             //refinar si es necesario
        int spriteSpace=(spriteLength+interSpace);  //te situas en la altura deseada para borrar horizontalmente
        int y=spriteSpace*linea;

        for(TetrixPiece p:piezas){
            p.removeCube(y);
        }

        drop(y,spriteSpace);

        for(int i=linea;i>0;i--){        //checkear por bugs mañana
            LinesInfo[i]=LinesInfo[i-1];
        }
        LinesInfo[0]=0;

        updateScore();
    }

    private void drop (int y, int spriteSpace){
            for (TetrixPiece p : piezas) {
                CubeSprite []cubos=p.getSprites();
                for(int i=0;i<4;i++) {
                    if(cubos[i]!=null&&cubos[i].getY()<y){
                        cubos[i].setY(cubos[i].getY()+spriteSpace);
                    }
                }
            }
    }

    public void downTop() {
        top=top+cubelength*2;
    }
    public void gameOver(){
        for (TetrixPiece p : piezas) {
            CubeSprite []cubos=p.getSprites();
            if(p!=activePiece) {
                for (int i = 0; i < 4; i++) {
                    if (cubos[i] != null && cubos[i].getY() <= top) {
                        st.running = false;
                        this.invalidate();
                        try {
                            sleep(1000);
                        }catch(Exception e){}
                        ma.changeGameOver();
                        break;
                    }
                }
            }
        }
    }

}
