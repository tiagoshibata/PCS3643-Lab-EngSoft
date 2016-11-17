package br.com.sistemadevendas.servlet;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;

import br.com.sistemadevendas.bd.ClienteDAOStub;
import br.com.sistemadevendas.session.UserSession;

public class ListarCidadesTest {
	@Before
	public void setUp() {
		UserSession.clienteDao = new ClienteDAOStub();
	}

	public class InvalidCpfRequest extends HttpServletRequestStub {
		@Override
		public String getParameter(String param) {
			switch (param) {
			case "cpf":
				return "00000000000";

			case "cidade":
				return "2";

			case "numero-pessoas":
				return "1";

			default:
				return null;
			}
		}
	}

	@Test(expected=AccessDeniedException.class)
	public void testAuthenticates() throws ServletException, IOException {
		HttpServletRequest request = new InvalidCpfRequest();
		ListarCidades servlet = new ListarCidades();
		servlet.doGet(request, null);
	}

}
