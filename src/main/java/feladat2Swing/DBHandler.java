package feladat2Swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBHandler {
	private static String dbName = "ingatlan_db";
	private static String dbUser = "root";
	private static String dbPassword = "Ruander2023";
	private static String dbPort = "3306";
	private static String dbUrl = "localhost";

	private static PreparedStatement ps;
	private static String sql;
	
	
	private static Connection connection;
	
	private static void connect() {
		String connectionString = "jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + dbName + "";
		try {
			connection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getAll(List<Ingatlan> ingatlanok) {
		connect();
		sql = "Select * from ingatlanok";
		try {
			 ps =  connection.prepareStatement(sql);
			 	ResultSet rs = ps.executeQuery();
			 	while(rs.next()) {
			 		ingatlanok.add(new Ingatlan(rs.getString("tulajdonos"),rs.getInt("alapterulet"),rs.getInt( "becsult_ertek"),rs.getString("helyrajzi_szam")));
			 	}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void removeByParcelNumber(String helyrajziSzam) {
		connect();
		sql = "DELETE FROM ingatlanok WHERE helyrajzi_szam=?";
		try {
			 ps =  connection.prepareStatement(sql);
				ps.setString(1, helyrajziSzam);
				
				int deletedRowsNumber = ps.executeUpdate();
		//		 System.out.println(deletedRowsNumber+" db sor lett törölve.");		

			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public static void modifyPriceByParcelNumber(String helyrajziSzam, int newPriceOfHouse) {
		// TODO Auto-generated method stub
		connect();
		sql = "UPDATE ingatlanok SET becsult_ertek=? WHERE helyrajzi_szam=?";
		try {


			ps =  connection.prepareStatement(sql);
			ps.setInt(1, newPriceOfHouse);
			ps.setString(2, helyrajziSzam);
				
				int deletedRowsNumber = ps.executeUpdate();
			//	 System.out.println(deletedRowsNumber+" db sor lett módosítva.");		

			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
}
