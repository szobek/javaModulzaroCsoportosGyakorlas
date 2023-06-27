package feladat2;

import java.util.HashMap;
import java.util.Map;

public class Main {
	Map<String, Ingatlan> ingatlanok = new HashMap<String, Ingatlan>();

	public static void main(String[] args) {
		new Main().start();
	}

	private void start() {
		fillMap();
		Menu.showMenu();
	}

	private void fillMap() {
		ingatlanok.put("125/2", new Ingatlan("Magyar Endre", 170, 75000000));
		ingatlanok.put("3181/1", new Ingatlan("Kiss Lilla", 110, 45000000));
		ingatlanok.put("11055", new Ingatlan("Tóth Eszter", 80, 32000000));
		ingatlanok.put("110/1", new Ingatlan("Fekete Benedek", 100, 40000000));
		ingatlanok.put("2345", new Ingatlan("Nagy Andre", 135, 50000000));
	}

}
