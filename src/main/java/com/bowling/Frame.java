package com.bowling;

import java.util.Arrays;

import static com.bowling.BowlingGame.MAX_PINS_PER_ROLL;
import static java.util.Arrays.stream;

public class Frame {
    private static final int MAX_ROLLS_PER_FRAME = 2;

    private int[] pinsDown;
    protected int rollCount = 0;
    private Frame nextFrame;

    Frame() {
        pinsDown = new int[MAX_ROLLS_PER_FRAME];
    }

    Frame(Frame previousFrame) {
        this();
        previousFrame.nextFrame = this;
    }

    protected Frame(Frame previousFrame, int maxRolls) {
        pinsDown = new int[maxRolls];
        previousFrame.nextFrame = this;
    }

    public void roll(int pins) {
        pinsDown[rollCount] += pins;
        rollCount++;
    }

    public int totalScore() {
        int totalScore = score();
        if (hasNextFrame()) {
            totalScore += nextFrame.totalScore();
        }
        return totalScore;
    }

    public int score() {
        int score = innerScore();
        if (hasNextFrame()) {
            if (isSpare()) {
                score += nextFrame.firstRollScore();
            }
            if (isStrike()) {
                score += nextFrame.firstRollScore() + nextFrame.secondRollScore();
            }
        }
        return score;
    }

    private boolean hasNextFrame() {
        return nextFrame != null;
    }

    private int innerScore() {
        return stream(pinsDown).sum();
    }

    private int firstRollScore() {
        return pinsDown[0];
    }

    private int secondRollScore() {
        if (!isStrike()) {
            return pinsDown[1];
        } else if (hasNextFrame()) {
            return nextFrame.firstRollScore();
        } else {
            return 0;
        }
    }

    public boolean isFinished() {
        return rollCount == maxRolls() || isStrike();
    }

    protected int maxRolls() {
        return 2;
    }

    public boolean isSpare() {
        return innerScore() == MAX_PINS_PER_ROLL && rollCount == 2;
    }

    public boolean isStrike() {
        return innerScore() == MAX_PINS_PER_ROLL && rollCount == 1;
    }
}
