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
}
