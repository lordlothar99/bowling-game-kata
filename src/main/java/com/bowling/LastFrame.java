package com.bowling;

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
}
