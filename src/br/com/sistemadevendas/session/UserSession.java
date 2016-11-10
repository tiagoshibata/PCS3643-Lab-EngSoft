package br.com.sistemadevendas.session;

import java.nio.file.AccessDeniedException;
import java.util.LinkedList;
import java.util.List;

import br.com.sistemadevendas.models.Cliente;
import br.com.sistemadevendas.models.Parada;

public class UserSession {
	private static LinkedList<Parada> roteiro = new LinkedList<>();
	private static Cliente cliente = null;
	
	private UserSession() {}
	
	public static UserSession getSession() throws AccessDeniedException {
		if (cliente == null)
			throw new AccessDeniedException("Nenhuma sessão para cliente iniciada");
		return new UserSession();
		
	}
	
	public static UserSession startSession(Cliente cliente) {
		UserSession.cliente = cliente;
		roteiro.clear();
		return new UserSession();
	}
	
	public void addParada(Parada parada) {
		roteiro.add(parada);
	}
	
	public List<Parada> getRoteiro() {
		return roteiro;
	}
}
