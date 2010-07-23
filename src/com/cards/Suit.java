package com.cards;

public interface Suit<S extends Suit<S>> extends Comparable<S> {
	public String name();
	public char getSymbol();
}
