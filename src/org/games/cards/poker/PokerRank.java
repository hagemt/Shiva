package org.games.cards.poker;

import org.games.cards.Rank;

public enum PokerRank implements Rank<PokerRank> {
	JOKER('$'), ACE('A'),
	TWO('2'), THREE('3'), FOUR('4'), FIVE('5'),
	SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'),
	TEN('T'), JACK('J'), QUEEN('Q'), KING('K');

	private char symbol;

	private PokerRank(char symbol) {
		this.symbol = symbol;
	}

	public boolean beats(PokerRank r, boolean acesHigh) {
		// Nothing beats itself or a joker
		if (r == this || r == JOKER) {
			return false;
		} else if (r == ACE) {
			// If aces are high, then we do not win, provided we are not a joker
			return (acesHigh ? (this != JOKER) : true);
			// If aces are not high, we win, since we cannot be an ace
		} else if (this == ACE) {
			// r cannot be an ace or a joker, so we win/lose depending on ace behavior
			return acesHigh;
		} else {
			// Otherwise, be monotonic
			return (getValue() > r.getValue());
		}
	}

	@Override
	public boolean beats(PokerRank r) {
		return beats(r, true);
	}

	@Override
	public boolean isStandard() {
		return (this != JOKER);
	}

	@Override
	public char getSymbol() {
		return symbol;
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
