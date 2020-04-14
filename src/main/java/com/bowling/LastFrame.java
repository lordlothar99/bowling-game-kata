package com.bowling;

public class LastFrame extends Frame {
    public LastFrame(Frame currentFrame) {
        super(currentFrame, 3);
    }

    protected int maxRolls() {
        return isSpare() ? 3 : super.maxRolls();
    }
}
