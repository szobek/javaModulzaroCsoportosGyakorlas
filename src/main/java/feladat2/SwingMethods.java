package feladat2;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SwingMethods {
	
	public static int searchIndexByParcelNumber(List<Ingatlan> ingatlanok) {
		int ingatlanIndex = -1;
		
		String parcelNum = JOptionPane.showInputDialog("Kérem a keresett HRSZ-ot:");
		
		//System.out.println("Adja meg a helyrajzi számot:");
		//parcelNum = sc.nextLine();
		
		for(int i=0;i<ingatlanok.size();i++) {
			if(ingatlanok.get(i).getHelyrajziSzam().equalsIgnoreCase(parcelNum)) {
				ingatlanIndex=i;
			}
		}
		
		return ingatlanIndex; 

	}
}
