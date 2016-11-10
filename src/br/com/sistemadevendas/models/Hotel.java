package br.com.sistemadevendas.models;

import java.security.InvalidParameterException;

public class Hotel {
	private int id;
	private String nome;
	private double diaria;
	private int cidade;
	
	public Hotel(int id, String nome, double diaria, int cidade) {
		if (diaria < 0)
			throw new InvalidParameterException("diaria precisa ser positiva");
		this.id = id;
		this.nome = nome;
		this.diaria = diaria;
		this.cidade = cidade;
	}
	
	public int getId() {
		return id;
	}

	public double getPrecoDiaria() {
		return diaria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getCidade() {
		return cidade;
	}
}