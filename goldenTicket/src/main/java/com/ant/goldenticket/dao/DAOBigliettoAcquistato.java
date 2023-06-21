package com.ant.goldenticket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.goldenticket.entities.Biglietto;
import com.ant.goldenticket.entities.Localita;

public class DAOBigliettoAcquistato {
	
	@Autowired
	private Database db;
	@Autowired
	private DAOEvento de;
	@Autowired
	private ApplicationContext context;
	
	public List<Biglietto> read(String query,Map<String,String> u, String ...params)
	{
		List<Biglietto> ris=new ArrayList<Biglietto>();
		List<Map<String,String>>righe=db.rows(query, params);
		for(Map<String,String> m:righe)
		{
			Biglietto b =context.getBean(Biglietto.class,m,u,de.cercaPerID(Integer.parseInt(m.get("id"))));
			ris.add(b);
		}
		return ris;
	}
	public List<Biglietto> readAll(Map<String,String> u)
	{
		return read("select * from bigliettiacquistati",u);
	}
	
	public boolean create(Biglietto b)
	{
		String query="insert into bigliettiacquistati "
				+ "(fila,posto,prezzo,idUser,idEvento) "
				+ "values(?,?,?,?,?)";
		return db.update(query,b.getFila(),b.getPosto()+"", b.getPrezzo()+"",b.getUtente().get("id")+"",b.getEvento().getId()+"");
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

