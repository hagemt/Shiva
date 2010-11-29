package com.shiva.cards;

import com.cards.Suit;

public enum PokerSuit implements Suit<PokerSuit> {
	SPADES('\u2660'), CLUBS('\u2663'), HEARTS('\u2665'), DIAMONDS('\u2666');
	private char symbol;

	private PokerSuit(char c) {
		symbol = c;
	}

	@Override
	public char getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
