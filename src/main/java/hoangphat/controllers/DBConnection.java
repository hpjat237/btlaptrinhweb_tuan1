package hoangphat.controllers;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String DB_URL = "jdbc:mysql://localhost:3306/world";
	private static String USER_NAME = "root";
	private static String PASSWORD = "admin";
	private static Connection con;
	
	public static Connection getConnection() throws IOException {
		con = null;
		try {
			// driver register
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = (Connection) DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (SQLException ex) {
			Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		return (con);
	}
	
	public static void main(String[] args) {
		try {
			Connection c = getConnection();
			if (c== null) {
				System.out.println("something wrong");
			} else {
				System.out.println("ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
