package br.com.sistemadevendas.bd;
import java.util.List;

import br.com.sistemadevendas.models.Cidade;
import br.com.sistemadevendas.models.Transporte;

public interface TransporteDAO {
   public Transporte getTransporte(int ID);
   public void adicionarTransporte(Transporte transporte);
   public void alterarTransporte(Transporte transporte);
   public void deletarTransporte(Transporte transporte);
   public Transporte transporteMaisBarato();
   public List<Transporte> getTransportes(Cidade origem, Cidade destino);
}