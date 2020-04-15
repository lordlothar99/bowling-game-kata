package com.bowling;

public class Manche {

    public static final int NOMBRE_MAX_DE_QUILLES_PAR_MANCHE = 10;
    public static final int NOMBRE_MAX_DE_LANCERS = 2;
    private int[] quillesTombees = new int[NOMBRE_MAX_DE_LANCERS];
    private int nombreLancers;
    private Manche mancheSuivante;

    public void lancer(int quillesTombees) {
        if (score1erLancer() + quillesTombees > NOMBRE_MAX_DE_QUILLES_PAR_MANCHE) {
            throw new RuntimeException("Mais d'ou viennent ces quilles ??");
        }
        this.quillesTombees[nombreLancers] = quillesTombees;
        nombreLancers++;
    }

    public int score() {
        int bonus = 0;
        if (mancheSuivante != null) {
            if (estUnSpare()) {
                bonus = mancheSuivante.score1erLancer();
            } else if (estUnStrike()) {
                bonus = mancheSuivante.score2LancersSuivants();
            }
        }
        return totalQuillesTombees() + bonus;
    }

    private int score2LancersSuivants() {
        int deux2Suivants = score1erLancer();
        if (!estUnStrike()) {
            deux2Suivants += score2eLancer();
        } else if (mancheSuivante != null){
            deux2Suivants += mancheSuivante.score1erLancer();
        }
        return deux2Suivants;
    }

    private int totalQuillesTombees() {
        return score1erLancer() + score2eLancer();
    }

    private int score1erLancer() {
        return this.quillesTombees[0];
    }

    private int score2eLancer() {
        return this.quillesTombees[1];
    }

    public boolean estTerminee() {
        return nombreLancers == NOMBRE_MAX_DE_LANCERS || estUnStrike();
    }

    public boolean estUnSpare() {
        return nombreLancers == 2 && totalQuillesTombees() == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }

    public Manche mancheSuivante() {
        if (mancheSuivante == null) {
            mancheSuivante = new Manche();
        }
        return mancheSuivante;
    }

    public boolean estUnStrike() {
        return nombreLancers == 1 && totalQuillesTombees() == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }
}
