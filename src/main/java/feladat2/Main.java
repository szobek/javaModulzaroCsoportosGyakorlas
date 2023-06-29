package feladat2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	List<Ingatlan> ingatlanok = new ArrayList<Ingatlan>();

	public static void main(String[] args) {
		new Main().start();
	}

	private void start() {
		DBHandler.getAll(ingatlanok);
		Menu.showMenu(ingatlanok);
	}

}
