package com.bowling;

public class BowlingGameTestBuilder {

    private int expectedScore;

    private BowlingGameTestBuilder(int expectedScore) {
        this.expectedScore = expectedScore;
    }

    public static BowlingGameTestBuilder expectScore(int score) {
        return new BowlingGameTestBuilder(score);
    }

    public Object[] forRolls(int... rolls) {
        return new Object[]{rolls, expectedScore};
    }
}
