package com.bowling;

public class Manche {

    private int score;
    private int nombreLancers;

    public void lancer(int quillesTombees) {
        this.score += quillesTombees;
        nombreLancers++;
    }

    public int score() {
        return score;
    }

    public boolean estTerminee() {
        return nombreLancers == 2;
    }
}
