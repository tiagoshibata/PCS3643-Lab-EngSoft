package br.com.sistemadevendas.bd;

import br.com.sistemadevendas.models.RoteiroDeViagem;

public interface RoteiroDAO {
   public RoteiroDeViagem getRoteiro(int id);
   public int adicionarRoteiro(String cpf, int numeroDePessoas);
}