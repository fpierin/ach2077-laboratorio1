package br.usp.each.ach2077.laboratorio1.sistema;

import br.usp.each.ach2077.laboratorio1.dao.PontoGeograficoDAO;
import br.usp.each.ach2077.laboratorio1.modelos.dao.DAOGenerico;
import br.usp.each.ach2077.laboratorio1.representacoes.PontoGeografico;

public class agregaHibernate {
	
	public static void main(final String[] args) {
		
		
		final DAOGenerico<PontoGeografico> dao = new PontoGeograficoDAO(null);
		
		final PontoGeografico pontoGeografico = new PontoGeografico();
		
		dao.deleta(pontoGeografico);
		dao.salva(pontoGeografico);
		dao.atualiza(pontoGeografico);
		dao.busca(pontoGeografico);
		dao.lista();
		
	}

}