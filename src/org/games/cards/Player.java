package org.games.cards;

import java.util.Collection;

public abstract class Player<C extends Card<? extends Rank<?>, ? extends Suit<?>>> extends org.games.Player {
	protected Collection<C> hand;

	protected Player(String name) {
		super(name);
	}
	
	public boolean has(C c) {
		return hand.contains(c);
	}
	
	public boolean take(C c) {
		return hand.add(c);
	}
	
	public boolean play(C c) {
		return hand.remove(c);
	}
}
