package br.com.sistemadevendas.bd;
import java.util.List;
import br.com.sistemadevendas.models.Cliente;

public interface ClienteDAO {
   public List<Cliente> getClientes();
   public Cliente getCliente(String cpf);
   public void adicionarCliente(Cliente cliente);
   public void alterarCliente(Cliente cliente);
   public void deletarCliente(Cliente cliente);
}