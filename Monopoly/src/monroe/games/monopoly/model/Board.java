package monroe.games.monopoly.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {
	private ArrayList<Player> players;
	private Banker banker;
	private ArrayList<MonopolyListener> listeners;
	private int currentTurn;
	private ArrayList<Space> board;
	
	public static final int STANDARD_NUM_SPACES = 40;
//	ArrayList<String> communityChest;
//	ArrayList<String> chance;
	public Board(ArrayList<String> playerNames, String initFile) {
		players = new ArrayList<>();
		board = new ArrayList<>();
		listeners = new ArrayList<>();
		for (String s:playerNames) {
			int startingMoney = 1500;
			int getOutOfJail = 0;
			int startPosition = 0;
			players.add(new Player(s, startingMoney, getOutOfJail, startPosition));
		}
		currentTurn = 0;
		int startingHouses = 32;
		int startingHotels = 12;
		this.initFromFile(initFile);
		banker = new Banker(this.getProperties(), startingHouses, startingHotels); //TODO: build property list
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
		
		p.setPosition((p.getPosition() + d1 + d2) % board.size());
		for(MonopolyListener l:this.listeners) {
			l.playerMoved(p);
		}
	}
	
	public void addListener(MonopolyListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(MonopolyListener listener) {
		listeners.remove(listener);
	}
	
	public Player whosTurn() {
		if (this.currentTurn >= players.size()) {
			this.currentTurn = players.size() - 1;
		}
		Player p = players.get(this.currentTurn++);
		if (this.currentTurn >= players.size()) {
			this.currentTurn = 0;
		}
		return p;
	}
	
	public boolean onUnownedProperty(Player p) {
		Space s = this.spacePlayerIsOn(p);
		if (s.isBuyable() && banker.hasProperty(s)) {
			return true;
		}
		return false;
	}
	
	public void playerBuysProperty(Player p, Property prop) {
		p.setMoney(p.getMoney() - prop.getCost());
		//TODO make sure player has enough money
	
		p.getProperties().add(prop);
		
		this.banker.getProperties().remove(prop);
	}
	
	private void initFromFile(String filename) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Cannot initialize board: init file not found");
			System.err.println(e);
		}
		
		int numSpaces = 0;
		int numHouses = 0;
		boolean hasHotel = false;
		boolean isMortgaged = false;
		while (numSpaces < STANDARD_NUM_SPACES && sc.hasNextLine()) {
			try {
				String name = this.initNextLine(sc);
				if (!name.equalsIgnoreCase("Property")) {
					this.board.add(new DefaultSpace(name));
				} else {
					name = sc.nextLine();
					int cost = Integer.parseInt(this.initNextLine(sc));
					int baseRent = Integer.parseInt(this.initNextLine(sc));
					int rent1 = Integer.parseInt(this.initNextLine(sc));
					int rent2 = Integer.parseInt(this.initNextLine(sc));
					int rent3 = Integer.parseInt(this.initNextLine(sc));
					int rent4 = Integer.parseInt(this.initNextLine(sc));
					int rentHotel = Integer.parseInt(this.initNextLine(sc));
					int mortgageValue = Integer.parseInt(this.initNextLine(sc));
					int buildingCost = Integer.parseInt(this.initNextLine(sc));
					Property p = new Property(name, cost, baseRent, rent1, rent2, rent3, rent4, rentHotel, mortgageValue, numHouses, buildingCost, hasHotel, isMortgaged);
					this.board.add(p);
				}
			} catch (IOException e) {
				System.err.println(e);
				sc.close();
			} 
			numSpaces++;
		}
		sc.close();
		if (numSpaces != STANDARD_NUM_SPACES) {
			System.err.println("Board initilization failed: Wrong number of spaces");
			System.exit(1);
		}
	}
	
	private String initNextLine(Scanner sc) throws IOException{
		if (!sc.hasNextLine()) {
			throw new IOException("Board init file not formatted properly");
		}
		String nextLine = sc.nextLine();
		if ((nextLine.length() > 0 && nextLine.charAt(0) == '#') || nextLine.length() == 0) {
			return initNextLine(sc);
		}
		return nextLine;
	}
	
	private ArrayList<Property> getProperties() {
		ArrayList<Property> properties = new ArrayList<>();
		for (Space s:this.board) {
			if (s.isBuyable() && s instanceof Property) {
				properties.add((Property) s);
			}
		}
		return properties;
	}
	
	public Space spacePlayerIsOn(Player p) {
		return board.get(p.getPosition());
	}
}

