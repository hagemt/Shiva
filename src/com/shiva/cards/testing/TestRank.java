package com.shiva.cards.testing;

import static org.junit.Assert.*;
import org.junit.Test;
import com.shiva.cards.PokerRank;

/**
 * Test cases for non-trivial methods in the PokerRank class.
 * @author Tor E Hagemann <hagemt@rpi.edu>
 * @see com.shiva.cards.PokerRank#beats(com.shiva.cards.PokerRank)
 */
public class TestRank {
	@Test
	public void testBeatsPokerRankBoolean() {
		// Try all PokerRanks against their corner cases
		for (PokerRank r : PokerRank.values()) {
			assertFalse(r.beats(r));
			assertFalse(r.beats(PokerRank.JOKER));
			if (r.isStandard() && !r.isAce()) {
				assertTrue(PokerRank.ACE.beats(r));
				assertFalse(PokerRank.ACE.beats(r, false));
			}
		}
		// Try a large number of random bounded comparisons
		PokerRank[] ranks = PokerRank.values();
		int values = ranks.length - 1;
		for (int i = 0; i < 1000000; ++i) {
			// Index in the interval [1, ranks.length)
			int a = (int)(Math.random() * values) + 1;
			// Index in the interval [a, ranks.length)
			int b = (int)(Math.random() * (values - a)) + a;
			// We require higher ranks to beat lower ones
			assertFalse(ranks[a].beats(ranks[b], false));
		}
	}
}
