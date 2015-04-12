package monroe.games.monopoly.controller;

import monroe.games.monopoly.model.Board;
import monroe.games.monopoly.model.MonopolyListener;
import monroe.games.monopoly.model.Player;
import monroe.games.monopoly.model.Property;
import monroe.games.monopoly.view.MonopolyView;

public class Controller {
	private Board model;
	private MonopolyView view;
	
	public Controller(Board model, MonopolyView view) {
		this.model = model;
		this.view = view;
		MonopolyListener myListener = new MonopolyListener() {
			public void playerMoved(Player p) {
				if (model.onUnownedProperty(p)) {
					Property inQuestion = model.propertyThatPlayerIsOn(p);
					boolean answer = view.askToBuy(p, inQuestion);
					if (answer) {
						model.playerBuysProperty(p, inQuestion);
					}
				}
			}
		};
		this.model.addListener(myListener);
	}
	
	public void gameLoop() {
		while (model.playersStillAlive()) {
			model.move(model.whosTurn());

		}
	}
	
	
}
