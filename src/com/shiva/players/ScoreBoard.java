package com.shiva.players;

import java.util.List;

public class ScoreBoard {
	private List<Player> players;
	
	public boolean addPlayer(Player p) {
		return players.add(p);
	}
}
