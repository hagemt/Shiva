package com.shiva.cards.testing;

import static org.junit.Assert.*;
import org.junit.Test;
import com.shiva.cards.PokerRank;

public class TestRank {

	@Test
	public void testBeatsPokerRankBoolean() {
		for (PokerRank r : PokerRank.values()) {
			assertFalse(r.beats(r));
			assertFalse(r.beats(PokerRank.JOKER));
			if (r.isStandard() && !r.isAce()) {
				assertTrue(PokerRank.ACE.beats(r));
				assertFalse(PokerRank.ACE.beats(r, false));
			}
		}
		int values = PokerRank.values().length - 1;
		for (int i = 0; i < 1000000; ++i) {
			int a = (int)(Math.random() * values) + 1;
			int b = (int)(Math.random() * (values - a)) + a;
			assertFalse(PokerRank.values()[a].beats(PokerRank.values()[b], false));
		}
	}
}
