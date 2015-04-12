package monroe.games.monopoly.view;

import java.util.Scanner;

import monroe.games.monopoly.model.Player;
import monroe.games.monopoly.model.Property;

public class ASCIIView implements MonopolyView {
	public boolean askToBuy(Player p, Property prop) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to buy the property?");
		String answer = sc.nextLine();
		sc.close();
		if (answer.contains("y")) {
			return true;
		}
		return false;
	}
}
