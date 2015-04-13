package monroe.games.monopoly.controller;

import monroe.games.monopoly.model.Board;
import monroe.games.monopoly.model.MonopolyListener;
import monroe.games.monopoly.model.Player;
import monroe.games.monopoly.model.Property;
import monroe.games.monopoly.view.MonopolyView;

public class Controller {
	private Board model;
	private MonopolyView view;
	
	public Controller(Board modelParam, MonopolyView view) {
		this.model = modelParam;
		this.view = view;
		MonopolyListener myListener = new MonopolyListener() {
			public void playerMoved(Player p) {
				view.displayResult(p, model.spacePlayerIsOn(p));
				if (model.onUnownedProperty(p) && model.spacePlayerIsOn(p) instanceof Property) {
					Property inQuestion = (Property) model.spacePlayerIsOn(p);
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
//		while (model.playersStillAlive()) {
		for (int i = 0; i < 5; i++) {
			model.move(model.whosTurn());

		}
	}
	
	
}
