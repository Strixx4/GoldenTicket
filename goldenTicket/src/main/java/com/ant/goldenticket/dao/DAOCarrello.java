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
	@Autowired
	private ApplicationContext context;

	// nel carrello leggo una lista di biglietti
	public List<Biglietto> read(String query, String... params) {
		List<Biglietto> ris = new ArrayList<Biglietto>();
		List<Map<String, String>> righe = db.rows(query, params);
		for (Map<String, String> m : righe) { // prende mappa, utente, evento
			Biglietto b = (Biglietto) context.getBean("leggiBiglietto", m, du.readByID(Integer.parseInt(m.get("idUser"))),
					de.cercaPerID(Integer.parseInt(m.get("idEvento"))));
			
			ris.add(b);
		}
		return ris;
	}

	public List<Biglietto> readAll(int u) {
		return read("select * from carrello where idUser=?", u + "");
	}

	public boolean create(Biglietto b) {
		String query = "insert into carrello " + "(fila,posto,prezzo,idUser,idEvento) " + "values(?,?,?,?,?)";
		return db.update(query, b.getFila(), b.getPosto() + "", b.getPrezzo() + "", b.getUtente().get("id") + "",
				b.getEvento().getId() + "");
	}

	public boolean delete(int id) {
		String query = "delete from carrello where id=?";
		return db.update(query, id + "");
	}

	public Biglietto cercaPerId(int id) {
		return read("select * from carrello where id = ?", id + "").get(0);
	}
}
