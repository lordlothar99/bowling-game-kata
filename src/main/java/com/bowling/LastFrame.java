package com.bowling;

import static com.bowling.BowlingGame.MAX_PINS_PER_ROLL;

public class LastFrame extends Frame {

    public static final int MAX_ROLLS = 3;

    public LastFrame(Frame currentFrame) {
        super(currentFrame, MAX_ROLLS);
    }

    protected int maxRolls() {
        return isSpare() || isStrike() ? MAX_ROLLS : super.maxRolls();
    }

    public boolean isFinished() {
        return rollCount == maxRolls();
    }

    public int score() {
        int score = super.score();
        if (isDoubleStrike()) {
            score += MAX_PINS_PER_ROLL;
        }
        return score;
    }

    private boolean isDoubleStrike() {
        return pinsDown[0] == MAX_PINS_PER_ROLL &&
                pinsDown[1] == MAX_PINS_PER_ROLL;
    }
}
