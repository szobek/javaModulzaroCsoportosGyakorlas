package feladat1;

import java.util.Comparator;
import java.util.List;
import java.util.random.RandomGenerator;

public class Winner {
	public static void selectWinner(List<Versenyzo> champions) {
		int winnerIndex = 0;
		for (int i = 1; i < champions.size(); i++) {
			if (champions.get(winnerIndex).countAllPoints() < champions.get(i).countAllPoints()) {
				winnerIndex = i;
			}
		}
		System.out.println("\nA gyõztes: " + champions.get(winnerIndex).getName() + " "
				+ champions.get(winnerIndex).countAllPoints() + " ponttal");

	}

	public static void selectWinnerByStreamAPI(List<Versenyzo> champions) throws InterruptedException {
		RandomGenerator rg = RandomGenerator.getDefault();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				champions.get(j).setLovesek(rg.nextInt(80, 101), i);

			}

			aktualResults(champions, i);
			for (int j = 0; j < 5; j++) {
				if ((i + 1 == 5) && champions.get(j).rekordEllenorzes(i).equals("új egyéni rekord")) { 
					// utolsó kör és rekord, mert korábban beírt rekord hibát okoz

					champions.get(j).setRecord(champions.get(j).countAllPoints());
FileHamdler.writeFileWithCahmpions(champions);
				}
			}
		}
		Versenyzo winner = champions.stream().max(Comparator.comparingInt(Versenyzo::countAllPoints)).get();

		System.out.println("\nA győztes nem más mint " + winner.getName() + " " + winner.countAllPoints());

	}

	private static void aktualResults(List<Versenyzo> champions, int numberOfRound) throws InterruptedException {
		System.out.println();
		Thread.sleep(1000);
		System.out.println("    >>  " + (numberOfRound + 1) + ". forduló");

		List<Versenyzo> championsOrdered = champions;
		championsOrdered.sort(Comparator.comparingInt(Versenyzo::countAllPoints).reversed());

		for (int i = 0; i < 5; i++) {

			System.out.println(
					(i + 1) + ". " + championsOrdered.get(i).getName() + " " + championsOrdered.get(i).countAllPoints()
							+ " (" + championsOrdered.get(i).getEgyLoves(numberOfRound) + " pont) "
							+ championsOrdered.get(i).rekordEllenorzes(numberOfRound));
		}
	}

}
