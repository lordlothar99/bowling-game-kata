package com.bowling;

import org.assertj.core.util.Streams;
import org.junit.Test;

import java.util.stream.Stream;

import static java.util.stream.Stream.iterate;
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

        assertThat(bowlingGame.isSpare()).isTrue();
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

        assertThat(bowlingGame.isStrike()).isTrue();
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

    @Test
    public void should_game_be_finished_when_there_are_10_frames() {
        iterate(0, i -> i).limit(10).forEach(i -> {
            bowlingGame.roll(3);
            bowlingGame.roll(3);
        });

        assertThat(bowlingGame.framesCount()).isEqualTo(10);
        assertThat(bowlingGame.isFinished()).isTrue();
    }

    @Test(expected = RuntimeException.class)
    public void should_raise_an_error_when_player_tries_to_play_after_game_is_finished() {
        iterate(0, i -> i).limit(10).forEach(i -> {
            bowlingGame.roll(3);
            bowlingGame.roll(3);
        });

        bowlingGame.roll(3);
    }

    @Test
    public void should_have_one_bonus_roll_when_spare_on_last_frame() {
        iterate(0, i -> i).limit(9).forEach(i -> {
            bowlingGame.roll(0);
            bowlingGame.roll(0);
        });
        bowlingGame.roll(5);
        bowlingGame.roll(5);

        bowlingGame.roll(7);

        assertThat(bowlingGame.score()).isEqualTo(17);
    }

    @Test
    public void should_have_two_bonus_rolls_when_strike_on_last_frame() {
        iterate(0, i -> i).limit(9).forEach(i -> {
            bowlingGame.roll(0);
            bowlingGame.roll(0);
        });
        bowlingGame.roll(10);
        bowlingGame.roll(7);

        bowlingGame.roll(2);

        assertThat(bowlingGame.score()).isEqualTo(19);
    }

    @Test
    public void should_max_score_be_300_when_player_does_only_strikes() {
        iterate(0, i -> i).limit(12).forEach(i -> {
            bowlingGame.roll(10);
        });

        assertThat(bowlingGame.score()).isEqualTo(300);
    }
}
