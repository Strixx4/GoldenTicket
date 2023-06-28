package com.ant.goldenticket.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.goldenticket.entities.Localita;

public class DAOLocalita {
	@Autowired
	private Database db;

	@Autowired
	private ApplicationContext context;

	public List<Localita> read(String query, String... params) {
		List<Localita> ris = new ArrayList<Localita>();
		List<Map<String, String>> righe = db.rows(query, params);
		for (Map<String, String> m : righe) {
			Localita l = context.getBean(Localita.class, m);
			ris.add(l);
		}
		return ris;
	}

	public List<Localita> readAll() {
		return read("select * from localita");
	}

	public boolean create(Localita l) {
		String query = "insert into localita " + "(citta,zona,posti,indirizzo) " + "values(?,?,?,?)";
		return db.update(query, l.getCitta(), l.getZona(), l.getPosti() + "", l.getIndirizzo());
	}

	public boolean delete(int id)
	{
		String query="delete from localita where id=?";
		return db.update(query,id+"");
	}

	public boolean update(Localita l) {
		String query = "update localita " + "set citta=?,zona=?,posti=?,indirizzo=? " + "where id=?";
		return db.update(query, l.getCitta(), l.getZona(), l.getPosti() + "", l.getIndirizzo(), l.getId() + "");
	}

	public Localita cercaPerId(int id) {
		String query = "select * from localita where id=?";
		Map<String, String> m = db.row(query, id + "");
		Localita l = context.getBean(Localita.class, m);
		return l;
	}

	public List<String> tutteLeCitta() {
		List<Map<String, String>> c = db.rows("select citta from localita group by citta order by citta ");
		List<String> ris = new ArrayList<>();
		for (Map<String, String> m : c)
			ris.add(m.get("citta"));
		return ris;
	}

	public List<String> tutteLeZone(String citta) {
		List<Map<String, String>> c = db.rows("select zona from localita  where citta like ? order by zona  ", citta);
		List<String> ris = new ArrayList<>();
		for (Map<String, String> m : c)
			ris.add(m.get("zona"));
		return ris;
	}

	public Localita cercaPerLocalita(String zona, String citta) {
		List<Localita> l = read("select * from localita where citta like \"%"+citta+"%\" and zona like \"%"+zona+"%\"");
		if (l.size() > 0)
			return l.get(0);
		else
			return null;
	}

}
