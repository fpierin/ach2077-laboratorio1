package br.usp.each.ach2077.laboratorio1.dao;

/**
 * Autor: Felipe Lombardi Pierin
 * 
 * Exemplo da implementação de um modelo DAO genérico capaz de conectar ao PostGreeSQL
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usp.each.ach2077.laboratorio1.modelos.dao.DAOGenerico;
import br.usp.each.ach2077.laboratorio1.representacoes.PontoGeografico;

public class PontoGeograficoDAO implements DAOGenerico<PontoGeografico> {
	
	private static final String LISTA_PONTOS_GEOGRAFICOS = 
		"select * from Ponto_Geografico";

	private static final String DELETE_PONTO_GEOGRAFICO = 
		"delete from Ponto_Geografico where IdPonto=?";

	private static final String UPDATE_PONTO_GEOGRAFICO = 
		"update Ponto_Geografico set NomePonto=?, graus=?, minutos=?, segundos=? where IdPonto=?";

	private static final String SALVA_PONTO_GEOGRAFICO = 
		"insert into Ponto_Geografico values (IdPonto, NomePonto, graus, minutos, segundos)" +
		" (IdPonto, NomePonto, graus, minutos, segundos)";
	
	private final Connection connection;

	public PontoGeograficoDAO(final Connection connection) {
		this.connection = connection;
	}

	@Override
	public void remove(final PontoGeografico pontoGeografico) {
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PONTO_GEOGRAFICO);
			preparedStatement.setLong(1, pontoGeografico.getIdPonto());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void salva(final PontoGeografico pontoGeografico) {
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(SALVA_PONTO_GEOGRAFICO);
			preparedStatement.setInt(1, pontoGeografico.getIdPonto());		
			preparedStatement.setString(2, pontoGeografico.getNomePonto());
			preparedStatement.setInt(3, pontoGeografico.getGraus());
			preparedStatement.setInt(4, pontoGeografico.getMinutos());
			preparedStatement.setInt(5, pontoGeografico.getSegundos());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}		
	}

	@Override
	public void atualiza(final PontoGeografico pontoGeografico) {
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PONTO_GEOGRAFICO);
			preparedStatement.setString(1, pontoGeografico.getNomePonto());
			preparedStatement.setInt(2, pontoGeografico.getGraus());
			preparedStatement.setInt(3, pontoGeografico.getMinutos());
			preparedStatement.setInt(4, pontoGeografico.getSegundos());
			preparedStatement.setInt(5, pontoGeografico.getIdPonto());			
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}	
	}

	@Override
	public List<PontoGeografico> lista() {
		try{
			List<PontoGeografico> pontosGeograficos = null;
			pontosGeograficos = new ArrayList<PontoGeografico>();
			PreparedStatement preparedStatement = this.connection.prepareStatement(LISTA_PONTOS_GEOGRAFICOS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				PontoGeografico pontoGeografico = new PontoGeografico();
				pontoGeografico.setGraus(resultSet.getInt("graus"));
				pontoGeografico.setIdPonto(resultSet.getInt("IdPonto"));
				pontoGeografico.setMinutos(resultSet.getInt("minutos"));
				pontoGeografico.setNomePonto(resultSet.getString("NomePonto"));
				pontoGeografico.setSegundos(resultSet.getInt("segundos"));
				pontosGeograficos.add(pontoGeografico);
			}
			resultSet.close();
			preparedStatement.close();
			return pontosGeograficos;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
