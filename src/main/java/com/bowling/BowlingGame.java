package com.bowling;

public class BowlingGame {

	private int quillesTombees;

	public void lancer(int quillesTombees) {
		this.quillesTombees = quillesTombees;
	}

	public int score() {
		return quillesTombees;
	}
}
