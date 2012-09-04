package org.games.cards.shiva;

import java.awt.GridLayout;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.games.cards.poker.*;

public class ShivaGame extends JFrame implements ShivaConstants {
	private static final long serialVersionUID = 960576453582710700L;
	private PokerDeck deck;
	private JPanel board, field, scoreboard;
	private SortedMap<ShivaPlayer, ListModel> players;

	public ShivaGame() {
		deck = new PokerDeck();
		deck.shuffle();
		field = new JPanel(new GridLayout(1, 1, MARGIN, MARGIN));
		board = new JPanel(new GridLayout(1, PLAYERS, MARGIN, MARGIN));
		scoreboard = new JPanel(new GridLayout(PLAYERS + 1, 2, MARGIN, MARGIN));
		scoreboard.add(new JLabel("Name"));
		scoreboard.add(new JLabel("Record"));
		players = new TreeMap<ShivaPlayer, ListModel>();
		char name[] = { 'P', '0' };
		for (int i = 0; i < PLAYERS; ++i, ++name[1]) {
			ShivaPlayer p = new ShivaPlayer(new String(name));
			for (int j = 0; j < HAND_SIZE; ++j) {
				p.take(deck.draw());
			}
			players.put(p, p.new ListModel());
			board.add(new JScrollPane(new JList(players.get(p))));
			scoreboard.add(new JLabel(p.getName()));
			scoreboard.add(new JLabel(p.score()));
		}
		// Decorate the panels
		board.setBorder(new TitledBorder("Hands"));
		field.setBorder(new TitledBorder("Field"));
		scoreboard.setBorder(new TitledBorder("Scoreboard"));
		getContentPane().add(scoreboard);
		// Setup the presentation
		setIconImage(new ImageIcon(IMAGE_PATH.getAbsolutePath() + "/favicon.gif").getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Shiva v0.1");
		pack();
	}
	
	public static void main(String... args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ShivaGame().setVisible(true);
			}
		});
	}
}
