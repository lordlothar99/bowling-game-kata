package com.bowling;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Lorsque;

import static org.assertj.core.api.Assertions.assertThat;
import static java.util.stream.Stream.iterate;

public class BowlingGameStepDefs {

    private BowlingGame bowlingGame;
    private Exception thrownException;

    @Etantdonné("une nouvelle partie de bowling")
    public void une_nouvelle_partie_de_bowling() {
        bowlingGame = new BowlingGame();
    }

    @Alors("le score est égal à {int}")
    public void le_score_est_égal_à(int score) {
        assertThat(bowlingGame.score()).isEqualTo(score);
    }

    @Lorsque("le joueur( a) fait tomber {int} quille(s)")
    public void le_joueur_fait_tomber_quilles(int quillesTombees) {
        try {
            bowlingGame.lancer(quillesTombees);
        } catch (Exception e) {
            this.thrownException = e;
        }
    }

    @Lorsque("le joueur( a) fait tomber {int} quille(s) {int} fois")
    public void le_joueur_fait_tomber_quilles_n_fois(int quillesTombees, int nombreDeFois) {
        iterate(0, i -> i).limit(nombreDeFois).forEach(i -> le_joueur_fait_tomber_quilles(quillesTombees));
    }

    @Alors("le nombre de manches est {int}")
    public void le_nombre_de_manches_est(int nombreManches) {
        assertThat(bowlingGame.nombreManches()).isEqualTo(nombreManches);
    }

    @Alors("il y a une erreur")
    public void il_y_a_une_erreur() {
        assertThat(thrownException).as("Une erreur devrait survenir").isNotNull();
    }

    @Alors("il y a un Spare")
    public void il_y_a_un_Spare() {
        assertThat(bowlingGame.isSpare()).isTrue();
    }

    @Alors("il y a un Strike")
    public void il_y_a_un_Strike() {
        assertThat(bowlingGame.isStrike()).isTrue();
    }

    @Alors("la manche est terminée")
    public void la_manche_est_terminée() {
        assertThat(bowlingGame.isStrike()).isTrue();
    }

    @Alors("la partie est terminée")
    public void la_partie_est_terminée() {
        assertThat(bowlingGame.estTerminee()).isTrue();
    }
}
