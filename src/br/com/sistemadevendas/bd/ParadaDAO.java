package br.com.sistemadevendas.bd;
import java.util.List;
import br.com.sistemadevendas.models.Parada;

public interface ParadaDAO {
   public List<Parada> getParadas(int idRoteiro);
   public Parada getParada(int id);
   public void adicionarParada(Parada parada, int idRoteiro);
}