package monroe.games.monopoly.view;

import monroe.games.monopoly.model.Player;
import monroe.games.monopoly.model.Property;
import monroe.games.monopoly.model.Space;

public interface MonopolyView {
	public boolean askToBuy(Player p, Property prop);
	public void displayResult(Player p, Space s);
}
