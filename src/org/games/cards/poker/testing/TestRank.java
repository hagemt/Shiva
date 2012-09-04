package org.games.cards.poker.testing;

import static org.junit.Assert.*;
import org.junit.Test;
import org.games.cards.poker.PokerRank;

/**
 * Test cases for non-trivial methods in the PokerRank class.
 * @author Tor E Hagemann <hagemt@rpi.edu>
 * @see org.games.cards.poker.PokerRank#beats(org.games.cards.poker.PokerRank)
 */
public class TestRank {
	@Test
	public void testBeatsPokerRankBooleanDiagonal() {
		for (PokerRank r : PokerRank.values()) {
			assertFalse(r.beats(r));
		}
	}
	@Test
	public void testBeatsPokerRankBooleanJoker() {
		for (PokerRank r : PokerRank.values()) {
			assertFalse(r.beats(PokerRank.JOKER));
		}
	}
	@Test
	public void testBeatsPokerRankBooleanAce() {
		for (PokerRank r : PokerRank.values()) {
			if (r != PokerRank.JOKER && r != PokerRank.ACE) {
				assertTrue(PokerRank.ACE.beats(r));
			}
			assertFalse(PokerRank.ACE.beats(r, false));
		}
	}
	@Test
	public void testBeatsPokerRankBooleanRandom() {
		// Try a large number of random bounded comparisons
		PokerRank[] ranks = PokerRank.values();
		int num_values = ranks.length - 1;
		for (int i = 0; i < 1000000; ++i) {
			// Index in the interval [1, ranks.length)
			int a = (int)(Math.random() * num_values) + 1;
			// Index in the interval [a, ranks.length)
			int b = (int)(Math.random() * (num_values - a)) + a;
			// We require higher ranks to beat lower ones
			assertFalse(ranks[a].beats(ranks[b], false));
		}
	}
}
