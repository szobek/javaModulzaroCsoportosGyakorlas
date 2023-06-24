package feladat1;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Versenyzo> champions = new ArrayList<Versenyzo>();
		champions.add(new Versenyzo("Franciska", "v0001", 467));
		champions.add(new Versenyzo("Tibor", "v0002", 486));
		champions.add(new Versenyzo("Zsolt", "v0003", 478));
		champions.add(new Versenyzo("Erika", "v0004", 491));
		champions.add(new Versenyzo("Lajos", "v0005", 472));
Winner.selectWinnerByStreamAPI(champions);		
	}

}
