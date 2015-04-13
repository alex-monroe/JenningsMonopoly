package monroe.games.monopoly.view;

import java.util.Scanner;

import monroe.games.monopoly.model.Player;
import monroe.games.monopoly.model.Property;
import monroe.games.monopoly.model.Space;

public class ASCIIView implements MonopolyView {
	public boolean askToBuy(Player p, Property prop) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to buy the property " + prop.getName() + "?");
		String answer = sc.nextLine();
		sc.close();
		if (answer.contains("y")) {
			return true;
		}
		return false;
	}
	
	public void displayResult(Player p, Space s) {
		System.out.println(p.getName() + " landed on " + s.getName());
	}
}
