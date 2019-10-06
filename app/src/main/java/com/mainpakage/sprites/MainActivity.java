package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity {

    TextView sc;
    CustomView customView;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView=(CustomView) findViewById(R.id.CustomView);
        customView.setMa(this);
        sc = (TextView) findViewById(R.id.valorPuntuacion);
        iv= (ImageView) findViewById(R.id.vistaImagen);
        customView.st.start();
    }



    public void updateScore(String s){
        sc.setText(s);
    }

        public void onClickDer(View v) {
            customView.moverDerechaActiva(customView.getActivePiece());
        }
        public void onClickIzq(View v) {
            customView.moverIzquierdaActiva(customView.getActivePiece());
        }
        public void onClickGirar(View v) {
            customView.girar(customView.getActivePiece());
        }
}
