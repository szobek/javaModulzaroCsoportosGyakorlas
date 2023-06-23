package feladat1;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import javax.swing.JOptionPane;

public class FileHamdler {

	public static void writeFileWithCahmpions(List<Versenyzo> list) {
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("versenyzo.csv"), "UTF-8")) {
			char delimiter = ';';

			for (int i = 0; i < list.size(); i++) {
				writer.write(list.get(i).getName() + delimiter + list.get(i).getStartNum() + delimiter
						+ list.get(i).getRecord() + "\n");
			}

			JOptionPane.showMessageDialog(null, "Fájlírás kész van", "Fájlírás", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "I/O hiba", JOptionPane.WARNING_MESSAGE);
		}

	}

}
