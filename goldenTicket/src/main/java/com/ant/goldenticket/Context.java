package com.ant.goldenticket;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.ant.goldenticket.dao.DAOArtista;
import com.ant.goldenticket.dao.DAOBigliettoAcquistato;
import com.ant.goldenticket.dao.DAOCarrello;
import com.ant.goldenticket.dao.DAOEvento;
import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.dao.DAOUtenti;
import com.ant.goldenticket.dao.Database;
import com.ant.goldenticket.entities.Artista;
import com.ant.goldenticket.entities.Biglietto;
import com.ant.goldenticket.entities.Evento;
import com.ant.goldenticket.entities.Localita;

@Configuration
public class Context {
	@Bean
	public Database db() {
		return new Database("GoldenTicket","root","Q705322H");
	}

	@Bean 
	public DAOLocalita daolocalita()
	{
		return new DAOLocalita();
	}
	@Bean 
	public DAOArtista daoartista()
	{
		return new DAOArtista();
	}
	@Bean
	public DAOUtenti daoutenti(){
		return new DAOUtenti();
	}
	
	@Bean
	public DAOEvento daoevento() {
		return new DAOEvento();

	}
	@Bean
	public DAOBigliettoAcquistato daoba() {
		return new DAOBigliettoAcquistato();

	}
	@Bean
	public DAOCarrello daocarrello() {
		return new DAOCarrello();

	}
	
	@Bean
	@Scope("prototype")
	public Localita mappaLocalita(Map<String,String> ml)
	{
		Localita l = new Localita();
		l.fromMap(ml);
		return l;
	}
	@Bean
	@Scope("prototype")
  	public Artista mappaArtista(Map<String,String> ma)
	{
		Artista a = new Artista();
		a.fromMap(ma);
		return a;
	}
	@Bean
	@Scope("prototype")
	public Biglietto creaBigliettoCarrello(String fila,int posto,double prezzo,Map<String,String> utente,Evento evento) {
		Biglietto b = new Biglietto();
		b.setFila(fila);
		b.setPosto(posto);
		b.setPrezzo(prezzo);
		b.setUtente(utente);
		b.setEvento(evento);
		return b;
	}
	@Bean
	@Scope("prototype")
	public Biglietto creaBigliettoAcquistato(String dataEmissione,String fila,int posto,double prezzo,Map<String,String> utente,Evento evento) {
		Biglietto b = new Biglietto();
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
	public Biglietto leggiBiglietto(Map<String,String> valori,Map<String,String> u, Evento e) {
		Biglietto b = new Biglietto();
		b.fromMap(valori);
		b.setEvento(e);
		b.setUtente(u);
		return b;
	}
	@Bean
	@Scope("prototype")
<<<<<<< Updated upstream
	public Evento evento(Map<String,String> valori, List<Artista> a, Localita l) {
=======
	@Primary
	public Evento evento(Map<String,String> m, List<Artista> a, Localita l) {
		Evento e = new Evento();
		e.fromMap(m);
		e.setArtisti(a);
		e.setLocalita(l);
		return e;
	}

	@Bean
	@Scope("prototype")
	public Evento creaEvento(Map<String,String> m, List<Artista> a, Localita l)
	{
>>>>>>> Stashed changes
		Evento e = new Evento();
		e.fromMap(valori);
		e.setArtisti(a);
		e.setLocalita(l);
		return e;
	}
}
