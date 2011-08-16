package br.usp.each.ach2077.laboratorio1.dao;

/**
 * Autor: Felipe Lombardi Pierin
 * 
 * Exemplo da implementação de um modelo DAO genérico capaz de conectar ao PostGreeSQL
 */

import java.util.List;

import org.hibernate.Session;

import br.usp.each.ach2077.laboratorio1.modelos.dao.DAOGenerico;
import br.usp.each.ach2077.laboratorio1.representacoes.PontoGeografico;

public class PontoGeograficoDAO implements DAOGenerico<PontoGeografico> {
	

	private final Session session;

	public PontoGeograficoDAO(final Session session) {
		this.session = session;
	}

	@Override
	public void deleta(final PontoGeografico pontoGeografico) {
		session.delete(pontoGeografico);
	}

	@Override
	public void salva(final PontoGeografico pontoGeografico) {
		session.save(pontoGeografico);
	}

	@Override
	public void atualiza(final PontoGeografico pontoGeografico) {
		session.update(pontoGeografico);
	}

	@Override
	public PontoGeografico busca(final PontoGeografico pontoGeografico) {
		return session.load(PontoGeografico.class, pontoGeografico);
	}

	@Override
	public List<PontoGeografico> lista() {
		// TODO Auto-generated method stub
		return null;
	}


}
