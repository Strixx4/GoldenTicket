package com.ant.goldenticket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.goldenticket.entities.Biglietto;

public class DAOCarrello {
	
	@Autowired
	Database db;
	@Autowired
	DAOEvento de;
	@Autowired
	DAOUtenti du;
	
	private ApplicationContext context;
	
	//nel carrello leggo una lista di biglietti
	public List<Biglietto> read(String query,Map<String,String> u, String ...params)
	{
		List<Biglietto> ris=new ArrayList<Biglietto>();
		List<Map<String,String>>righe=db.rows(query, params);
		for(Map<String,String> m:righe)
		{ //prende mappa, utente, evento
			Biglietto b =context.getBean(Biglietto.class,m,u,de.cercaPerID(Integer.parseInt(m.get("id"))));
			ris.add(b);
		}
		return ris;
	}
	
	public List<Biglietto> readAll(Map<String,String> u)
	{
	return read("select * from carrello",u);
	}

public boolean create(Biglietto b)
{
	String query="insert into carrello "
			+ "(fila,posto,prezzo,idUser,idEvento) "
			+ "values(?,?,?,?,?)";
	return db.update(query,b.getFila(),b.getPosto()+"", b.getPrezzo()+"",b.getUtente().get("id")+"",b.getEvento().getId()+"");
}
public boolean delete(int id)
{
	String query="delete from carrello where id=?";
	return db.update(query,id+"");
}

public Biglietto cercaPerId(int id)
{
	String query="select * from carrello where id=?";
	Map<String,String>m=db.row(query,id+"");
	Biglietto b=context.getBean(Biglietto.class,m);
	return b;
}
}


