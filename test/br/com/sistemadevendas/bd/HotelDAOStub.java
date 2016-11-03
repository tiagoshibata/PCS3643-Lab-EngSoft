package br.com.sistemadevendas.bd;

import java.util.Arrays;
import java.util.List;

import br.com.sistemadevendas.models.Hotel;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HotelDAOStub implements HotelDAO {
	private static final List<Hotel> hoteis = Arrays.asList(new Hotel[]{
			new Hotel(0, "Test Hotel 1", 100, "Test City 1"),
			new Hotel(1, "Test Hotel 2", 200, "Test City 2"),
			new Hotel(2, "Test Hotel 3", 300, "Test City 3"),
		});
	
	@Override
	public Hotel getHotel(int id) {
		if (id < hoteis.size())
			return hoteis.get(id);
		return null;
	}
	
	@Override
	public List<Hotel> getHoteis() {
		return hoteis;
	}

	@Override
	public int getContagemHoteis() {
		return hoteis.size();
	}
	
	@Override
	public void adicionarHotel(Hotel hotel) { throw new NotImplementedException(); }

	@Override
	public void alterarHotel(Hotel hotel) { throw new NotImplementedException(); }

	@Override
	public void deletarHotel(Hotel hotel) { throw new NotImplementedException(); }
	
}
