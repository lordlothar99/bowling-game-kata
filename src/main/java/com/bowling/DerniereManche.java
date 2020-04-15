package com.bowling;

import static com.bowling.PartieBowling.NOMBRE_MAX_DE_MANCHES;

public class DerniereManche extends Manche {

    public DerniereManche() {
        super(NOMBRE_MAX_DE_MANCHES);
        quillesTombees = new int[3];
    }

    public void lancer(int quillesTombees) {
        if (!estUnSpare()) {
            super.lancer(quillesTombees);
        } else {
            this.quillesTombees[nombreLancers] = quillesTombees;
            nombreLancers++;
        }
    }

    @Override
    public boolean estTerminee() {
        if (estUnSpare()) {
            return nombreLancers == 3;
        } else {
            return super.estTerminee();
        }
    }

    public boolean estUnSpare() {
        return score1erLancer() + score2eLancer() == NOMBRE_MAX_DE_QUILLES_PAR_MANCHE;
    }
}
