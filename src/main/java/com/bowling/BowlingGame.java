package com.bowling;

public class BowlingGame {

    private int pinsDown;

    public void roll(int pins) {
        pinsDown += pins;
    }

    public int score() {
        return pinsDown;
    }
}
