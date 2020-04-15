package com.bowling;

public class Manche {

    public static final int NOMBRE_MAX_DE_QUILLES_PAR_MANCHE = 10;
    private int score;
    private int nombreLancers;

    public void lancer(int quillesTombees) {
        if (score + quillesTombees > NOMBRE_MAX_DE_QUILLES_PAR_MANCHE) {
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

    public boolean isSpare() {
        return nombreLancers == 2 && score == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }
}
