package br.com.sistemadevendas.bd;

import java.util.List;

import br.com.sistemadevendas.models.RoteiroDeViagem;

public interface RoteiroDAO {
	public RoteiroDeViagem getRoteiro(int id);
	public List<RoteiroDeViagem> getRoteiros(String cpf);
	public int adicionarRoteiro(String cpf, int numeroDePessoas);
}