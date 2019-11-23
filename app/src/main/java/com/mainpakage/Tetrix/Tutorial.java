package com.mainpakage.Tetrix;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Tutorial extends AppCompatActivity {

    int mensaje = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        final TextView texto = (TextView) findViewById(R.id.textoBienvenida);
        final ImageButton estrella = (ImageButton) findViewById(R.id.estrella);
        final ImageView xScore = (ImageView) findViewById(R.id.xScore);
        final ImageView xNext = (ImageView) findViewById(R.id.xNext);
        final ImageView xSwitch = (ImageView) findViewById(R.id.xSwitch);
        final ImageView xRotate = (ImageView) findViewById(R.id.xRotate);
        final ImageView xLeft= (ImageView) findViewById(R.id.xLeft);
        final ImageView xRight = (ImageView) findViewById(R.id.xRight);
        final ImageView xDown = (ImageView) findViewById(R.id.xDown);
        final ImageView xPower = (ImageView) findViewById(R.id.xPowers);
        final ImageView cubo1 = (ImageView) findViewById(R.id.cubo1);
        final ImageView cubo2 = (ImageView) findViewById(R.id.cubo2);
        final ImageView cubo3 = (ImageView) findViewById(R.id.cubo3);


        //Escondemos todo lo que no queremos que aparezca
        xScore.setVisibility(View.INVISIBLE);
        xNext.setVisibility(View.INVISIBLE);
        xSwitch.setVisibility(View.INVISIBLE);
        xRotate.setVisibility(View.INVISIBLE);
        xLeft.setVisibility(View.INVISIBLE);
        xRight.setVisibility(View.INVISIBLE);
        xDown.setVisibility(View.INVISIBLE);
        xPower.setVisibility(View.INVISIBLE);
        cubo1.setVisibility((View.INVISIBLE));
        cubo2.setVisibility((View.INVISIBLE));
        cubo3.setVisibility((View.INVISIBLE));


        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mensaje) {
                    case 1: {
                        texto.setText("En Score podemos ver la puntuación que tenemos. Esta aumenta 30 puntos cada vez que haces una línea. Consejo: usa los Power-Ups");
                        xScore.setVisibility(View.VISIBLE);
                    }
                    break;
                    case 2: {
                        texto.setText("Next muestra la siguiente pieza");
                        xScore.setVisibility(View.INVISIBLE);
                        xNext.setVisibility(View.VISIBLE);

                    }
                    break;
                    case 3: {
                        texto.setText("Pulsando los botones te moverás en la dirección que indican");
                        xNext.setVisibility(View.INVISIBLE);
                        xLeft.setVisibility(View.VISIBLE);
                        xRight.setVisibility(View.VISIBLE);
                    }
                    break;
                    case 4: {
                        texto.setText("Gira la pieza");
                        xLeft.setVisibility(View.INVISIBLE);
                        xRight.setVisibility(View.INVISIBLE);
                        xRotate.setVisibility(View.VISIBLE);
                    }
                    break;
                    case 5: {
                        texto.setText("Acelera la caída mientras pulsas");
                        xRotate.setVisibility(View.INVISIBLE);
                        xDown.setVisibility(View.VISIBLE);
                    }
                    break;
                    case 6: {
                        texto.setText("Cada 30 segundos aparecerá una pieza aleatoria además de la que ya hay.\n" +
                                "Para manejarla pulsa switch.");
                        xDown.setVisibility(View.INVISIBLE);
                        xSwitch.setVisibility(View.VISIBLE);
                    }
                    break;
                    case 7:{
                        xSwitch.setVisibility(View.INVISIBLE);
                        texto.setText("De vez en cuando aparecerán Power-Ups.\n Usalos haciendo línea.");
                        xPower.setVisibility(View.VISIBLE);
                        cubo1.setVisibility((View.VISIBLE));
                        cubo2.setVisibility((View.VISIBLE));
                        cubo3.setVisibility((View.VISIBLE));

                    }
                    break;
                    case 8: {
                        xPower.setVisibility(View.INVISIBLE);
                        cubo1.setVisibility((View.INVISIBLE));
                        cubo2.setVisibility((View.INVISIBLE));
                        cubo3.setVisibility((View.INVISIBLE));
                        texto.setText("Ya lo has aprendido todo, ve a ponerlo en práctica.");
                    }
                    break;
                    default:{
                        Intent intent = new Intent (v.getContext(), StartMenu.class);
                        startActivityForResult(intent, 0);
                    }
                    break;
                }
                mensaje++;



            }
        });




    }
}

