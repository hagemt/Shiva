package com.shiva.players;

import java.util.LinkedList;
import java.util.List;
import com.shiva.cards.PokerCard;

public class Player implements Comparable<Player> {
	private final String name;
	private List<PokerCard> hand;
	private Score score;
	
	public Player(String s) {
		name = s;
		hand = new LinkedList<PokerCard>();
		score = new Score();
	}
	
	public String getName() {
		return name;
	}
	
	public Score getScore() {
		return score;
	}
	
	public boolean isHolding(PokerCard c) {
		return hand.contains(c);
	}
	
	public boolean take(PokerCard c) {
		return hand.add(c);
	}
	
	public boolean play(PokerCard c) {
		return hand.remove(c);
	}

	@Override
	public int compareTo(Player p) {
		return name.compareTo(p.name);
	}
}
