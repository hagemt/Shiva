package com.cards;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Encapsulates the notion of a deck of cards of a given type. This may be specified
 * by subclasses or deferred until declaration, whichever is more convenient to use in
 * implementation. A deck is a sort of pseudo-Collection that subclasses are to fill
 * with an initial state. This abstract class facilitates construction by initializing
 * the underlying structure of cards as empty, <em>nothing</em> further. Decks may
 * function as a FIFO or LIFO queue, and subclasses should take care to specify which
 * is to be created.
 * @author Tor E Hagemann <hagemt@rpi.edu>
 * @param <C> an subclass of Card, with its own Suit and Rank type
 * @see java.util.Collection
 */
public abstract class Deck<C extends Card<? extends Rank<?>, ? extends Suit<?>>> implements Iterable<C> {
	/**
	 * The underlying list of cards of the given type.
	 */
	protected List<C> cards;

	/**
	 * Constructs a default (empty) deck.
	 */
	protected Deck() {
		cards = new LinkedList<C>();
	}

	/**
	 * Remove a specified card from this deck.
	 * @param c the particular element to remove
	 * @return whether or not <code>c</code> was successfully removed
	 */
	public boolean pull(C c) {
		return cards.remove(c);
	}
	
	/**
	 * Add a specified card to this deck.
	 * @param c the particular element to add
	 * @return whether or not <code>c</code> was successfully added
	 */
	public boolean feed(C c) {
		return cards.add(c);
	}

	/**
	 * Yields a card of this deck's cards' type. Following a call to this
	 * method, the yielded card should not be contained within this deck.
	 * If this deck is void of cards or no card can be drawn,
	 * <code>null</code> is returned instead.
	 * @return a card formerly in this deck, or <code>null</code> if none are available
	 */
	public C draw() {
		return (cards.isEmpty()) ? null : cards.remove(0);
	}

	/**
	 * Retrieve this deck's effective size.
	 * @return the number of cards remaining in this deck.
	 */
	public int size() {
		return cards.size();
	}

	/**
	 * Shuffles the deck once using randomness seeded by the system time.
	 */
	public void shuffle() {
		shuffle(new Random(System.nanoTime()));
	}

	/**
	 * Shuffles the deck once using the specified source of randomness.
	 * @param r a seeded random number generator
	 */
	public void shuffle(Random r) {
		Collections.shuffle(cards, r);
	}

	@Override
	public Iterator<C> iterator() {
		return cards.iterator();
	}

	/**
	 * Retrieve this deck's cards' type. The specified return type requires subtypes
	 * to implement a means by which new cards of the proper type can be generated.
	 * @return the class of cards this deck holds
	 */
	public abstract Class<? extends C> cardType();
}
