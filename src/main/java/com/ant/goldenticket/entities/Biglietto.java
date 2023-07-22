package com.ant.goldenticket.entities;

import java.util.Map;

public class Biglietto extends Entity{
	
	private String dataEmissione;
	private String fila;
	private int posto;
	private double prezzo;
	private Map<String,String> utente;
	private Evento evento;
	public String getDataEmissione() {
		return dataEmissione;
	}
	public void setDataEmissione(String dataEmissione) {
		this.dataEmissione = dataEmissione;
	}
	public String getFila() {
		return fila;
	}
	public void setFila(String fila) {
		this.fila = fila;
	}
	public int getPosto() {
		return posto;
	}
	public void setPosto(int posto) {
		this.posto = posto;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public Map<String, String> getUtente() {
		return utente;
	}
	public void setUtente(Map<String, String> utente) {
		this.utente = utente;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
	
}
