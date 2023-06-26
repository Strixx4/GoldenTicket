package com.ant.goldenticket.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOEvento;
import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.dao.DAOUtenti;


import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ApplicationContext context;
	@Autowired
	DAOEvento de;
	@Autowired
	DAOLocalita dl;
	@Autowired
	DAOUtenti du;
	@GetMapping("admin/")
	public String index(HttpSession session, Model model) {
		
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
		model.addAttribute("eventi", de.eventiCasuali());
		
		return "/admin/adminindex.jsp";
	
		
	}
	@GetMapping("nouvoevento")
	public String nuovoevento(HttpSession session, Model model)
	{
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
		model.addAttribute("eventi", de.eventiCasuali());
		
		return "/admin/nuovoevento.jsp";
	}
	@GetMapping("nouvoartista")
	public String nuovoartista(HttpSession session, Model model)
	{
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
		model.addAttribute("eventi", de.eventiCasuali());
		
		return "/admin/nuovoartista.jsp";
	}
	@GetMapping("nouvolocalita")
	public String nuovolocalita(HttpSession session, Model model)
	{
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
		model.addAttribute("eventi", de.eventiCasuali());
		
		return "/admin/nuovolocalita.jsp";
	}
	@GetMapping("nouvouser")
	public String nuovouser(HttpSession session, Model model)
	{
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
		model.addAttribute("eventi", de.eventiCasuali());
		
		return "/admin/nuovouser.jsp";
	}
	@GetMapping("eventiadmin")
	public String elencoeventi(HttpSession session, Model model) {
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
		model.addAttribute("listaSG", sottog);

		model.addAttribute("eventi", de.readAll());
		model.addAttribute("controllologin", session.getAttribute("login"));
		return "/admin/eventiadmin.jsp";
	}
	@GetMapping("localita")
	public String elencolocalita(HttpSession session, Model model) {
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
		model.addAttribute("listaSG", sottog);

		model.addAttribute("eventi", de.readAll());
		model.addAttribute("controllologin", session.getAttribute("login"));
		return "/admin/localita.jsp";
	}
	@GetMapping("artisti")
	public String elencoartisti(HttpSession session, Model model) {
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
		model.addAttribute("listaSG", sottog);

		model.addAttribute("eventi", de.readAll());
		model.addAttribute("controllologin", session.getAttribute("login"));
		return "/admin/artisti.jsp";
	}
	@GetMapping("users")
	public String elencousers(HttpSession session, Model model) {
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
		model.addAttribute("listaSG", sottog);

		model.addAttribute("eventi", de.readAll());
		model.addAttribute("controllologin", session.getAttribute("login"));
		return "/admin/users.jsp";
	}
	
	@GetMapping("ricercaadmin")
	public String ricerca(@RequestParam("search") String par, Model model, HttpSession session) {
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
		model.addAttribute("listaSG", sottog);

		model.addAttribute("lNome", de.readByNome(par));
		model.addAttribute("lArtista", de.readByArtista(par));
		model.addAttribute("lLocalita", de.readByCitta(par));
		model.addAttribute("controllologin", session.getAttribute("login"));
		return "/admin/ricercaadmin.jsp";
	}
	
	
	
}
