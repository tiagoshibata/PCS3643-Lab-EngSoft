package br.com.sistemadevendas.bd;

import java.util.List;
import br.com.sistemadevendas.models.Hotel;

public interface HotelDAO {
   public List<Hotel> getHoteis();
   public Hotel getHotel(int ID);
   public void adicionarHotel(Hotel hotel);
   public void alterarHotel(Hotel hotel);
   public void deletarHotel(Hotel hotel);
}