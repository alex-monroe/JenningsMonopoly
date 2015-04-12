package monroe.games.monopoly.view;

import monroe.games.monopoly.model.Player;
import monroe.games.monopoly.model.Property;

public interface MonopolyView {
	public boolean askToBuy(Player p, Property prop);
}
