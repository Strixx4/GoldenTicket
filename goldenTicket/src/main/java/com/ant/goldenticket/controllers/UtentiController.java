package com.ant.goldenticket.controllers;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.ant.goldenticket.dao.DAOUtenti;
import com.ant.goldenticket.entities.Biglietto;
import com.ant.goldenticket.entities.Evento;

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
	@Autowired
	private DAOUtenti du;
	@Autowired
	private ApplicationContext context;

	@GetMapping("carrello")
	public String carrello(HttpSession session, Model model) {
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
		if (!LoginController.checkSession(session)) {
			return "redirect:formlogin";
		} else {
			if (LoginController.checkAdmin(session)) {
				return "redirect:admin/";
			}
		}
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
		String data=LocalDate.now().toString();
		
		for (Biglietto b : carr) {
			Biglietto c = (Biglietto) context.getBean("creaBigliettoAcquistato",data, b.getFila(), b.getPosto(),
					b.getPrezzo(), b.getUtente(), b.getEvento());
			
			db.createAcquisto(c);
			dc.delete(b.getId());
			//String dataEmissione,String fila,int posto,double prezzo,Map<String,String> utente,Evento evento
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

	@GetMapping("rimborso")
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

	@GetMapping("aggiungiacarrello")
	public String AggiungiaCarrello(@RequestParam("id") int id, HttpSession session) {

		if (!LoginController.checkSession(session)) {
			return "redirect:formlogin";
		} else {
			if (LoginController.checkAdmin(session)) {
				return "redirect:admin/";
			}
		}

		Random r = new Random(); // da 65 a 90 lettere maiuscole
		Biglietto b = (Biglietto) context.getBean("creaBigliettoCarrello", filaCasuale(r.nextInt(0, 5)),
				r.nextInt(1,30), prezzo(r.nextInt(0, 10)),
				du.readByID(Integer.parseInt(session.getAttribute("id").toString())), de.cercaPerID(id));
		System.out.println("biglietto: " + b);
		dc.create(b);
		return "redirect:carrello";
	}

	private double prezzo(int nextInt) {
		return 5 * nextInt + 50.86;
	}

	private String filaCasuale(int c) {
		switch (c) {
		case 1:
			return "A";

		case 2:
			return "B";

		case 3:
			return "C";

		case 4:
			return "D";

		default:
			return "E";

		}
	}

}
