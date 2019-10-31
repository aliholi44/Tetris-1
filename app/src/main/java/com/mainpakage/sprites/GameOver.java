package com.mainpakage.sprites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class GameOver extends AppCompatActivity {
    private EditText pn;
    private Button ok;
    private List<PlayerData> ranking;
    private TextView playerName, gameOverText, rankingText;
    private ListView listRanking;
    private Bundle bAux;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private List<String> adaptedArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        bAux = getIntent().getExtras();
        adaptedArray = new ArrayList<>();
        playerName = (TextView) findViewById(R.id.playerName);
        listRanking = (ListView) findViewById(R.id.listRanking);
        gameOverText = (TextView) findViewById(R.id.gameOver);
        rankingText = (TextView) findViewById(R.id.rankingText);
        pn = (EditText) findViewById(R.id.playerName);
        preferences = getSharedPreferences("RankingDefinitive", Context.MODE_PRIVATE);
        editor = preferences.edit();
        Set<String> scores = preferences.getStringSet("Scores", null);
        ranking = new ArrayList<>();
        if(scores==null){
            scores = new HashSet<>();
        }
        if(!scores.isEmpty()){
            for(String s:scores){
                String[] aux = s.split("/");
                PlayerData pd = new PlayerData(aux[0],Integer.parseInt(aux[1]));
                ranking.add(pd);
            }
        }
    }

    public void onClickOk(View v) {
            if(pn.getText().toString().contains("/")){
                Toast toast1 = Toast.makeText(getApplicationContext(), "No se puede introducir / en el nombre", Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER,0,0);
                toast1.show();
            }else {
                PlayerData pd = new PlayerData(pn.getText().toString(), Integer.parseInt(bAux.getString("Score")));
                ranking.add(pd);
                Collections.sort(ranking);
                Set<String> scores = new HashSet<>();
                for (PlayerData p : ranking) {
                    scores.add(p.toString());
                }
                editor.putStringSet("Scores", scores);
                editor.commit();
                adaptedArray.clear();
                for (int r = 0; (r < ranking.size()) && (r < 10); r++)
                    adaptedArray.add(ranking.get(r).toFormatString());

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, adaptedArray);
                listRanking.setAdapter(arrayAdapter);

                gameOverText.setVisibility(View.INVISIBLE);
                playerName.setVisibility(View.INVISIBLE);
                v.setVisibility(View.INVISIBLE);
                rankingText.setVisibility(View.VISIBLE);
                listRanking.setVisibility(View.VISIBLE);
            }
    }

    public void onClickOkReturn(View v){
        Intent intent = new Intent (v.getContext(), StartMenu.class);
        startActivityForResult(intent, 0);
    }
}
