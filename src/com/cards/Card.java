package com.cards;

/**
 * Encapsulates the notion of a playing card, extendible to multiple implementations.
 * Playing cards have two properties, suit and rank. A <code>Card</code>'s rank must
 * be well-defined, but its suit may not be. Implementations of the Suit and Rank
 * interfaces--most likely enumerated types--may be specified by subclasses or
 * foregone until generic declaration.
 * @author Tor E Hagemann <hagemt@rpi.edu>
 * @param <S> an implementation of the Suit interface
 * @param <R> an implementation of the Rank interface
 * @see com.cards.Suit
 * @see com.cards.Rank
 */
public abstract class Card<R extends Rank<R>, S extends Suit<S>> {
	/**
	 * The playing card's suit.
	 */
	protected S suit;
	
	/**
	 * The playing card's rank, which must be well-defined.
	 */
	protected R rank;
	
	/**
	 * Defines a default card. Note: the current version of this constructor generates
	 * an <code>IllegalArgumentException</code>, since it does not define rank. This is
	 * done to force subclasses to abide by standards of the implementation.
	 * @throws IllegalArgumentException
	 */
	protected Card() {
		this(null, null);
	}
	
	/**
	 * Constructs a playing card with the specified suit and rank.
	 * @param s the given Suit
	 * @param r the given Rank
	 * @throws IllegalArgumentException if <code>r</code> is <code>null</code>
	 */
	protected Card(S s, R r) {
		if (r == null) {
			throw new IllegalArgumentException("rank cannot be null");
		}
		suit = s;
		rank = r;
	}
	
	/**
	 * Accessor to fetch this playing card's suit, which may be undefined.
	 * @return this card's suit
	 */
	public S getSuit() { return suit; }
	
	/**
	 * Accessor to fetch this playing card's rank, which must be defined.
	 * @return this card's rank
	 */
	public R getRank() { return rank; }
}
