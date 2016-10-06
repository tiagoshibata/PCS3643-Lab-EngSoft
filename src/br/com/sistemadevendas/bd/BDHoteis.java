package br.com.sistemadevendas.bd;

import br.com.sistemadevendas.models.Hotel;

public class BDHoteis {
	private static Hotel[] hoteis = {
		new Hotel(0, "Unique", 120, "Curitiba"),
		new Hotel(1, "Ibis", 140, "Rio de Janeiro"),
		new Hotel(2, "Maksoud Plaza", 300, "São Paulo"),
		new Hotel(3, "Palace", 500, "São Paulo"),
	};
	
	public Hotel getHotel(int id) {
		if (id < hoteis.length)
			return hoteis[id];
		return null;
	}
	
	public int getContagemHoteis() {
		return hoteis.length;
	}
}
