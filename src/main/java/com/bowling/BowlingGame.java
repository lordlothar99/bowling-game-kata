package com.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private Manche mancheEnCours;
    private List<Manche> manches;

    public BowlingGame() {
        manches = new ArrayList<>();
        mancheEnCours = new Manche();
        manches.add(mancheEnCours);
    }

    public void lancer(int quillesTombees) {
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
        return mancheEnCours.isSpare();
    }
}
