package br.com.sistemadevendas.models;

import java.security.InvalidParameterException;

public class Hotel {
	private int id;
	private String nome;
	private double diaria;
	private String localizacao;
	
	public Hotel(int id, String nome, double diaria, String localizacao) {
		if (diaria < 0)
			throw new InvalidParameterException("diaria precisa ser positiva");
		this.id = id;
		this.nome = nome;
		this.diaria = diaria;
		this.localizacao = localizacao;
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
	
	public String getLocalizacao() {
		return localizacao;
	}
}