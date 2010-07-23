package com.cards;

public interface Rank<R extends Rank<R>> extends Comparable<R> {
	public String name();
	public char getSymbol();
	public int getValue();
	public boolean isStandard();
	public boolean beats(R r);
}
