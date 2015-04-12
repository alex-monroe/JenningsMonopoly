package monroe.games.monopoly.controller;

import java.util.ArrayList;

import monroe.games.monopoly.model.Board;
import monroe.games.monopoly.model.Player;
import monroe.games.monopoly.view.ASCIIView;

public class Driver {
	public static void main(String[] args) {
		ArrayList<String> players = new ArrayList<>();
		players.add("Alex");
		players.add("Julia");
		String initFile = "simple.ini";
		Controller game = new Controller(new Board(players, initFile), new ASCIIView());
		game.gameLoop();
	}
}
