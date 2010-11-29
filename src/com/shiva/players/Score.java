package com.shiva.players;

public class Score {
	private int wins, losses, ties;
	
	public Score() {
		wins = losses = ties = 0;
	}

	public String toString() {
		return wins + "/" + losses + "/" + ties;
	}
}
