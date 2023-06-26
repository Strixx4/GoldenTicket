package com.ant.goldenticket.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOBigliettoAcquistato;
import com.ant.goldenticket.dao.DAOCarrello;
import com.ant.goldenticket.dao.DAOEvento;
import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.entities.Biglietto;

import jakarta.servlet.http.HttpSession;

@Controller
public class UtentiController {
	@Autowired
	private DAOCarrello dc;
	@Autowired
	private DAOBigliettoAcquistato db;
	@Autowired
	private DAOEvento de;
	@Autowired
	private DAOLocalita dl;

	@GetMapping("carrello")
	public String carrello(HttpSession session, Model model) {
		if (!LoginController.checkSession(session)) {
			return "redirect:formlogin";
		} else {
			if (LoginController.checkAdmin(session)) {
				return "redirect:admin/";
			}
		}
		
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia = de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String, List<String>> sottog = new LinkedHashMap<>();
		Map<String, List<String>> zone = new LinkedHashMap<>();
		model.addAttribute("listazone", zone);
		model.addAttribute("eventi", de.eventiCasuali());
		for (String c : citta) {
			zone.put(c, dl.tutteLeZone(c));
		}
		for (String g : tipologia) {
			sottog.put(g, de.listaGeneri(g));
		}
		model.addAttribute("controllologin", session.getAttribute("login"));
		model.addAttribute("listaSG", sottog);

		model.addAttribute("listabiglietti", dc.readAll(Integer.parseInt(session.getAttribute("id").toString())));
		return "carrello.jsp";

	}

	@GetMapping("eliminadacarrello")
	public String eliminaDaCarrello(@RequestParam("id") int id, HttpSession session) {
		if (!LoginController.checkSession(session)) {
			return "redirect:formlogin";
		} else {
			if (LoginController.checkAdmin(session)) {
				return "redirect:admin/";
			}
		}
		dc.delete(id);
		return "redirect:carrello";
	}

	@GetMapping("checkout")
	public String checkout(HttpSession session) {
		if (!LoginController.checkSession(session)) {
			return "redirect:formlogin";
		} else {
			if (LoginController.checkAdmin(session)) {
				return "redirect:admin/";
			}
		}
		List<Biglietto> carr = dc.readAll(Integer.parseInt(session.getAttribute("id").toString()));
		for (Biglietto b : carr) {
			db.create(b);
			db.delete(b.getId());
		}
		return "redirect:acquisti";
	}

	@GetMapping("acquisti")
	public String bigliettiAcquistati(HttpSession session, Model model) {
		
		
		if (!LoginController.checkSession(session)) {
			return "redirect:formlogin";
		} else {
			if (LoginController.checkAdmin(session)) {
				return "redirect:admin/";
			}
		}
		
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia = de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String, List<String>> sottog = new LinkedHashMap<>();
		Map<String, List<String>> zone = new LinkedHashMap<>();
		model.addAttribute("listazone", zone);
		model.addAttribute("eventi", de.eventiCasuali());
		for (String c : citta) {
			zone.put(c, dl.tutteLeZone(c));
		}
		for (String g : tipologia) {
			sottog.put(g, de.listaGeneri(g));
		}
		model.addAttribute("controllologin", session.getAttribute("login"));
		model.addAttribute("listaSG", sottog);
		
		model.addAttribute("listabiglietti", db.readAll(Integer.parseInt(session.getAttribute("id").toString())));
		return "acquisti.jsp";
	}

	@GetMapping("rimbosrso")
	public String rimborso(HttpSession session, @RequestParam("id") int id) {
		if (!LoginController.checkSession(session)) {
			return "redirect:formlogin";
		} else {
			if (LoginController.checkAdmin(session)) {
				return "redirect:admin/";
			}
		}
		db.delete(id);
		return "redirect:acquisti";
	}
}
