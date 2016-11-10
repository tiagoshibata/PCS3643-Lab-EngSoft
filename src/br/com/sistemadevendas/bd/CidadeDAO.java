package br.com.sistemadevendas.bd;

import java.util.List;

import br.com.sistemadevendas.models.Cidade;

public interface CidadeDAO {
   public List<Cidade> getCidades();
   public Cidade getCidade(int ID);
   public void adicionarCidade(Cidade cidade);
   public void alterarCidade(Cidade cidade);
   public void deletarCidade(Cidade cidade);
}
