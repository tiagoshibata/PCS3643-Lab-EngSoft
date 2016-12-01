package br.com.sistemadevendas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sistemadevendas.bd.RoteiroDAO;
import br.com.sistemadevendas.bd.RoteiroMariadb;
import br.com.sistemadevendas.models.Parada;
import br.com.sistemadevendas.models.RoteiroDeViagem;
import br.com.sistemadevendas.session.UserSession;

@WebServlet("/fim-roteiro")
public class FimRoteiro extends HttpServlet {
	private RoteiroDAO roteiroDao = new RoteiroMariadb();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoteiroDeViagem roteiro;
		String idRoteiro = request.getParameter("roteiro");
		if (idRoteiro != null) {
			roteiro = roteiroDao.getRoteiro(Integer.parseInt(idRoteiro));
			Parada inicio = roteiro.getParadas().get(0);
			UserSession.startSession(roteiro.getCliente().getCpf(), roteiro.getNumeroDePessoas(),
					inicio.getHotel().getCidade(), null);
		} else
			roteiro = UserSession.getSession().getRoteiro();
		RequestDispatcher dispatcher = request.getRequestDispatcher("view-fim-roteiro.jsp");
		request.setAttribute("roteiro", roteiro);
		dispatcher.forward(request, response);
	}
}
