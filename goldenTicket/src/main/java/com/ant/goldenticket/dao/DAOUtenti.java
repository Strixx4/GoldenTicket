package com.ant.goldenticket.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class DAOUtenti {
	@Autowired
	private Database db;
	
	public List<Map<String,String>> readAll(){
		return db.rows("select * from utenti");
	}
	
	public Map<String,String> readByID(int id){
		return db.row("select * from utenti where id=?",id+"");
	}
	public boolean create(Map<String,String> u) {
		String query="update utenti set username = ? , password = ? , ruolo = ? where id = ?";
		
		return db.update(query, u.get("username"),u.get("password"),u.get("ruolo"),u.get("id"));
	}
}
