package monroe.games.monopoly.model;

import java.util.ArrayList;

public class Player {
	private ArrayList<Property> properties;
	private int money;
	private int getOutOfJailFreeCards;
	public Player(ArrayList<Property> properties, int money,
			int getOutOfJailFreeCards) {
		super();
		this.properties = properties;
		this.money = money;
		this.getOutOfJailFreeCards = getOutOfJailFreeCards;
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
