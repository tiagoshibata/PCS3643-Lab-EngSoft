package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemadevendas.bd.CidadeDAO;
import br.com.sistemadevendas.models.Cidade;
import br.com.sistemadevendas.models.Hotel;

public class CidadeMariadb implements CidadeDAO {
	
	@Override
	   public Cidade getCidade(int id){
		final String query = "SELECT * FROM cidades WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			result.first();
			return cidadeFromResult(result);
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
	public List<Cidade> getCidades() {
		ArrayList<Cidade> list = new ArrayList<>();
		final String query = "SELECT * FROM cidades";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next())
				list.add(cidadeFromResult(result));
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
	   public void adicionarCidade(Cidade cidade){
		final String query = "INSERT INTO cidades VALUES (?, ?);";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, cidade.getId());
			statement.setString(2, cidade.getNome());
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
	   public void alterarCidade(Cidade cidade){
		final String query = "UPDATE cidades SET nome=? WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, cidade.getNome());
			statement.setInt(2, cidade.getId());
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
	   public void deletarCidade(Cidade cidade){
		final String query = "DELETE FROM cidades WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, cidade.getId());
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

	private Cidade cidadeFromResult(ResultSet res) {
		try {
			ArrayList<Hotel> listHotel = new ArrayList<>();
			final String query = "SELECT * FROM hoteis WHERE cidade = ?";
			Connection conn = BDConnector.getConnection();
			PreparedStatement statement = null;
			ResultSet result = null;
			try {
				statement = conn.prepareStatement(query);
				statement.setInt(1, res.getInt("id"));
				result = statement.executeQuery();
				while (result.next())
					listHotel.add(hotelFromResult(result));
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Query failed");
				throw new RuntimeException(e);
			} finally {
				try {
					if (result != null)
						result.close();
				} catch (SQLException e1) {}
				try {
					statement.close();
				} catch (SQLException e) {}
				try {
					conn.close();
				} catch (SQLException e) {}
			}
			return new Cidade(res.getInt(1), res.getString(2), listHotel.toArray(new Hotel[0]));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private Hotel hotelFromResult(ResultSet res) {
		try {
			int cidadeId = res.getInt(4);
			return new Hotel(res.getInt(1), res.getString(2), res.getFloat(3), cidadeId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
