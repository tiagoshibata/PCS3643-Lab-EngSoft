package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemadevendas.models.Hotel;

public class HotelMariadb implements HotelDAO {
	@Override
	public Hotel getHotel(int id) {
		final String query = "SELECT * FROM hoteis WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			result.first();
			return hotelFromResult(result);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				result.close();
			} catch (SQLException e1) {}
			try {
				statement.close();
			} catch (SQLException e) {}
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	
	@Override
	public int getContagemHoteis() {
		final String query = "SELECT COUNT(*) FROM hoteis";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
			result.first();
			return result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				result.close();
			} catch (SQLException e1) {}
			try {
				statement.close();
			} catch (SQLException e) {}
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public List<Hotel> getHoteis() {
		ArrayList<Hotel> list = new ArrayList<>();
		final String query = "SELECT * FROM hoteis";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next())
				list.add(hotelFromResult(result));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				result.close();
			} catch (SQLException e1) {}
			try {
				statement.close();
			} catch (SQLException e) {}
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public void adicionarHotel(Hotel hotel) {
		final String query = "INSERT INTO hoteis VALUES (?, ?, ?, ?);";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, hotel.getId());
			statement.setString(2, hotel.getNome());
			statement.setDouble(3, hotel.getPrecoDiaria());
			statement.setString(4, hotel.getLocalizacao());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed");
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

	@Override
	public void alterarHotel(Hotel hotel) {
		final String query = "UPDATE hoteis SET nome=? diaria=? localizacao=? WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, hotel.getNome());
			statement.setDouble(2, hotel.getPrecoDiaria());
			statement.setString(3, hotel.getLocalizacao());
			statement.setInt(4, hotel.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed");
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

	@Override
	public void deletarHotel(Hotel hotel) {
		final String query = "DELETE FROM hoteis WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, hotel.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failed");
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

	private Hotel hotelFromResult(ResultSet res) {
		try {
			return new Hotel(res.getInt(1), res.getString(2), res.getFloat(3), res.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
