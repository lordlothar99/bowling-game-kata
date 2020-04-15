package com.bowling;

public class Manche {

    public static final int NOMBRE_MAX_DE_QUILLES_PAR_MANCHE = 10;
    public static final int NOMBRE_MAX_DE_LANCERS = 2;
    protected int[] quillesTombees = new int[NOMBRE_MAX_DE_LANCERS];
    protected int nombreLancers;
    private Manche mancheSuivante;
    private int numeroManche;

    public Manche(int numeroManche) {
        this.numeroManche = numeroManche;
    }

    public void lancer(int quillesTombees) {
        if (score1erLancer() + quillesTombees > NOMBRE_MAX_DE_QUILLES_PAR_MANCHE) {
            throw new RuntimeException("Mais d'ou viennent ces quilles ??");
        }
        this.quillesTombees[nombreLancers] = quillesTombees;
        nombreLancers++;
    }

    public int score() {
        return totalQuillesTombees() + bonus();
    }

    protected int bonus() {
        int bonus = 0;
        if (mancheSuivante != null) {
            if (estUnSpare()) {
                bonus = mancheSuivante.score1erLancer();
            } else if (estUnStrike()) {
                bonus = mancheSuivante.score2Lancers();
            }
        }
        return bonus;
    }

    protected int score2Lancers() {
        int score2Lancers = score1erLancer();
        if (!estUnStrike()) {
            score2Lancers += score2eLancer();
        } else if (mancheSuivante != null){
            score2Lancers += mancheSuivante.score1erLancer();
        }
        return score2Lancers;
    }

    protected int totalQuillesTombees() {
        return score1erLancer() + score2eLancer();
    }

    protected int score1erLancer() {
        return this.quillesTombees[0];
    }

    protected int score2eLancer() {
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
            mancheSuivante = numeroManche == 9 ?
                    new DerniereManche() :
                    new Manche(numeroManche + 1);
        }
        return mancheSuivante;
    }

    public boolean estUnStrike() {
        return nombreLancers == 1 && totalQuillesTombees() == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }
}
