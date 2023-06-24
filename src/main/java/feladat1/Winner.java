package feladat1;

import java.util.Comparator;
import java.util.List;
import java.util.random.RandomGenerator;

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
	
	public static void selectWinnerByStreamAPI(List<Versenyzo> champions) {
		RandomGenerator rg = RandomGenerator.getDefault();
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				champions.get(j).setLovesek(rg.nextInt(1,301), i);		
			}	
		}
		
		Versenyzo winner = champions.stream()
                .max(Comparator.comparingInt(Versenyzo::countAllPoints))
                .get();
System.out.println(winner.getName());
		
		
	}

}
