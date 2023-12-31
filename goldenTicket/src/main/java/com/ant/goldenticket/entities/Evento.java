package com.ant.goldenticket.entities;

import java.util.List;

public class Evento extends Entity{
	private String nome;
	private String tipologia;
	private String genere;
	private String data;
	private String giornoSettimana;
	private String ora;
	private String locandina;
	private Localita localita;
	private List<Artista> artisti;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getGiornoSettimana() {
		return giornoSettimana;
	}
	public void setGiornoSettimana(String giorno) {
		this.giornoSettimana = giorno;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public Localita getLocalita() {
		return localita;
	}
	public void setLocalita(Localita localita) {
		this.localita = localita;
	}
	public List<Artista> getArtisti() {
		return artisti;
	}
	public void setArtisti(List<Artista> artisti) {
		this.artisti = artisti;
	}
	public String getLocandina() {
		return locandina;
	}
	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}
	
}
