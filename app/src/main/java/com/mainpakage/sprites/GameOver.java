package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Bundle bAux = getIntent().getExtras();
        TextView sc= (TextView) findViewById(R.id.ScoreAqui);
        sc.setText(bAux.getString("Score"));
    }
}
