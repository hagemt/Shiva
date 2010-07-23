package com.shiva.cards;

import com.cards.Deck;

public class PokerDeck extends Deck<PokerCard> {
	public PokerDeck() {
		for (PokerSuit suit : PokerSuit.values()) {
			for (PokerRank rank : PokerRank.values()) {
				if (rank.isStandard()) {
					cards.add(new PokerCard(suit, rank));
				}
			}
		}
	}

	@Override public boolean pullCard(PokerCard c) {
		return remove(c);
	}
}
