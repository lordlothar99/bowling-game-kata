package com.bowling;

import static com.bowling.BowlingGame.MAX_PINS_PER_ROLL;

public class Frame {
    public static final int MAX_ROLLS_PER_FRAME = 2;

    private int[] pinsDown = new int[2];
    private int rollCount = 0;
    private Frame nextFrame;

    Frame() {
    }
    Frame(Frame previousFrame) {
        previousFrame.nextFrame = this;
    }

    public void roll(int pins) {
        pinsDown[rollCount] += pins;
        rollCount++;
    }

    public int score() {
        int score = pinsDown[0] + pinsDown[1];
        if (isSpare() && nextFrame != null) {
            score += nextFrame.pinsDown[0];
        }
        return score;
    }

    public boolean isFinished() {
        return rollCount == MAX_ROLLS_PER_FRAME;
    }

    public boolean isSpare() {
        return pinsDown[0] + pinsDown[1] == MAX_PINS_PER_ROLL;
    }

    public int totalScore() {
        int totalScore = score();
        if (nextFrame != null) {
            totalScore +=nextFrame.totalScore();
        }
        return totalScore;
    }
}
