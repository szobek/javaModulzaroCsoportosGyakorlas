package feladat2;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearchData {
	public static int searchByParcelNumber(Scanner sc,List<Ingatlan> ingatlanok) {
		int ingatlanIndex = -1;
		String parcelNum;
		System.out.println("Adja meg a helyrajzi számot:");
		parcelNum = sc.nextLine();
		
		for(int i=0;i<ingatlanok.size();i++) {
			if(ingatlanok.get(i).getHelyrajziSzam().equalsIgnoreCase(parcelNum)) {
				ingatlanIndex=i;
			}
		}
		
		return ingatlanIndex; 
		/*
		if(ingatlanok.get(parcelNum)!=null) {
			return parcelNum;
		}else {
			System.out.println("Nincs ilyen ingatlan \n\n");
			return null;
		}
		*/
		

	}
}
