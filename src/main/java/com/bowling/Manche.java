package com.bowling;

public class Manche {

    public static final int NOMBRE_MAX_DE_QUILLES_PAR_MANCHE = 10;
    public static final int NOMBRE_MAX_DE_LANCERS = 2;
    private int[] quillesTombees = new int[NOMBRE_MAX_DE_LANCERS];
    private int nombreLancers;
    private Manche mancheSuivante;

    public void lancer(int quillesTombees) {
        if (premierLancer() + quillesTombees > NOMBRE_MAX_DE_QUILLES_PAR_MANCHE) {
            throw new RuntimeException("Mais d'ou viennent ces quilles ??");
        }
        this.quillesTombees[nombreLancers] = quillesTombees;
        nombreLancers++;
    }

    public int score() {
        int bonus = 0;
        if (isSpare() && mancheSuivante != null) {
            bonus = mancheSuivante.premierLancer();
        }
        return totalQuillesTombees() + bonus;
    }

    private int totalQuillesTombees() {
        return premierLancer() + secondLancer();
    }

    private int premierLancer() {
        return this.quillesTombees[0];
    }

    private int secondLancer() {
        return this.quillesTombees[1];
    }

    public boolean estTerminee() {
        return nombreLancers == NOMBRE_MAX_DE_LANCERS;
    }

    public boolean isSpare() {
        return nombreLancers == 2 && totalQuillesTombees() == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }

    public Manche mancheSuivante() {
        if (mancheSuivante == null) {
            mancheSuivante = new Manche();
        }
        return mancheSuivante;
    }

    public boolean isStrike() {
        return nombreLancers == 1 && totalQuillesTombees() == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }
}
