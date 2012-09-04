package org.games.cards;

/**
 * Encapsulates the notion of a group of playing cards, or that of
 * a single card's characteristic shared among that group, which
 * is generally broken into ranks. The easiest way to implement
 * Suit is with an enumerated type.
 * @author Tor E Hagemann <hagemt@rpi.edu>
 * @param <S> an explicit Suit type that may match this one
 * @see org.games.cards.Card
 * @see org.games.cards.Rank
 */
public interface Suit<S extends Suit<S>> extends Comparable<S> {
	/**
	 * Retrieve the proper name of this Suit.
	 * @return a String containing this Suit's label
	 */
	public String name();
	
	/**
	 * Retrieve the symbol common to cards of this Suit.
	 * @return the character that uniquely represents this Suit
	 */
	public char getSymbol();
}
