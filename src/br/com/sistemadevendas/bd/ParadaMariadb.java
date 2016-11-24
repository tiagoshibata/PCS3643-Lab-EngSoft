package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemadevendas.bd.ParadaDAO;
import br.com.sistemadevendas.models.Parada;

public class ParadaMariadb implements ParadaDAO {

	@Override
	public Parada getParada(int id) {
		final String query = "SELECT * FROM paradas WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			result.first();
			return paradaFromResult(result);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				result.close();
			} catch (SQLException e1) {
			}
			try {
				statement.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public List<Parada> getParadas(int idRoteiro) {
		ArrayList<Parada> list = new ArrayList<>();
		final String query = "SELECT * FROM paradas WHERE roteiro = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, idRoteiro);
			result = statement.executeQuery();
			while (result.next())
				list.add(paradaFromResult(result));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				result.close();
			} catch (SQLException e1) {
			}
			try {
				statement.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void adicionarParada(Parada parada, int idRoteiro) {
		final String query = "INSERT INTO paradas VALUES (?, ?, ?, ?);";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, idRoteiro);
			statement.setInt(2, parada.getHotel().getId());
			statement.setInt(3, parada.getTransporte().getId());
			statement.setInt(4, parada.getDuracao());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed");
			throw new RuntimeException(e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
			}
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	private Parada paradaFromResult(ResultSet res) {
		HotelMariadb hotelmdb = new HotelMariadb();
		TransporteMariadb transportemdb = new TransporteMariadb();
		try {
			return new Parada(hotelmdb.getHotel(res.getInt(3)), transportemdb.getTransporte(res.getInt(4)),
					res.getInt(5));
		} catch (

		SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
