package monroe.games.monopoly.model;

import java.util.ArrayList;

public class Board {
	ArrayList<Player> players;
	Banker banker;
	ArrayList<MonopolyListener> listeners;
	Player currentTurn;
//	ArrayList<String> communityChest;
//	ArrayList<String> chance;
	public Board(ArrayList<String> playerNames) {
		players = new ArrayList<>();
		for (String s:playerNames) {
			int startingMoney = 1500;
			int getOutOfJail = 0;
			int startPosition = 0;
			players.add(new Player(s, startingMoney, getOutOfJail, startPosition));
		}
		
		int startingHouses = 32;
		int startingHotels = 12;
		banker = new Banker(null, 32, 12); //TODO: build property list
	}
	public Board(ArrayList<Player> players, Banker banker) {
		super();
		this.players = players;
		this.banker = banker;
		this.listeners = new ArrayList<>();
		this.currentTurn = players.get(0);
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
	
	
	public boolean playersStillAlive() {
		if (players.size() > 1) {
			return true;
		}
		return false;
	}
		
	public void move(Player p) {
		int d1 = (int)(Math.random() * 6) + 1;
		int d2 = (int)(Math.random() * 6) + 1;
		
		p.setPosition(p.getPosition() + d1 + d2);
	}
	
	public void addListener(MonopolyListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(MonopolyListener listener) {
		listeners.remove(listener);
	}
	
	public Player whosTurn() {
		return currentTurn;
	}
	
	public boolean onUnownedProperty(Player p) {
		//TODO
		return true;
	}
	
	public Property propertyThatPlayerIsOn(Player p) {
		//TODO
		return null;
	}
	
	public void playerBuysProperty(Player p, Property prop) {
		p.setMoney(p.getMoney() - prop.getCost());
		//TODO make sure player has enough money
	
		p.getProperties().add(prop);
		
		this.banker.getProperties().remove(prop);
	}

}

