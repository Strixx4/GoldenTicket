package com.ant.goldenticket.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.goldenticket.entities.Artista;


public class DAOArtista 
{
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Artista> read(String query,String ...params)
	{
		List<Artista> ris=new ArrayList<Artista>();
		List<Map<String,String>>righe=db.rows(query, params);
		for(Map<String,String> m:righe)
		{
			Artista a=context.getBean(Artista.class,m);
			ris.add(a);
		}
		return ris;
	}
	public List<Artista> readAll()
	{
		return read("select * from artisti");
	}
	public boolean create(Artista a)
	{
		String query="insert into artisti(nominativo) values(?)";
		return db.update(query, a.getNominativo());
	}
	public boolean delete(int id)
	{
		String query="delete from artisti where id=?";
		return db.update(query,id+"");
	}
	public boolean update(Artista a)
	{
		String query="update artisti set nominativo=? where id=?";
		return db.update(query, a.getNominativo(),a.getId()+"");
	}
	public Artista cercaPerId(int id)
	{
		String query="select * from artisti where id=?";
		Map<String,String>m=db.row(query,id+"");
		Artista a=context.getBean(Artista.class,m);
		return a;
	}
}
