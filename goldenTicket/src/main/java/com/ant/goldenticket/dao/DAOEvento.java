package com.ant.goldenticket.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.goldenticket.entities.Artista;
import com.ant.goldenticket.entities.Evento;

public class DAOEvento {
	@Autowired
	private Database db;
	@Autowired
	private DAOArtista da;
	@Autowired
	private DAOLocalita dl;

	@Autowired
	private ApplicationContext context;

	public List<Evento> read(String query, String... strings) {
		List<Evento> ris = new ArrayList<>();
		List<Map<String, String>> list = db.rows(query, strings);
		for (Map<String, String> m : list) {
			List<Artista> a = new ArrayList<>();
			List<Map<String, String>> la = db.rows("select idArtista from associativa where idEvento = ?", m.get("id"));
			for (Map<String, String> ma : la) {
				a.add(da.cercaPerId(Integer.parseInt(ma.get("idArtista"))));
			}

			Evento e = context.getBean(Evento.class, m, a, dl.cercaPerId((Integer.parseInt(m.get("idLocalita")))));
			ris.add(e);
		}

		return ris;
	}

	public List<Evento> readAll() {
		return read("select * from eventi");
	}

	public boolean delete(int id) {
		String query = "delete from eventi where id=?";
		return db.update(query, id + "");
	}

	public void create(Evento e) {

		String query = "insert into eventi(tipologia,genere,data,ora,giornoSettimana,locandina,idLocalita) values(?,?,?,?,?,?,?) ";

		System.out.println(query + " " + db.update(query, e.getTipologia(), e.getGenere(), e.getData(), e.getOra(),
				e.getGiornoSettimana() + "", e.getLocandina(), e.getLocalita().getId() + ""));
		for (Artista a : e.getArtisti()) {
			System.out.println("insert into associativa (idArtista,idEvento) values(?,?): " + db.update(
					"insert into associativa (idArtista,idEvento) values(?,?)", a.getId() + "", e.getId() + ""));
		}
	}

	public void update(Evento e) {
		String query = "update eventi "
				+ "set tipologia=?,genere=?,data=?,ora=?.giornoSettimana=?,locandina=?,idLocalita=? " + "where id=?";
		System.out.println(query + " " + db.update(query, e.getTipologia(), e.getGenere(), e.getData(), e.getOra(),
				e.getGiornoSettimana() + "", e.getLocandina(), e.getLocalita().getId() + "", e.getId() + ""));

		System.out.println("delete from associativa where idEvento=?"
				+ db.update("delete from associativa where idEvento=?" + e.getId()));

		for (Artista a : e.getArtisti()) {

			System.out.println("insert into associativa (idArtista,idEvento) values(?,?): " + db.update(
					"insert into associativa (idArtista,idEvento) values(?,?)", a.getId() + "", e.getId() + ""));
		}
	}

	public Evento cercaPerID(int id) {
		return read("select * from eventi where id = ?", id + "").get(0);
	}

	public List<Evento> cercaPerZona(String citta, String zona) {
		return read(
				"select * from eventi inner join localita on eventi.idLocalita="
				+ "localita.id  where localita.citta like \"%"+citta+"%\" and localita.zona "
				+ "like \"%"+zona+"%\" order by eventi.data;");
	}

	public List<String> listaTipologia() {
		List<Map<String, String>> l = db.rows("select tipologia from eventi group by tipologia");
		List<String> ris = new ArrayList<>();
		for (Map<String, String> m : l) {
			ris.add(m.get("tipologia"));
		}
		return ris;
	}

	public List<String> listaGeneri(String tipologia) {
		List<Map<String, String>> l = db.rows("select distinct genere from eventi where tipologia LIKE ?", tipologia);
		List<String> ris = new ArrayList<>();
		for (Map<String, String> m : l) {
			ris.add(m.get("genere"));
		}
		return ris;
	}

	public List<Evento> readBygenere(String tipologia, String genere) {
		return read("select * from eventi where tipologia = ? and genere = ?", tipologia, genere);
	}
	public List<Evento> readBytipologia(String tipologia)
	{
		return read("select* from eventi where tipologia=?",tipologia);
	}
	public List<Evento> eventiCasuali() {
		return read("select * from eventi order by rand() limit 8");
	}

	public List<Evento> readByNome(String nome) {
		return read("select * from eventi where nome like \"%"+nome+"%\"" );
	}
	public List<Evento> readByArtista(String nome){
		List<Evento> l = readAll();
		List<Evento> ris = new ArrayList<>();
		for(Evento e : l) {
			for(Artista a : e.getArtisti()) {
				if(a.getNominativo().toLowerCase().contains(nome.toLowerCase())) {
					ris.add(e);
					continue;
				}
			}
		}
		return ris;
	}
	
	public List<Evento> readByCitta(String par) {
		List<Evento> l = readAll();
		List<Evento> ris = new ArrayList<>();
		for(Evento e : l) {
			if(e.getLocalita().getCitta().toLowerCase().contains(par.toLowerCase())) {
				ris.add(e);
			}
		}
		return ris;
	}

}
