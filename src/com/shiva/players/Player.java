package com.shiva.players;

import java.util.LinkedList;
import java.util.List;
import com.shiva.cards.PokerCard;

public class Player implements Comparable<Player> {
	private final String name;
	private List<PokerCard> hand;
	
	public Player(String s) {
		name = s;
		hand = new LinkedList<PokerCard>();
	}
	
	public String getName() {
		return name;
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
