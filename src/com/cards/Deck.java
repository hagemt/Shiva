package com.cards;

import java.util.AbstractQueue;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Deck<C extends Card<? extends Suit<?>, ? extends Rank<?>>> extends AbstractQueue<C> {
	protected List<C> cards;
	protected Deck() {
		cards = new LinkedList<C>();
	}
	public abstract boolean pullCard(C c);
	public int size() {
		return cards.size();
	}
	public void shuffle() {
		shuffle(new Random(System.nanoTime()));
	}
	public void shuffle(Random r) {
		Collections.shuffle(cards, r);
	}
	@Override public Iterator<C> iterator() {
		return cards.iterator();
	}
	@Override public boolean offer(C c) {
		return cards.add(c);
	}
	@Override public C peek() {
		return (cards.isEmpty()) ? null : cards.get(0);
	}
	@Override public C poll() {
		return (cards.isEmpty()) ? null : cards.remove(0);
	}
}
