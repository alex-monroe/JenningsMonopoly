package monroe.games.monopoly.model;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Property> properties;
	private int money;
	private int getOutOfJailFreeCards;
	private int position;
	private boolean turnOver;
	public Player(String name, int money, int getOutOfJailFreeCards, int position) {
		this.name = name;
		this.money = money;
		this.getOutOfJailFreeCards = getOutOfJailFreeCards;
		this.position = position;
		this.turnOver = true;
	}
	public Player(ArrayList<Property> properties, int money,
			int getOutOfJailFreeCards, int position, boolean turnOver) {
		super();
		this.properties = properties;
		this.money = money;
		this.getOutOfJailFreeCards = getOutOfJailFreeCards;
		this.position = position;
		this.turnOver = turnOver;
	}
	public String getName() {
		return this.name;
	}
	public boolean turnOver() {
		return turnOver;
	}
	public void setTurnOver(boolean turnOver) {
		this.turnOver = turnOver;
	}
	public ArrayList<Property> getProperties() {
		return properties;
	}
	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getGetOutOfJailFreeCards() {
		return getOutOfJailFreeCards;
	}
	public void setGetOutOfJailFreeCards(int getOutOfJailFreeCards) {
		this.getOutOfJailFreeCards = getOutOfJailFreeCards;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public boolean isBankrupt() {
		if (money >= 0) {
			return false;
		}
		if (getOutOfJailFreeCards > 0) {
			return false;
		}
		for (Property p:properties) {
			if (!p.isMortgaged()) {
				return false;
			}
		}
		return true;
	}
}
