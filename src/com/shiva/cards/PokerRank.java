package com.shiva.cards;

import com.cards.Rank;

public enum PokerRank implements Rank<PokerRank> {
	JOKER, ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

	public boolean isJoker() {
		return equals(JOKER);
	}
	
	public boolean isAce() {
		return equals(ACE);
	}
	
	private boolean isOdd() {
		return equals(JOKER) || equals(ACE);
	}
	
	public boolean beats(PokerRank r, boolean acesHigh) {
		switch (this) {
			case JOKER : return !r.isJoker();
			case ACE : return !r.isOdd();
			default : return ordinal() > r.ordinal();
		}
	}

	@Override public boolean beats(PokerRank r) {
		return beats(r, true);
	}

	@Override public boolean isStandard() {
		return !equals(JOKER);
	}

	@Override public char getSymbol() {
		switch (this) {
			case JOKER : return '$';
			case ACE : return 'A';
			case JACK : return 'J';
			case QUEEN : return 'Q';
			case KING : return 'K';
			default : return (char)('0' + ordinal());
		}
	}

	@Override public int getValue() {
		return ordinal();
	}
	
	@Override public String toString() {
		return name().toLowerCase();
	}
}
