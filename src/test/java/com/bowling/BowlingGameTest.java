package com.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {

    @Test
    public void should_score_be_0_when_game_starts() {
        BowlingGame bowlingGame = new BowlingGame();

        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void should_score_equal_number_of_pins_down_when_player_hits_pins() {
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(4);

        assertThat(bowlingGame.score()).isEqualTo(4);
    }

    @Test
    public void should_score_equal_the_sum_of_pins_down_when_player_hits_pins() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(4);

        bowlingGame.roll(4);

        assertThat(bowlingGame.score()).isEqualTo(8);
    }
}
