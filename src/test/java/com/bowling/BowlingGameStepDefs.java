package com.bowling;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import org.assertj.core.api.Assertions;

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
}
