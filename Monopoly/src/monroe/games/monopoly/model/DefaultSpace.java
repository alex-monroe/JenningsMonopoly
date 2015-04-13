package monroe.games.monopoly.model;

public class DefaultSpace implements Space {
	String name;
	public DefaultSpace(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public boolean isBuyable() {
		return false;
	}
}
