package org.games;

public abstract class Player implements Comparable<Player> {
	protected final String name;
	protected Score score;
	
	protected Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String score() {
		return score.toString();
	}
	
	public int compareTo(Player p) {
		int diff = score.compareTo(p.score);
		return (diff == 0) ? name.compareTo(p.name) : diff;
	}
}
