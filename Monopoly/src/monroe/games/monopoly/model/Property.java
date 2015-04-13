package monroe.games.monopoly.model;

public class Property implements Space{
	private String name;
	
	private int cost;
	private int baseRent;
	private int rent1; //rent with 1 house
	private int rent2;
	private int rent3;
	private int rent4;
	private int rentHotel; //rent with a hotel
	private int mortgageValue;
	private int numHouses;
	private int buildingCost;
	
	private boolean hasHotel;
	private boolean isMortgaged;
	public Property(String name, int cost, int baseRent, int rent1, int rent2, int rent3, int rent4, int rentHotel, int mortgageValue,
			int numHouses, int buildingCost, boolean hasHotel,
			boolean isMortgaged) {
		super();
		this.name = name;
		this.cost = cost;
		this.baseRent = baseRent;
		this.rent1 = rent1;
		this.rent2 = rent2;
		this.rent3 = rent3;
		this.rent4 = rent4;
		this.rentHotel = rentHotel;
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
	@Override
	public boolean isBuyable() {
		return true;
	}
	
}
