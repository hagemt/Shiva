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
	
	public boolean beats(PokerRank r, boolean acesHigh) {
		if (equals(r) || r.isJoker()) { return false; }
		switch (this) {
			case JOKER : return true;
			case ACE : return acesHigh && !r.isJoker();
			default : return (r.isAce()) ? !acesHigh : ordinal() > r.ordinal();
		}
	}

	@Override
	public boolean beats(PokerRank r) {
		return beats(r, true);
	}

	@Override
	public boolean isStandard() {
		return !equals(JOKER);
	}

	@Override
	public char getSymbol() {
		switch (this) {
			case JOKER : return '$';
			case ACE : return 'A';
			case JACK : return 'J';
			case QUEEN : return 'Q';
			case KING : return 'K';
			case TEN : return 'T';
			default : return (char)('0' + ordinal());
		}
	}

	@Override
	public int getValue() {
		return ordinal();
	}
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
