package com.ant.goldenticket;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ant.goldenticket.dao.DAOArtista;
import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.dao.Database;
import com.ant.goldenticket.entities.Artista;
import com.ant.goldenticket.entities.Localita;

@Configuration
public class Context {
	@Bean
	public Database db() {
		return new Database("GoldenTicket","root","root");
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
	
	
}
