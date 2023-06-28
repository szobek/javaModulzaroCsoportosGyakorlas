package feladat2;

import java.util.Map;
import java.util.Scanner;

public class SearchData {
	public static String searchByParcelNumber(Scanner sc,Map<String, Ingatlan> ingatlanok) {
		String parcelNum;
		System.out.println("Adja meg a helyrajzi számot:");
		parcelNum = sc.nextLine();
		if(ingatlanok.get(parcelNum)!=null) {
			return parcelNum;
		}else {
			System.out.println("Nincs ilyen ingatlan \n\n");
			return null;
		}
		
		

	}
}
