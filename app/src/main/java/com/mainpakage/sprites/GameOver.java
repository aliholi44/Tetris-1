package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameOver extends AppCompatActivity {
    EditText pn;
    MainActivity ma;
    Button ok;
    private List<PlayerData> ranking = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        Bundle bAux = getIntent().getExtras();
        pn = (EditText) findViewById(R.id.playerName);
        addListenerOnButton();
    }

    public void addListenerOnButton () {
        ok = (Button) findViewById(R.id.setName);

        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int index = -1;
                PlayerData pd = new PlayerData(pn.getText().toString(), CustomView.getScore());

                if (ranking.isEmpty())
                    ranking.add(pd);
                else {
                    for (PlayerData pData : ranking) {
                        if ((pd.getFinalScore() > pData.getFinalScore()) && (index == -1))
                            index = ranking.indexOf(pData);
                    }

                    if ((index == -1) && (ranking.size() != 10))
                        ranking.add(pd);
                    else if (index != -1) {
                        for (int i = ranking.size() - 1; i >= index; i--) {
                            if (i == 9)
                                ranking.remove(i);

                            ranking.add(i, ranking.get(i - 1));
                        }
                    }
                }
            }
        });
    }

}
