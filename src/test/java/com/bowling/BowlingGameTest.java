package com.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void should_score_be_0_when_game_starts() {
        BowlingGame bowlingGame = new BowlingGame();

        assertThat(bowlingGame.score()).isEqualTo(0);
    }
}
