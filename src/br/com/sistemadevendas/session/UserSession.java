package br.com.sistemadevendas.session;

import java.nio.file.AccessDeniedException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

import br.com.sistemadevendas.bd.ClienteDAO;
import br.com.sistemadevendas.bd.ClienteMariadb;
import br.com.sistemadevendas.models.Cliente;
import br.com.sistemadevendas.models.Parada;

public class UserSession {
	private static LinkedList<Parada> roteiro = new LinkedList<>();
	private static String cpf = null;
	private static int cidadeAtual = -1;
	private static Time dataAtual = null;
	private static int numeroPessoas = -1;
	
	public static ClienteDAO clienteDao = new ClienteMariadb();
	
	public static UserSession getSession() throws AccessDeniedException {
		if (cpf == null)
			throw new AccessDeniedException("Nenhuma sessão para cliente iniciada");
		return new UserSession();
	}
	
	public static UserSession startSession(String cpf, int numeroPessoas, int cidadeBase, Time dataInicial) throws AccessDeniedException {
		if (clienteDao.getCliente(cpf) == null)
			throw new AccessDeniedException("Cliente não encontrado");
		UserSession.cpf = cpf;
		UserSession.numeroPessoas = numeroPessoas;
		cidadeAtual = cidadeBase;
		roteiro.clear();
		dataAtual = dataInicial;
		return new UserSession();
	}
	
	public static void stopSession() {
		cpf = null;
	}
	
	public void addParada(Parada parada) {
		roteiro.add(parada);
		cidadeAtual = parada.getHotel().getCidade();
	}
	
	public List<Parada> getRoteiro() {
		return roteiro;
	}
	
	public int getCidadeAtual() {
		return cidadeAtual;
	}
	
	public int getNumeroPessoas() {
		return numeroPessoas;
	}
}
