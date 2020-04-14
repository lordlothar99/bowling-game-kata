package com.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> frames = new ArrayList<>();

    public BowlingGame() {
        frames.add(new Frame());
    }

    public void roll(int pins) {
        if (pins > 10) {
            throw new RuntimeException("There are only 10 pins, cheater !");
        }
        if (currentFrame().isFinished()) {
            frames.add(new Frame());
        }
        currentFrame().roll(pins);
    }

    private Frame currentFrame() {
        return frames.get(frames.size() - 1);
    }

    public int score() {
        return frames.stream().mapToInt(Frame::score).sum();
    }

    public int framesCount() {
        return frames.size();
    }
}
