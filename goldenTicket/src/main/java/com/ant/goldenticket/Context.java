package com.ant.goldenticket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.dao.Database;

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
}
