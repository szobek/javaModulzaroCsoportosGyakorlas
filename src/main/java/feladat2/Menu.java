package feladat2;

import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	
	static Map<String, Integer> modifiedHousesMap = new HashMap<String, Integer>();

	public static void showMenu(List<Ingatlan> ingatlanok) {
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
				case "1" -> listAllHouses(ingatlanok);
				case "2" -> searchByParcelNumber(ingatlanok,sc);
				case "3" -> deleteByParcelNumber(ingatlanok, sc);
				case "4" -> modifyPriceByParcelNumber(ingatlanok, sc);
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
								// modifiedHousesMap - ben vannak az adatok
						}
					}
				}
				default -> System.out.println("\n nincs ilyen menü! \n");
				}
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void modifyPriceByParcelNumber(List<Ingatlan> ingatlanok,Scanner sc) {

		
		int ingatlanIndex = SearchData.searchByParcelNumber(sc,ingatlanok);
		if(ingatlanIndex>-1) {

			System.out.println("Az ingatlan új értéke: "+ingatlanok.get(ingatlanIndex).getBecsultErtek()+" > ");
			int newPriceOfHouse = Integer.parseInt(sc.nextLine()); 
			
			ingatlanok.get(ingatlanIndex).setBecsultErtek(newPriceOfHouse);
			modifiedHousesMap.put(ingatlanok.get(ingatlanIndex).getHelyrajziSzam(), newPriceOfHouse);
			DBHandler.modifyPriceByParcelNumber(ingatlanok.get(ingatlanIndex).getHelyrajziSzam(), newPriceOfHouse);
			
			System.out.println("\nMódosítva: "+ingatlanok.get(ingatlanIndex).toString()+"\n");

		} else {
			System.out.println("\n Nincs ilyen ingatlan \n");
		}


	}

	private static void deleteByParcelNumber(List<Ingatlan> ingatlanok,Scanner sc) {
		int ingatlanIndex = SearchData.searchByParcelNumber(sc,ingatlanok);
		if(ingatlanIndex>-1) {

			 DBHandler.removeByParcelNumber(ingatlanok.get(ingatlanIndex).getHelyrajziSzam());
			 System.out.println("\nTörölve: "+ingatlanok.get(ingatlanIndex).toString()+"\n");
			 ingatlanok.remove(ingatlanIndex);

		} else {
			System.out.println("\n Nincs ilyen ingatlan \n");
		}

	}

	private static void searchByParcelNumber(List<Ingatlan> ingatlanok,Scanner sc) {
		int ingatlanIndex = SearchData.searchByParcelNumber(sc,ingatlanok);
		Ingatlan ingatlan;
		if(ingatlanIndex>-1) {
			 ingatlan = ingatlanok.get(ingatlanIndex);
			 System.out.println("\n"+ingatlan.toString()+"\n");
		} else {
			System.out.println("\n Nincs ilyen ingatlan \n");
		}
			
		
	}

	private static void listAllHouses(List<Ingatlan> ingatlanok) {
		
		System.out.println("Az összes adatbázisban található ingatlan listázása\n");
		for (Ingatlan ingatlan : ingatlanok) {
			System.out.println(ingatlan);
		}
		System.out.println();
	}

}
