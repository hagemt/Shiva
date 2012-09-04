package com.shiva.cards;

import java.util.Random;
import com.cards.Deck;

public class PokerDeck extends Deck<PokerCard> {
	/**
	 * Constructs a standard 52-card deck with no jokers, left in order.
	 * More specifically, adds one of each rank from each suit specified by PokerCard.
	 * @see com.shiva.cards.PokerCard
	 */
	public PokerDeck() {
		for (PokerSuit suit : PokerSuit.values()) {
			for (PokerRank rank : PokerRank.values()) {
				if (rank.isStandard()) {
					cards.add(new PokerCard(rank, suit));
				}
			}
		}
	}

	/**
	 * Shuffles this PokerDeck a minimum of five times using:
	 * http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
	 * An interesting paper on this topic may be found here:
	 * http://www-stat.stanford.edu/~cgates/PERSI/papers/repeatcards.pdf
	 */
	@Override
	public void shuffle() {
		Random r = new Random(System.nanoTime());
		for (int i = r.nextInt(5) + 5; i > 0; --i) {
			super.shuffle(r);
		}
	}

	@Override
	public Class<PokerCard> cardType() {
		return PokerCard.class;
	}
}
