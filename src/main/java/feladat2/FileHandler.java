package feladat2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileHandler {
	public static void reportInJSON(Map<String, Integer> modifiedHousesMap) {
		try {
			FileWriter fw = new FileWriter("reportInJson.json");
			Gson gsonObj = new GsonBuilder().setPrettyPrinting().create();
			gsonObj.toJson(modifiedHousesMap, fw);
			fw.close();

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "I/O hiba: " + e.getMessage());
		}
	}
}
