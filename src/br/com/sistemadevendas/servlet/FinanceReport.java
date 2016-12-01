package br.com.sistemadevendas.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.PagamentoDAO;
import br.com.sistemadevendas.bd.PagamentoMariadb;
import br.com.sistemadevendas.bd.RoteiroDAO;
import br.com.sistemadevendas.bd.RoteiroMariadb;
import br.com.sistemadevendas.models.Pagamento;
import br.com.sistemadevendas.models.RoteiroDeViagem;

@WebServlet("/finance-report")
public class FinanceReport extends HttpServlet {
	private RoteiroDAO roteiroDao = new RoteiroMariadb();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=report.csv");
		PrintWriter out = response.getWriter();
		PagamentoDAO pagamentoDao = new PagamentoMariadb();
		RoteiroDAO roteiroDao = new RoteiroMariadb();
		out.println("Nome,Preço,Forma de pagamento,Código do cartão,Data");
		for (Pagamento pagamento : pagamentoDao.getPagamentos()) {
			RoteiroDeViagem roteiro = roteiroDao.getRoteiro(pagamento.getRoteiro());
			out.print(roteiro.getCliente().getCpf() + "," +
					Float.toString(roteiro.calcularPreco()) + "," +
					pagamento.getForma().toString() + "," +
					pagamento.getCodigo() + "," +
					new SimpleDateFormat("yyyy-MM-dd hh:mm")
						.format(pagamento.getDate()) + "\n");
		}
	}
}
