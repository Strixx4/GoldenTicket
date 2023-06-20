package com.ant.goldenticket;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.dao.Database;
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
}
