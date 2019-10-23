package com.mainpakage.sprites;

public class PlayerData {
    private String playerName;
    private int finalScore;

    public PlayerData (String pn, int fs) {
        this.playerName = pn;
        this.finalScore = fs;
    }

    public int getFinalScore () {
        return this.finalScore;
    }

    public void setPlayerName (String pn) {
        this.playerName = pn;
    }

    public void setFinalScore (int fs) {
        this.finalScore = fs;
    }

}
