package com.bowling;

public class Manche {

    public static final int NOMBRE_MAX_DE_QUILLES_PAR_MANCHE = 10;
    public static final int NOMBRE_MAX_DE_LANCERS = 2;
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
        return nombreLancers == NOMBRE_MAX_DE_LANCERS;
    }

    public boolean isSpare() {
        return nombreLancers == 2 && score == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }
}
