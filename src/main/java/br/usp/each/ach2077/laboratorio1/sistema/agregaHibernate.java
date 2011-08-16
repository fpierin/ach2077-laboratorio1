package br.usp.each.ach2077.laboratorio1.sistema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.usp.each.ach2077.laboratorio1.dao.PontoGeograficoDAO;
import br.usp.each.ach2077.laboratorio1.modelos.dao.DAOGenerico;
import br.usp.each.ach2077.laboratorio1.representacoes.PontoGeografico;

public class agregaHibernate {
	
	public static void main(final String[] args) {
		
		final SessionFactory sessionFactory = new AnnotationConfiguration().buildSessionFactory();
		
		final Session session = sessionFactory.openSession();
		
		final DAOGenerico<PontoGeografico> dao = new PontoGeograficoDAO(session);
		
		final PontoGeografico pontoGeografico = new PontoGeografico();
		
		dao.deleta(pontoGeografico);
		dao.salva(pontoGeografico);
		dao.atualiza(pontoGeografico);
		dao.busca(pontoGeografico)
		dao.lista();
		
	}

}