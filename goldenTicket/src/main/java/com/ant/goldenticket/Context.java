package com.ant.goldenticket;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.dao.Database;
import com.ant.goldenticket.entities.Biglietto;
import com.ant.goldenticket.entities.Evento;
import com.ant.goldenticket.entities.Localita;

@Configuration
public class Context {
	@Bean
	public Database db() {
		return new Database("GoldenTicket","root","root");
	}

	@Bean 
	DAOLocalita daolocalita()
	{
		return new DAOLocalita();
	}
	
	@Bean
	@Scope("prototype")
	public Localita mappalocalita(Map<String,String> m)
	{
		Localita l = new Localita();
		l.fromMap(m);
		return l;
	}
	@Bean
	@Scope("prototype")
	public Biglietto creaBiglietto(int id,String dataEmissione,String fila,int posto,double prezzo,Map<String,String> utente,Evento evento) {
		Biglietto b = new Biglietto();
		b.setId(id);
		b.setDataEmissione(dataEmissione);
		b.setFila(fila);
		b.setPosto(posto);
		b.setPrezzo(prezzo);
		b.setUtente(utente);
		b.setEvento(evento);
		return b;
	}
	
	@Bean
	@Scope("prototype")
	public Biglietto leggiBiglietto(Map<String,String> valori) {
		Biglietto b = new Biglietto();
		b.fromMap(valori);
		return b;
	}
}
