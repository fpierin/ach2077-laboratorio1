package br.usp.each.ach2077.laboratorio1.sistema;

import java.sql.Connection;
import java.util.List;

import br.usp.each.ach2077.laboratorio1.dao.PontoGeograficoDAO;
import br.usp.each.ach2077.laboratorio1.modelos.dao.DAOGenerico;
import br.usp.each.ach2077.laboratorio1.representacoes.PontoGeografico;
import br.usp.each.ach2077.laboratorio1.utils.ConnectionFactory;

public class Laboratorio1_UsoDeJDBCcomDAO {
	
	public static void main(final String[] args) {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		
		final Connection connection = new ConnectionFactory().getConnection();
		final DAOGenerico<PontoGeografico> dao = new PontoGeograficoDAO(connection);
				
		final PontoGeografico pontoGeografico1 = new PontoGeografico(1, "Ponto1", 56, 12, 13);
		final PontoGeografico pontoGeografico2 = new PontoGeografico(2, "Ponto2", 57, 11, 3);
		final PontoGeografico pontoGeografico3 = new PontoGeografico(3, "Ponto3", 12, 28, 43);		
	
		dao.salva(pontoGeografico1);
		dao.salva(pontoGeografico2);
		dao.salva(pontoGeografico3);
		
		final List<PontoGeografico> pontoGeofraficos = dao.lista();
		for (final PontoGeografico pontoGeografico: pontoGeofraficos){
			System.out.println(pontoGeografico);
		}
		
		dao.remove(pontoGeografico3);		
		dao.remove(pontoGeografico2);
		dao.remove(pontoGeografico1);
		
	}

}