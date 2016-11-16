package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemadevendas.bd.TransporteDAO;
import br.com.sistemadevendas.models.Cidade;
import br.com.sistemadevendas.models.Transporte;

public class TransporteMariadb implements TransporteDAO {

	@Override
	public Transporte getTransporte(int id) {
		final String query = "SELECT * FROM transportes WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			result.first();
			return transporteFromResult(result);
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
	public void adicionarTransporte(Transporte transporte) {
		final String query = "INSERT INTO transporte VALUES (?, ?, ?, ?, ?);";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, transporte.getId());
			statement.setString(2, transporte.getTipo());
			statement.setFloat(3, transporte.getPreco());
			statement.setInt(4, transporte.getOrigem().getId());
			statement.setInt(5, transporte.getDestino().getId());
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

	@Override
	public void alterarTransporte(Transporte transporte) {
		final String query = "UPDATE transporte SET tipo=? preco=? origem=? destino=? WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, transporte.getTipo());
			statement.setFloat(2, transporte.getPreco());
			statement.setInt(3, transporte.getOrigem().getId());
			statement.setInt(4, transporte.getDestino().getId());
			statement.setInt(5, transporte.getId());
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

	@Override
	public void deletarTransporte(Transporte transporte) {
		final String query = "DELETE FROM transportes WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, transporte.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failed");
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

	@Override
	public List<Transporte> getTransportes(int origem, int destino) {
		ArrayList<Transporte> list = new ArrayList<>();
		final String query = "SELECT * FROM transportes WHERE origem = ? AND destino = ? ORDER BY preco";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, origem);
			statement.setInt(2, destino);
			result = statement.executeQuery();
			while (result.next())
				list.add(transporteFromResult(result));
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


	private Transporte transporteFromResult(ResultSet res) {
		CidadeMariadb cidademdb = new CidadeMariadb();

		try {
			return new Transporte(res.getInt(1), res.getString(2), res.getFloat(3), cidademdb.getCidade(res.getInt(4)),
					cidademdb.getCidade(res.getInt(5)));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
