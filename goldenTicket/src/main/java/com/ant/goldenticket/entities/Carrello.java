package com.ant.goldenticket.entities;

import java.util.List;
import java.util.Map;

public class Carrello 
{
	private List<Biglietto> listaBiglietti;
	private Map<String,String> utente;
	
	public List<Biglietto> getListaBiglietti() {
		return listaBiglietti;
	}
	public void setListaBiglietti(List<Biglietto> listaBiglietti) {
		this.listaBiglietti = listaBiglietti;
	}
	public Map<String, String> getUtente() {
		return utente;
	}
	public void setUtente(Map<String, String> utente) {
		this.utente = utente;
	}
	
}
