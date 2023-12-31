package com.ant.goldenticket.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class DAOUtenti {
	@Autowired
	private Database db;

	public List<Map<String, String>> readAll() {
		return db.rows("select * from utenti");
	}

	public Map<String, String> readByID(int id) {
		return db.row("select * from utenti where id=?", id + "");
	}

	public boolean update(Map<String, String> u) {
		String query = "update utenti set username = ?, password = ? where id = ?";
		return db.update(query, u.get("username"), u.get("password"), u.get("id"));
	}

	public boolean delete(int id) {
		return db.update("delete from utenti where id = ?", id + "");
	}

	// I controlli saranno messi in controller
	public boolean create(String u, String p, String r) {
		String query = "insert into utenti (username,password,ruolo) values (?,?,?)";
		return db.update(query, u,p,r);
	}

	public Map<String, String> cercaPerNome(String nome) {
		return db.row("select * from utenti where username = ?", nome);
	}
	public boolean updateByNome(Map<String, String> u) {
		String query = "update utenti set password =? where username=? and id>0";
		return db.update(query, u.get("password"), u.get("username"));
	}
}
