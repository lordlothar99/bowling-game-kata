package com.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int MAX_PINS_PER_ROLL = 10;
    private Frame currentFrame;
    private Frame firstFrame;
    private int framesCount = 1;

    public BowlingGame() {
        firstFrame = new Frame();
        currentFrame = firstFrame;
    }

    public void roll(int pins) {
        if (pins > MAX_PINS_PER_ROLL) {
            throw new RuntimeException("There are only 10 pins, cheater !");
        }
        if (currentFrame.isFinished()) {
            currentFrame = new Frame(currentFrame);
            framesCount++;
        }
        currentFrame.roll(pins);
    }

    public int score() {
        return firstFrame.totalScore();
    }

    public int framesCount() {
        return framesCount;
    }

    public boolean isSpare() {
        return currentFrame.isSpare();
    }

    public boolean isStrike() {
        return currentFrame.isStrike();
    }

    public boolean isFinished() {
        return framesCount == 10 && currentFrame.isFinished();
    }
}
