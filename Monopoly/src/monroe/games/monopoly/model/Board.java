package monroe.games.monopoly.model;

import java.util.ArrayList;

public class Board {
	ArrayList<Player> players;
	Banker banker;
//	ArrayList<String> communityChest;
//	ArrayList<String> chance;
	public Board(ArrayList<Player> players, Banker banker) {
		super();
		this.players = players;
		this.banker = banker;
	}
	public ArrayList<Player> getPlayers() {
		return players;
	}
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	public Banker getBanker() {
		return banker;
	}
	public void setBanker(Banker banker) {
		this.banker = banker;
	}
	
	private void init() {}
	
	public void gameLoop() {
		while (playersStillAlive()) {
			for(Player p:players) {
				takeTurn(p);
			}
		}
	}
	
	private boolean playersStillAlive() {
		if (players.size() > 1) {
			return true;
		}
		return false;
	}
	
	private void takeTurn(Player p) {
		
	}
}
