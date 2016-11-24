package br.com.sistemadevendas.models;

import java.util.Date;

public class Pagamento {
	public enum Forma {
		CARTAO, DINHEIRO, CHEQUE
	};
	private Forma forma;
	private Date date;
	private int roteiro;
	private String codigo;
	
	public Pagamento(Forma forma, Date date, int roteiro, String codigo) {
		this.forma = forma;
		this.date = date;
		this.roteiro = roteiro;
		this.codigo = codigo;
	}
	
	public Forma getForma() {
		return forma;
	}

	public Date getDate() {
		return date;
	}

	public int getRoteiro() {
		return roteiro;
	}

	public String getCodigo() {
		return codigo;
	}
}
