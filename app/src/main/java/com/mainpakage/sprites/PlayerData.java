package com.mainpakage.sprites;

import java.io.*;
import java.util.ArrayList;

public class PlayerData implements Serializable {
    private String playerName;
    private int finalScore;

    public PlayerData (String pn, int fs) {
        this.playerName = pn;
        this.finalScore = fs;
    }

    public String getPlayerName () { return this.playerName; }

    public int getFinalScore () {
        return this.finalScore;
    }

    public void setPlayerName (String pn) {
        this.playerName = pn;
    }

    public void setFinalScore (int fs) {
        this.finalScore = fs;
    }

    @Override
    public String toString() {
        return this.playerName+ "     "+this.finalScore;
    }

    public static ArrayList<PlayerData> read (File f) {
        ArrayList<PlayerData> loadedVector = new ArrayList<>();
        try {
            ObjectInputStream fileR = new ObjectInputStream(new FileInputStream(f));
            loadedVector = (ArrayList<PlayerData>) fileR.readObject();
            fileR.close();
        }catch(Exception e) {
            System.out.println("Ranking load failed.");
        }

        return loadedVector;
    }

    public static void write (ArrayList<PlayerData> arrayWrite, File f) {
        try {
            ObjectOutputStream fileWrite = new ObjectOutputStream(new FileOutputStream(f));
            fileWrite.writeObject(arrayWrite);
            fileWrite.close();
        }catch(IOException e) {
            System.out.println("Failed writing player data.");
        }
    }

}
