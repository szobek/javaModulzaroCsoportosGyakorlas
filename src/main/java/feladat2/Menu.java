package feladat2;

import java.awt.HeadlessException;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	

	public static void showMenu(Map<String, Ingatlan> ingatlanok) {
		try (Scanner sc = new Scanner(System.in)) {
			String menuItem = "";

			while (!menuItem.equals("5")) {

				System.out.println("1. Összes ingatlan listázása");
				System.out.println("2. Keresés helyrajzi szám alapján");
				System.out.println("3. Törlés helyrajzi szám alapján");
				System.out.println("4. Becsült érték módosítása helyrajzi szám alapján");
				System.out.println("5. Kilépés");

				System.out.print("Melyik menüt választja?: ");
				menuItem = sc.nextLine();
				switch (menuItem) {
				case "1" -> listAllHouses();
				case "2" -> searchByParcelNumber(ingatlanok,sc);
				case "3" -> deleteByParcelNumber();
				case "4" -> modifyPriceByParcelNumber();
				case "5" -> {

					String[] valaszok = { "Igen", "Nem" };

					if (JOptionPane.showOptionDialog(null, "Biztos,hogy kilép?", "Kilépés", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, valaszok, valaszok[1]) == JOptionPane.YES_OPTION) {

						if (JOptionPane.showOptionDialog(null, "Készüljön napi kimutatás?", "Kimutatás",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, valaszok,
								valaszok[1]) == JOptionPane.YES_OPTION) {
							// TODO ide kell a napi kimutatás kiírása

							// json napi riport
							// FileHandler.reportInJSON(null); <- null helyett az ingatlan lista

						}
					}
				}
				}
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void modifyPriceByParcelNumber() {
		// TODO Auto-generated method stub
	}

	private static void deleteByParcelNumber() {
		// TODO Auto-generated method stub
	}

	private static void searchByParcelNumber(Map<String, Ingatlan> ingatlanok,Scanner sc) {
		Ingatlan ingatlan = ingatlanok.get(SearchData.searchByParcelNumber(sc));
		if(ingatlan!=null) {
			System.out.println(ingatlan.toString());
		}else {
			System.out.println("Nincs ilyen ingatlan \n\n");
		}
		
	}

	private static void listAllHouses() {

	}

}
