package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistemadevendas.models.Hotel;

public class HotelDAO {
	public Hotel getHotel(int id) {
		final String query = "SELECT * FROM hoteis WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			return new Hotel(result.getInt(1), result.getString(2), result.getFloat(3), result.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {}
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	
	public int getContagemHoteis() {
		final String query = "SELECT COUNT(*) FROM hoteis";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			return statement.executeQuery().getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {}
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
