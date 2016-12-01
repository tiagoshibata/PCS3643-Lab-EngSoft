package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemadevendas.bd.ClienteDAO;
import br.com.sistemadevendas.models.Cliente;

public class ClienteMariadb implements ClienteDAO {
	@Override
	public Cliente getCliente(String cpf) {
		final String query = "SELECT * FROM clientes WHERE cpf = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, cpf);
			result = statement.executeQuery();
			result.first();
			return clienteFromResult(result);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			return null;  // no such client
		} finally {
			try {
				if (result != null)
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
	public List<Cliente> getClientes() {
		ArrayList<Cliente> list = new ArrayList<>();
		final String query = "SELECT * FROM clientes";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next())
				list.add(clienteFromResult(result));
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
	public void adicionarCliente(Cliente cliente) {
		final String query = "INSERT INTO clientes VALUES (?, ?);";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
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
	public void alterarCliente(Cliente cliente) {
		final String query = "UPDATE clientes SET nome=? WHERE cpf = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getCpf());
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
	public void deletarCliente(Cliente cliente) {
		final String query = "DELETE FROM clientes WHERE cpf = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, cliente.getCpf());
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

	private Cliente clienteFromResult(ResultSet res) {
		try {
			return new Cliente(res.getString(2), res.getString(1));
		} catch (SQLException e) {
			return null;  // invalid client
		}
	}
}
