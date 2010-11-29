package com.shiva.cards;

import com.cards.Card;

/**
 * 
 * @author Tor E Hagemann <hagemt@rpi.edu>
 * @see com.cards.Card
 */
public class PokerCard extends Card<PokerSuit, PokerRank> {
	/**
	 * Constructs a new PokerCard with the given suit and rank.
	 * Note that according to the supertype's implementation,
	 * a PokerCard's rank cannot be undefined.
	 * @param s a member of the PokerSuit enumeration, or <code>null</code>
	 * @param r a member of the PokerRank enumeration
	 */
	public PokerCard(PokerSuit s, PokerRank r) {
		super(s, r);
	}

	/**
	 * Retrieves a textual description of this PokerCard, which
	 * contains its rank and, if it is defined, its suit.
	 * @return a String containing this PokerCard's representation
	 */
	public String toString() {
		return (rank.isJoker()) ? "Joker" : rank + " of " + suit;
	}
}
