package br.com.sistemadevendas.bd;

import java.util.List;

import br.com.sistemadevendas.models.Cidade;
import br.com.sistemadevendas.models.Hotel;

public interface HotelDAO {
   public List<Hotel> getHoteis();
   public List<Hotel> getHoteis(Cidade cidade);
   public Hotel getHotel(int ID);
   public void adicionarHotel(Hotel hotel);
   public void alterarHotel(Hotel hotel);
   public void deletarHotel(Hotel hotel);
   public int getContagemHoteis();
}