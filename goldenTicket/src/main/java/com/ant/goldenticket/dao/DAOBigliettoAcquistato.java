package com.ant.goldenticket.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.goldenticket.entities.Biglietto;

public class DAOBigliettoAcquistato {

	@Autowired
	private Database db;
	@Autowired
	private DAOEvento de;
	@Autowired
	private DAOUtenti du;
	@Autowired
	private ApplicationContext context;

	public List<Biglietto> read(String query, String... params) {
		List<Biglietto> ris = new ArrayList<Biglietto>();
		List<Map<String, String>> righe = db.rows(query, params);
		for (Map<String, String> m : righe) {
			Biglietto b = context.getBean(Biglietto.class, m, du.readByID(Integer.parseInt(m.get("id"))),
					de.cercaPerID(Integer.parseInt(m.get("idEvento"))));
			ris.add(b);
		}
		return ris;
	}

	public List<Biglietto> readAll(int u) {
		return read("select * from bigliettiacquistati where idUser=?", u + "");
	}

	public boolean create(Biglietto b) {
		String query = "insert into bigliettiacquistati " + "(fila,posto,prezzo,idUser,idEvento) "
				+ "values(?,?,?,?,?)";
		return db.update(query, b.getFila(), b.getPosto() + "", b.getPrezzo() + "", b.getUtente().get("id") + "",
				b.getEvento().getId() + "");
	}
	
	public boolean createAcquisto(Biglietto b) {
		String query = "insert into bigliettiacquistati " + "(dataEmissione,fila,posto,prezzo,idUser,idEvento) "
				+ "values(?,?,?,?,?,?)";
		return db.update(query,b.getDataEmissione(),b.getFila(), b.getPosto() + "", b.getPrezzo() + "", b.getUtente().get("id") + "",
				b.getEvento().getId() + "");
	}

	public boolean delete(int id) {
		String query = "delete from bigliettiacquistati where id=?";
		return db.update(query, id + "");
	}

	// cerco biglietti in base ad utente
	public Biglietto cercaIDperUtente(int id) {
		return read("select * from bigliettiacquistati where id=?", id + "").get(0);
	}

	public void addDate(int id) {
		db.update("update bigliettiAcquistati set dataEmissione = NOW() where id = ?", id + "");
	}
}
