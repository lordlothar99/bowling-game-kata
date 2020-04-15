package com.bowling;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Lorsque;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameStepDefs {

    private BowlingGame bowlingGame;

    @Etantdonné("une nouvelle partie de bowling")
    public void une_nouvelle_partie_de_bowling() {
        bowlingGame = new BowlingGame();
    }

    @Alors("le score est égal à {int}")
    public void le_score_est_égal_à(int score) {
        assertThat(bowlingGame.score()).isEqualTo(score);
    }

    @Lorsque("le joueur( a) fait tomber {int} quilles")
    public void le_joueur_fait_tomber_quilles(int quilles) {
        bowlingGame.lancer(quilles);
    }
}
