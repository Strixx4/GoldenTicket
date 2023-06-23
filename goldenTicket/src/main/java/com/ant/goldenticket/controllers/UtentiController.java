package com.ant.goldenticket.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOBigliettoAcquistato;
import com.ant.goldenticket.dao.DAOCarrello;
import com.ant.goldenticket.entities.Biglietto;

import jakarta.servlet.http.HttpSession;

@Controller
public class UtentiController {
	@Autowired
	private DAOCarrello dc;
	@Autowired
	private DAOBigliettoAcquistato db;
	
	@GetMapping("carrello")
	public String carrello(HttpSession session,Model model) {
		if (session.getAttribute("login") == null && !session.getAttribute("ruolo").toString().equals("utente")) // guardo se è autentificato come utente
			return "redirect:formlogin";
		
		model.addAttribute("listabiglietti",dc.readAll(Integer.parseInt(session.getAttribute("id").toString())));
		return "carrello.jsp";
	}
	@GetMapping("eliminadacarrello")
	public String eliminaDaCarrello(@RequestParam("id") int id,HttpSession session) {
		if (session.getAttribute("login") == null && !session.getAttribute("ruolo").toString().equals("utente")) // guardo se è autentificato come utente
			return "redirect:formlogin";
		dc.delete(id);
		return "redirect:carrello";
	}
	@GetMapping("checkout")
	public String checkout(HttpSession session) {
		if (session.getAttribute("login") == null && !session.getAttribute("ruolo").toString().equals("utente")) // guardo se è autentificato come utente
			return "redirect:formlogin";
		List<Biglietto> carr = dc.readAll(Integer.parseInt(session.getAttribute("id").toString()));
		for(Biglietto b : carr) {
			db.create(b);
			db.delete(b.getId());
		}
		return "redirect:acquistati";
	}
	@GetMapping("acquistati")
	public String bigliettiAcquistati(HttpSession session,Model model) {
		if (session.getAttribute("login") == null && !session.getAttribute("ruolo").toString().equals("utente")) // guardo se è autentificato come utente
			return "redirect:formlogin";
		model.addAttribute("listabiglietti",db.readAll(Integer.parseInt(session.getAttribute("id").toString())));
		return "acquistati.jsp";
	}
	@GetMapping("rimbosrso")
	public String rimborso(HttpSession session,@RequestParam("id") int id) {
		if (session.getAttribute("login") == null && !session.getAttribute("ruolo").toString().equals("utente")) // guardo se è autentificato come utente
			return "redirect:formlogin";
		db.delete(id);
		return "redirect:acquistati";
	}
}
