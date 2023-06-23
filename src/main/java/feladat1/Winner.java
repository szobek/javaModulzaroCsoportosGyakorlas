package feladat1;

import java.util.List;

public class Winner {
	public static void selectWinner(List<Versenyzo> champions) {
		int winnerIndex = 0;
		for(int i=1;i<champions.size();i++) {
			if(champions.get(winnerIndex).countAllPoints()<champions.get(i).countAllPoints()) {
				winnerIndex=i;
			}
		}
		System.out.println("\nA gyõztes: " + champions.get(winnerIndex).getName() +
				" "+champions.get(winnerIndex).countAllPoints() +" ponttal");
		

	}

}
