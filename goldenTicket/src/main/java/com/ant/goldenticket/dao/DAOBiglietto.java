package com.ant.goldenticket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.goldenticket.entities.Biglietto;
import com.ant.goldenticket.entities.Localita;

public class DAOBiglietto {
	
	@Autowired
	private Database db;
	
	@Autowired
	private ApplicationContext context;
	
	public List<Biglietto> read(String query,String ...params)
	{
		List<Biglietto> ris=new ArrayList<Biglietto>();
		List<Map<String,String>>righe=db.rows(query, params);
		for(Map<String,String> m:righe)
		{
			Biglietto b =context.getBean(Biglietto.class,m);
			ris.add(b);
		}
		return ris;
	}
	public List<Biglietto> readAll()
	{
		return read("select * from bigliettiacquistati");
	}
	public boolean create(Biglietto b)
	{
		String query="insert into bigliettiacquistati "
				+ "(fila,posto,prezzo) "
				+ "values(?,?,?)";
		return db.update(query,b.getFila(),b.getPosto()+"", b.getPrezzo()+"");
	}
	public boolean delete(int id)
	{
		String query="delete from bigliettiacquistati where id=?";
		return db.update(query,id+"");
	}
	
	public Biglietto cercaPerId(int id)
	{
		String query="select * from bigliettiacquistati where id=?";
		Map<String,String>m=db.row(query,id+"");
		Biglietto b=context.getBean(Biglietto.class,m);
		return b;
	}
	
}

