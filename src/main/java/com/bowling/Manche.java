package com.bowling;

public class Manche {

    private int score;
    private int nombreLancers;

    public void lancer(int quillesTombees) {
        if (score + quillesTombees > 10) {
            throw new RuntimeException("Mais d'ou viennent ces quilles ??");
        }
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
