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

    public int totalScore() {
        int totalScore = score();
        if (nextFrame != null) {
            totalScore += nextFrame.totalScore();
        }
        return totalScore;
    }

    public int score() {
        int score = innerScore();
        if (nextFrame != null) {
            if (isSpare()) {
                score += nextFrame.firstRollScore();
            }
            if (isStrike()) {
                score += nextFrame.firstRollScore() + nextFrame.secondRollScore();
            }
        }
        return score;
    }

    private int innerScore() {
        return firstRollScore() + pinsDown[1];
    }

    private int firstRollScore() {
        return pinsDown[0];
    }

    private int secondRollScore() {
        if (!isStrike()) {
            return pinsDown[1];
        } else if (nextFrame != null) {
            return nextFrame.firstRollScore();
        } else {
            return 0;
        }
    }

    public boolean isFinished() {
        return rollCount == MAX_ROLLS_PER_FRAME || isStrike();
    }

    public boolean isSpare() {
        return innerScore() == MAX_PINS_PER_ROLL && rollCount == 2;
    }

    public boolean isStrike() {
        return innerScore() == MAX_PINS_PER_ROLL && rollCount == 1;
    }
}
