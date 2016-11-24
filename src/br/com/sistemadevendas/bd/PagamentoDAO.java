package br.com.sistemadevendas.bd;

import java.util.List;

import br.com.sistemadevendas.models.Pagamento;

public interface PagamentoDAO {
   public Pagamento getPagamento(int id);
   public List<Pagamento> getPagamentos();
   public void adicionarPagamento(Pagamento pagamento);
}
