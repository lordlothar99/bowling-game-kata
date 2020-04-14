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

    @Test
    public void should_be_a_spare_when_10_pins_down_in_same_frame_with_two_rolls() {
        bowlingGame.roll(4);

        bowlingGame.roll(6);

        assertThat(bowlingGame.isSpare()).isEqualTo(true);
    }

    @Test
    public void should_next_roll_counts_twice_when_there_is_a_spare() {
        bowlingGame.roll(4);
        bowlingGame.roll(6);

        bowlingGame.roll(6);

        assertThat(bowlingGame.score()).isEqualTo(22);
    }

    @Test
    public void should_be_a_strike_when_10_pins_down_in_same_frame_with_one_rolls() {
        bowlingGame.roll(10);

        assertThat(bowlingGame.isStrike()).isEqualTo(true);
    }

    @Test
    public void should_frame_be_over_when_there_is_a_strike() {
        bowlingGame.roll(10);

        bowlingGame.roll(2);

        assertThat(bowlingGame.framesCount()).isEqualTo(2);
    }

    @Test
    public void should_next_two_rolls_count_twice_when_there_is_a_strike() {
        bowlingGame.roll(10);
        bowlingGame.roll(6);

        bowlingGame.roll(3);

        assertThat(bowlingGame.score()).isEqualTo(28);
    }
}
