package com.bowling;

public class BowlingGame {

    private int pinsDown;

    public void roll(int pins) {
        if (pins > 10) {
            throw new RuntimeException("There are only 10 pins, cheater !");
        }
        pinsDown += pins;
    }

    public int score() {
        return pinsDown;
    }
}
