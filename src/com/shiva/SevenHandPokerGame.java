package com.shiva;

import java.awt.GridLayout;

import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.shiva.cards.PokerCard;
import com.shiva.cards.PokerDeck;
import com.shiva.players.Player;
import com.shiva.players.Score;

public class SevenHandPokerGame extends JFrame implements SevenHandPokerConstants {
	private static final long serialVersionUID = 960576453582710700L;
	private PokerDeck deck;
	private JPanel board, scoreboard, field;
	private Map<Player, Score> scores;
	private Map<Player, DefaultListModel> hands;

	public SevenHandPokerGame() {
		deck = new PokerDeck();
		deck.shuffle();
		scores = new TreeMap<Player, Score>();
		for (int i = 0; i < PLAYERS; ++i) {
			scores.put(new Player(Character.toString((char)('A' + i))), new Score());
		}
		hands = new TreeMap<Player, DefaultListModel>();
		board = new JPanel(new GridLayout(1, PLAYERS, 3, 3));
		field = new JPanel();
		field.setBorder(new TitledBorder("Field"));
		scoreboard = new JPanel(new GridLayout(PLAYERS + 1, 4, 3, 3));
		scoreboard.add(new JLabel(""));
		scoreboard.add(new JLabel("WINS"));
		scoreboard.add(new JLabel("LOSS"));
		scoreboard.add(new JLabel("TIES"));
		for (Player p : scores.keySet()) {
			DefaultListModel m = new DefaultListModel();
			m.addElement(p.getName());
			for (int i = 0; i < 7; ++i) {
				PokerCard c = deck.draw();
				p.take(c); m.addElement(c);
			}
			hands.put(p, m);
			board.add(new JScrollPane(new JList(m)));
			scoreboard.add(new JLabel(p.getName()));
			for (String s : scores.get(p).toString().split("/")) {
				scoreboard.add(new JLabel(s));
			}
		}
		board.setBorder(new TitledBorder("Hands"));
		scoreboard.setBorder(new TitledBorder("Scoreboard"));
		getContentPane().add(board);
		getContentPane().add(scoreboard);
		ImageIcon i = new ImageIcon(IMAGE_PATH.getPath() + "/favicon.gif");
		setIconImage(i.getImage());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Shiva v0.0");
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
				new SevenHandPokerGame().setVisible(true);
			}
		});
	}
}
