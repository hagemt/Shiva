package org.games.cards.shiva;

import java.util.LinkedHashSet;

import org.games.Score;
import org.games.cards.Player;
import org.games.cards.poker.PokerCard;

public class ShivaPlayer extends Player<PokerCard> {
	public ShivaPlayer(String name) {
		super(name);
		hand = new LinkedHashSet<PokerCard>();
		score = new Record();
	}

	public class ListModel extends javax.swing.DefaultListModel {
		private static final long serialVersionUID = 2928949544854829929L;
		public ListModel() {
			for (PokerCard c : ShivaPlayer.this.hand) {
				super.addElement(c);
			}
		}
	}
	
	public static class Record implements org.games.Score {
		private int wins, losses, ties;

		public Record() {
			wins = losses = ties = 0;
		}

		@Override
		public int compareTo(Score s) {
			/* TODO tweak
			double total_a = wins + losses + ties;
			double total_b = r.wins + r.losses + r.ties;
			double win_a = wins / total_a;
			double win_b = r.wins / total_b;
			double loss_a = losses / total_a;
			double loss_b = r.losses / total_b;
			double tie_a = ties / total_a;
			double tie_b = r.ties / total_b;
			*/
			if (s instanceof Record) {
				return wins - ((Record)(s)).wins;
			}
			return 0;
		}

		@Override
		public String toString() {
			return (wins + "/" + losses + "/" + ties);
		}
	}
}
