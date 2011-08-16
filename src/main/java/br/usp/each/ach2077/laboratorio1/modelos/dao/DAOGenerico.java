package br.usp.each.ach2077.laboratorio1.modelos.dao;

import java.util.List;


public interface DAOGenerico<T> {
	
	public void deleta(T objeto);

	public void salva(T objeto);

	public void atualiza(T objeto);

	public T busca(T objeto);

	public List<T> lista();

}
