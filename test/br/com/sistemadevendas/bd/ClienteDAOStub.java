package br.com.sistemadevendas.bd;

import java.util.Arrays;
import java.util.List;

import br.com.sistemadevendas.models.Cliente;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ClienteDAOStub implements ClienteDAO {
	private static final List<Cliente> clientes = Arrays.asList(new Cliente[]{
			new Cliente("Test Cliente 1", "00123456789"),
			new Cliente("Test Cliente 2", "10123456789"),
			new Cliente("Test Cliente 3", "20123456789"),
		});

	@Override
	public List<Cliente> getClientes() {
		return clientes;
	}

	@Override
	public Cliente getCliente(String cpf) {
		for (Cliente c : clientes)
			if (c.getCpf() == cpf)
				return c;
		return null;
	}

	@Override
	public void adicionarCliente(Cliente cliente) {
		throw new NotImplementedException();
	}

	@Override
	public void alterarCliente(Cliente cliente) {
		throw new NotImplementedException();
	}

	@Override
	public void deletarCliente(Cliente cliente) {
		throw new NotImplementedException();
	}
}
