package feladat2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FileHandler {
	public static void reportInJSON(List<Ingatlan> list) {
		try {
			FileWriter fw = new FileWriter("reportInJson.json");
			Gson gsonObj = new GsonBuilder().setPrettyPrinting().create();
			gsonObj.toJson(list, fw);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "I/O hiba: " + e.getMessage());
		}
	}
}
