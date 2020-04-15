package com.bowling;

public class BowlingGame {

	private int pins;

	public void roll(int pins) {
		this.pins = pins;
	}

	public int score() {
		return pins;
	}
}
