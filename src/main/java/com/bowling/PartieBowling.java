package com.bowling;

import java.util.ArrayList;
import java.util.List;

public class PartieBowling {

    public static final int NOMBRE_MAX_DE_MANCHES = 10;
    private Manche mancheEnCours;
    private List<Manche> manches;

    public PartieBowling() {
        manches = new ArrayList<>();
        mancheEnCours = new Manche();
        manches.add(mancheEnCours);
    }

    public void lancer(int quillesTombees) {
        if (estTerminee()) {
            throw new RuntimeException("La partie est terminée !");
        }
        if (mancheEnCours.estTerminee()) {
            mancheEnCours = mancheEnCours.mancheSuivante();
            manches.add(mancheEnCours);
        }
        mancheEnCours.lancer(quillesTombees);
    }

    public int score() {
        return manches.stream().mapToInt(m -> m.score()).sum();
    }

    public int nombreManches() {
        return manches.size();
    }

    public boolean isSpare() {
        return mancheEnCours.estUnSpare();
    }

    public boolean isStrike() {
        return mancheEnCours.estUnStrike();
    }

    public boolean estTerminee() {
        return mancheEnCours.estTerminee() && nombreManches() == NOMBRE_MAX_DE_MANCHES;
    }
}
