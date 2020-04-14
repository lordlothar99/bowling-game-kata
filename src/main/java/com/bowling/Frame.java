package com.bowling;

public class Frame {
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
        return rollCount == 2;
    }
}
