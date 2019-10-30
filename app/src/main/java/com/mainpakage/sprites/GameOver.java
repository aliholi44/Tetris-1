package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GameOver extends AppCompatActivity {
    EditText pn;
    MainActivity ma;
    Button ok;
    TextView playerName, gameOverText, rankingText;
    ListView listRanking;
    private ArrayList<PlayerData> ranking = new ArrayList<>(10);
    private List<String> adaptedArray = new ArrayList<>(10);
    private File file = new File(this.getFilesDir(),"ranking.txt");

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
                try {
                    if (!file.exists())
                        file.createNewFile();
                }
                catch (Exception e) {
                    Toast t = Toast.makeText(getApplicationContext(),"Couldn't create the file.",Toast.LENGTH_LONG);
                    t.show();
                }
                playerName = (TextView) findViewById(R.id.playerName);
                listRanking = (ListView) findViewById(R.id.listRanking);
                gameOverText = (TextView) findViewById(R.id.gameOver);
                rankingText = (TextView) findViewById(R.id.rankingText);
                int index = -1;
                PlayerData pd = new PlayerData(pn.getText().toString(), CustomView.getScore());

                ranking = PlayerData.read(file);

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

                PlayerData.write(ranking,file);

                adaptedArray.clear();
                for (int r = 0; r < ranking.size(); r++)
                    adaptedArray.add(ranking.get(r).toString());

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, adaptedArray);
                listRanking.setAdapter(arrayAdapter);

                gameOverText.setVisibility(View.INVISIBLE);
                playerName.setVisibility(View.INVISIBLE);
                ok.setVisibility(View.INVISIBLE);
                rankingText.setVisibility(View.VISIBLE);
                listRanking.setVisibility(View.VISIBLE);
            }
        });
    }

}
