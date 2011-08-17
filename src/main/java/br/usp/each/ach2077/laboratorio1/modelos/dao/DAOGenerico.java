package br.usp.each.ach2077.laboratorio1.modelos.dao;

import java.util.List;


public interface DAOGenerico<T> {
	
	public void remove(T objeto);

	public void salva(T objeto);

	public void atualiza(T objeto);

	public List<T> lista();

}
