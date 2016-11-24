package br.com.sistemadevendas.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.sistemadevendas.models.Hotel;
import br.com.sistemadevendas.models.Pagamento;
import br.com.sistemadevendas.models.Pagamento.Forma;

public class PagamentoMariadb implements PagamentoDAO {

	@Override
	public Pagamento getPagamento(int id) {
		final String query = "SELECT * FROM pagamentos WHERE id = ?";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			result = statement.executeQuery();
			result.first();
			return pagamentoFromResult(result);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				result.close();
			} catch (SQLException e) {}
			try {
				statement.close();
			} catch (SQLException e) {}
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public List<Pagamento> getPagamentos() {
		final String query = "SELECT * FROM pagamentos";
		ArrayList<Pagamento> list = new ArrayList<>();
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
			while (result.next())
				list.add(pagamentoFromResult(result));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query failed");
			throw new RuntimeException(e);
		} finally {
			try {
				result.close();
			} catch (SQLException e) {}
			try {
				statement.close();
			} catch (SQLException e) {}
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}

	@Override
	public void adicionarPagamento(Pagamento pagamento) {
		final String query = "INSERT INTO `pagamentos` VALUES (?, ?, ?, ?)";
		Connection conn = BDConnector.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(query);
			statement.setDate(1, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			statement.setInt(2, pagamento.getRoteiro());
			statement.setString(3, pagamento.getForma().name());
			statement.setString(4, pagamento.getCodigo());
			statement.executeUpdate();
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

	private Pagamento pagamentoFromResult(ResultSet result) {
		try {
			Pagamento.Forma forma;
			switch (result.getString(3)) {
			case "cartao":
				forma = Forma.CARTAO;
				break;
				
			case "cheque":
				forma = Forma.CHEQUE;
				break;
				
			default:
				forma = Forma.DINHEIRO;
				break;
			}
			return new Pagamento(forma, new Date(result.getDate(1).getTime()), result.getInt(2), result.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
