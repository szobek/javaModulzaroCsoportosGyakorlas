package feladat2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHandler {
	private static String dbName = "ingatlan_db";
	private static String dbUser = "root";
	private static String dbPassword = "";
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
	public static void getAll() {
		connect();
		sql = "Select * from ingatlanok";
		try {
			 ps =  connection.prepareStatement(sql);
			 	ResultSet rs = ps.executeQuery();
			 	
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
