package feladat2;

import java.util.Scanner;

public class SearchData {
	public static String searchByParcelNumber(Scanner sc) {
		String parcelNum;
		System.out.println("Adja meg a helyrajzi számot:");
		parcelNum = sc.nextLine();
		return parcelNum;

	}
}
