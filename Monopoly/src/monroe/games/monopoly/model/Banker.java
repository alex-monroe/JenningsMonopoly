package monroe.games.monopoly.model;

import java.util.ArrayList;

public class Banker {
	private ArrayList<Property> properties;
	private int houses;
	private int hotels;
	public Banker(ArrayList<Property> properties, int houses, int hotels) {
		super();
		this.properties = properties;
		this.houses = houses;
		this.hotels = hotels;
	}
	public ArrayList<Property> getProperties() {
		return properties;
	}
	public void setProperties(ArrayList<Property> properties) {
		this.properties = properties;
	}
	public int getHouses() {
		return houses;
	}
	public void setHouses(int houses) {
		this.houses = houses;
	}
	public int getHotels() {
		return hotels;
	}
	public void setHotels(int hotels) {
		this.hotels = hotels;
	}
	
	public boolean hasProperty(Space s) {
		for (Property p:this.properties) {
			if (p.equals(s)) {
				return true;
			}
		}
		return false;
	}
}
