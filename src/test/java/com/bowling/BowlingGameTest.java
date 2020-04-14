package com.bowling;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameTest {
    private BowlingGame bowlingGame = new BowlingGame();

    @Test
    public void should_score_be_0_when_game_starts() {
        assertThat(bowlingGame.score()).isEqualTo(0);
    }

    @Test
    public void should_score_equal_number_of_pins_down_when_player_hits_pins() {
        bowlingGame.roll(4);

        assertThat(bowlingGame.score()).isEqualTo(4);
    }

    @Test
    public void should_score_equal_the_sum_of_pins_down_when_player_hits_pins() {
        bowlingGame.roll(4);

        bowlingGame.roll(4);

        assertThat(bowlingGame.score()).isEqualTo(8);
    }

    @Test(expected = RuntimeException.class)
    public void should_raise_an_error_when_cheater_player_hits_more_than_10_pins() {
        bowlingGame.roll(11);
    }

    @Test
    public void should_player_have_maximum_two_rolls_per_frame() {
        bowlingGame.roll(4);
        bowlingGame.roll(4);

        bowlingGame.roll(4);

        assertThat(bowlingGame.framesCount()).isEqualTo(2);
    }
}
