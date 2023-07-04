package feladat2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class MainSwingIngatlan {

	List<Ingatlan> ingatlanok = new ArrayList<Ingatlan>();
	static Map<String, Integer> modifiedHousesMap = new HashMap<String, Integer>();

	String[] oszlopnevek = { "Tulajdonos", "HRSZ", "Alapterület", "Ár" };

	private JFrame frmIngatlanAdatbzis;
	private JTable tableIngatlan;
	private DefaultTableModel tablaModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSwingIngatlan window = new MainSwingIngatlan();
					window.frmIngatlanAdatbzis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainSwingIngatlan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		DBHandler.getAll(ingatlanok);

		frmIngatlanAdatbzis = new JFrame();
		frmIngatlanAdatbzis.setTitle("Ingatlan Adatbázis");
		frmIngatlanAdatbzis.setBounds(100, 100, 600, 400);
		frmIngatlanAdatbzis.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmIngatlanAdatbzis.getContentPane().setLayout(null);
		frmIngatlanAdatbzis.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				String[] valaszok = { "Igen", "Nem" };

				if (JOptionPane.showOptionDialog(frmIngatlanAdatbzis, "Biztos ki akar lépni?", "Kilépés",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
						e) == (JOptionPane.YES_OPTION)) {
					if (JOptionPane.showOptionDialog(null, "Készüljön napi kimutatás?", "Kimutatás",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, valaszok,
							valaszok[1]) == JOptionPane.YES_OPTION) {

						FileHandler.reportInJSON(modifiedHousesMap);
					}

					System.exit(0);
				}
			}
		});

		JButton btn1listazas = new JButton("Listázás");
		btn1listazas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listazas();
			}

		});
		btn1listazas.setBounds(26, 76, 128, 28);
		frmIngatlanAdatbzis.getContentPane().add(btn1listazas);

		JButton btn2kereses = new JButton("Keresés");
		btn2kereses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				kereses();

			}

		});
		btn2kereses.setBounds(26, 123, 128, 28);
		frmIngatlanAdatbzis.getContentPane().add(btn2kereses);

		JButton btn3torles = new JButton("Törlés");
		btn3torles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				torles();

			}

		});
		btn3torles.setBounds(26, 170, 128, 28);
		frmIngatlanAdatbzis.getContentPane().add(btn3torles);

		JButton btn4modositas = new JButton("Módosítás");
		btn4modositas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modositas();
			}
		});
		btn4modositas.setBounds(26, 219, 128, 28);
		frmIngatlanAdatbzis.getContentPane().add(btn4modositas);

		JButton btn5kilepes = new JButton("Kilépés");
		btn5kilepes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIngatlanAdatbzis.dispatchEvent(new WindowEvent(frmIngatlanAdatbzis, WindowEvent.WINDOW_CLOSING));

			}
		});
		btn5kilepes.setBounds(26, 269, 128, 28);
		frmIngatlanAdatbzis.getContentPane().add(btn5kilepes);

		tablaModel = new DefaultTableModel(null, oszlopnevek);

		JLabel lblNewLabel = new JLabel("Válasszon az alábbi funkiókból az adatbázis használatához!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(30, 11, 520, 28);
		frmIngatlanAdatbzis.getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(194, 76, 356, 221);
		frmIngatlanAdatbzis.getContentPane().add(scrollPane);

		tableIngatlan = new JTable();
		scrollPane.setViewportView(tableIngatlan);
	}

	private void listazas() {

		tablaModel.setRowCount(0);
		for (Ingatlan ingatlan : ingatlanok) {

			Object[] adatok = new Object[] { ingatlan.getTulajdonos(), ingatlan.getHelyrajziSzam(),
					ingatlan.getAlapterulet(), ingatlan.getBecsultErtek() };
			tablaModel.insertRow(tableIngatlan.getRowCount(), adatok);
		}

		tableIngatlan.setModel(tablaModel);

	}

	private void kereses() {

		int ingatlanIndex = SwingMethods.searchIndexByParcelNumber(ingatlanok);
		Ingatlan ingatlan;
		if (ingatlanIndex > -1) {
			ingatlan = ingatlanok.get(ingatlanIndex);
			JOptionPane.showMessageDialog(frmIngatlanAdatbzis, ingatlan.toString());
		} else {
			JOptionPane.showMessageDialog(frmIngatlanAdatbzis, "Nincs ilyen ingatlan.");
		}

	}

	private void torles() {

		int ingatlanIndex = SwingMethods.searchIndexByParcelNumber(ingatlanok);
		Ingatlan ingatlan;
		if (ingatlanIndex > -1) {

			ingatlan = ingatlanok.get(ingatlanIndex);
			JOptionPane.showMessageDialog(frmIngatlanAdatbzis, "Törölve: " + ingatlan.toString());

			DBHandler.removeByParcelNumber(ingatlan.getHelyrajziSzam());
			ingatlanok.remove(ingatlanIndex);
			listazas();

		} else {
			JOptionPane.showMessageDialog(frmIngatlanAdatbzis, "Nincs ilyen ingatlan.");
		}

	}

	private void modositas() {

		int ingatlanIndex = SwingMethods.searchIndexByParcelNumber(ingatlanok);
		Ingatlan ingatlan;
		if (ingatlanIndex > -1) {

			ingatlan = ingatlanok.get(ingatlanIndex);
			int newPriceOfHouse = Integer.parseInt(JOptionPane
					.showInputDialog("Kérem a/z " + ingatlan.getHelyrajziSzam() + " HRSZ-ú ingatlan új értékét:"));

			ingatlanok.get(ingatlanIndex).setBecsultErtek(newPriceOfHouse);
			modifiedHousesMap.put(ingatlanok.get(ingatlanIndex).getHelyrajziSzam(), newPriceOfHouse);
			DBHandler.modifyPriceByParcelNumber(ingatlanok.get(ingatlanIndex).getHelyrajziSzam(), newPriceOfHouse);

			JOptionPane.showMessageDialog(frmIngatlanAdatbzis, "Módosítva: " + ingatlan.toString());
			listazas();

		} else {
			JOptionPane.showMessageDialog(frmIngatlanAdatbzis, "Nincs ilyen ingatlan.");
		}

	}

}
