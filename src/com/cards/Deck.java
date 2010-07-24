package com.cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Deck<C extends Card<? extends Suit<?>, ? extends Rank<?>>> {
	protected List<C> cards;

	protected Deck() {
		cards = new LinkedList<C>();
	}

	public boolean pull(C c) {
		return cards.remove(c);
	}

	public C draw() {
		return (cards.isEmpty()) ? null : cards.remove(0);
	}

	public int size() {
		return cards.size();
	}

	public void shuffle() {
		shuffle(new Random(System.nanoTime()));
	}

	public void shuffle(Random r) {
		Collections.shuffle(cards, r);
	}

	public abstract Class<C> cardType();
}
