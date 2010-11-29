package com.cards;

/**
 * Encapsulates the notion of a playing card's non-suit characteristic.
 * Typically, a card's rank is used to differentiate it from other members
 * of its suit. The easiest way to implement Rank is with an enumerated type.
 * @author Tor E Hagemann <hagemt@rpi.edu>
 * @param <R> an explicit Rank type that this Rank opposes
 * @see com.cards.Card
 * @see com.cards.Suit
 */
public interface Rank<R extends Rank<R>> extends Comparable<R> {
	/**
	 * Retrieve the proper name of this Rank.
	 * @return a String containing this Rank's label
	 */
	public String name();

	/**
	 * Retrieve the symbol common to cards of this Rank.
	 * @return the character that uniquely represents this Rank
	 */
	public char getSymbol();
	
	/**
	 * Retrieve the value represented by this Rank.
	 * @return the numeric value of this Rank
	 */
	public int getValue();
	
	/**
	 * Tests to see if this Rank is in any way specialized.
	 * Specialized cards may be denoted with their own Ranks, which may be
	 * used to differentiate them from others, within a deck, for example.
	 * @return <code>true</code> if this Rank is not specialized, <code>false</code> otherwise
	 */
	public boolean isStandard();
	
	/**
	 * Tests to see if this Rank trumps a given one, and returns accordingly.
	 * This relationship is not necessarily transitive, though it should be symmetric.
	 * In general, for a given Rank <code>r</code>, <code>r.beats(r) == false</code>.
	 * @param r another Rank to pit this one against
	 * @return 
	 */
	public boolean beats(R r);
}
