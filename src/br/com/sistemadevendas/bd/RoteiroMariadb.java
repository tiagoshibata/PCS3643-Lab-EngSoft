package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.sistemadevendas.bd.RoteiroDAO;
import br.com.sistemadevendas.models.RoteiroDeViagem;

public class RoteiroMariadb implements RoteiroDAO {

	@Override
	public RoteiroDeViagem getRoteiro(int id) {
		final String query = "SELECT * FROM roteiros WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			result.first();
			return roteiroFromResult(result);
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
	public int adicionarRoteiro(String cpf, int numeroDePessoas) {
		final String query = "INSERT INTO roteiros VALUES (NULL, ?, ?);";
		final String queryID = "SELECT LAST_INSERT_ID();";
		int idRoteiro = -1;
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;

		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, cpf);
			statement.setInt(2, numeroDePessoas);
			statement.execute();
			try {
				statement.close();
			} catch (SQLException e) {
			}
			statement = conn.prepareStatement(queryID);
			result = statement.executeQuery();
			result.first();
			idRoteiro = result.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
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
		return idRoteiro;
	}

	private RoteiroDeViagem roteiroFromResult(ResultSet res) {
		ClienteMariadb clientemdb = new ClienteMariadb();
		ParadaMariadb paradamdb = new ParadaMariadb();
		try {
			return new RoteiroDeViagem(clientemdb.getCliente(res.getString(2)), res.getInt(1), res.getInt(3),
					paradamdb.getParadas(res.getInt(1)));
		} catch (

		SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
