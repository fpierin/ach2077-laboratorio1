package br.usp.each.ach2077.laboratorio1.representacoes;

import java.io.Serializable;

public class PontoGeografico implements Serializable {

	private static final long serialVersionUID = 6006551901840371339L;
	
	private int IdPonto;
	
	private String NomePonto;
	
	private int graus;
	
	private int minutos;
	
	private int segundos;
	
	public PontoGeografico() {}

	public PontoGeografico(final int idPonto, final String nomePonto, final int graus,
			final int minutos, final int segundos) {
		super();
		this.IdPonto = idPonto;
		this.NomePonto = nomePonto;
		this.graus = graus;
		this.minutos = minutos;
		this.segundos = segundos;
	}

	public int getIdPonto() {
		return IdPonto;
	}

	public void setIdPonto(final int idPonto) {
		IdPonto = idPonto;
	}

	public String getNomePonto() {
		return NomePonto;
	}

	public void setNomePonto(final String nomePonto) {
		NomePonto = nomePonto;
	}

	public int getGraus() {
		return graus;
	}

	public void setGraus(final int graus) {
		this.graus = graus;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(final int minutos) {
		this.minutos = minutos;
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(final int segundos) {
		this.segundos = segundos;
	}

	@Override
	public String toString() {
		return "PontoGeografico [IdPonto=" + IdPonto + ", NomePonto="
				+ NomePonto + ", graus=" + graus + ", minutos=" + minutos
				+ ", segundos=" + segundos + "]";
	}
	
}
