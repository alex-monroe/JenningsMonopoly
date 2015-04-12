package monroe.games.monopoly.model;

public class Property {
	private String name;
	
	private int cost;
	private int baseRent;
	private int mortgageValue;
	private int numHouses;
	private int buildingCost;
	
	private boolean hasHotel;
	private boolean isMortgaged;
	public Property(String name, int cost, int baseRent, int mortgageValue,
			int numHouses, int buildingCost, boolean hasHotel,
			boolean isMortgaged) {
		super();
		this.name = name;
		this.cost = cost;
		this.baseRent = baseRent;
		this.mortgageValue = mortgageValue;
		this.numHouses = numHouses;
		this.buildingCost = buildingCost;
		this.hasHotel = hasHotel;
		this.isMortgaged = isMortgaged;
	}
	public String getName() {
		return name;
	}
	public int getCost() {
		return cost;
	}
	public int getBaseRent() {
		return baseRent;
	}
	public int getMortgageValue() {
		return mortgageValue;
	}
	public int getNumHouses() {
		return numHouses;
	}
	public void setNumHouses(int numHouses) {
		this.numHouses = numHouses;
	}
	public int getBuildingCost() {
		return buildingCost;
	}
	public boolean hasHotel() {
		return hasHotel;
	}
	public void setHasHotel(boolean hasHotel) {
		this.hasHotel = hasHotel;
	}
	public boolean isMortgaged() {
		return isMortgaged;
	}
	public void setMortgaged(boolean isMortgaged) {
		this.isMortgaged = isMortgaged;
	}
	
}
