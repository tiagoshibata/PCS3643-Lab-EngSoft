package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnector {
	private static final String ADDRESS = "jdbc:mariadb://143.107.102.14:3306/mdb008" +
			"?user=t1g8&password=Z#dd9Q";
	
	public static Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("MariaDB driver not found");
			throw new RuntimeException(e);
		}
		try {
			return DriverManager.getConnection(ADDRESS);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection failed");
			throw new RuntimeException(e);
		}
	}
}
