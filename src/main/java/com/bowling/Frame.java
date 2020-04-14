package com.bowling;

import static com.bowling.BowlingGame.MAX_PINS_PER_ROLL;

public class Frame {
    public static final int MAX_ROLLS_PER_FRAME = 2;
    private int pinsDown;
    private int rollCount = 0;
    public void roll(int pins) {
        pinsDown += pins;
        rollCount++;
    }

    public int score() {
        return pinsDown;
    }

    public boolean isFinished() {
        return rollCount == MAX_ROLLS_PER_FRAME;
    }

    public boolean isSpare() {
        return pinsDown == MAX_PINS_PER_ROLL;
    }
}
