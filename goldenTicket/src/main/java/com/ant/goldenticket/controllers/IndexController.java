package com.ant.goldenticket.controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOEvento;
import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.dao.DAOUtenti;
import com.ant.goldenticket.entities.Evento;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@Autowired
	ApplicationContext context;

	@Autowired
	DAOUtenti du;
	@Autowired
	DAOEvento de;
	@Autowired
	DAOLocalita dl;
	
//home
	@GetMapping("/")

	public String index(HttpSession session, Model model) {
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia=de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String,List<String>> sottog = new LinkedHashMap<>(); 
		Map<String,List<String>> zone = new LinkedHashMap<>(); 
		model.addAttribute("listazone", zone);
		model.addAttribute("eventi", de.eventiCasuali());
		for(String c : citta) {
			zone.put(c, dl.tutteLeZone(c));	
		}
		for(String g: tipologia) {
			sottog.put(g,de.listaGeneri(g));
		}
		model.addAttribute("listaSG",sottog);
		
		model.addAttribute("eventi", de.eventiCasuali());
		
		
		return "index.jsp";
	}

//se autenticato carrello, se no logga

//Utenti Controller
	@GetMapping("carrello")
	public String carrello(HttpSession session) {
		if (session.getAttribute("login") == null) // guardo se è autentificato
			return "redirect:formlogin";
		return "redirect:carrello.jsp";

	}

//[003]
//formlogin che reindirizza l'utente alla pagina di login
	@GetMapping("formlogin")
	public String formlogin() {
		return "formlogin.jsp";
	}

//[003]
//login
	@PostMapping("login")
	public String login(@RequestParam("username") String u, @RequestParam("password") String p, HttpSession session) {
		System.out.println("1");
		Map<String, String> ut = du.cercaPerNome(u);
		System.out.println(ut);
		if (ut != null) {
			System.out.println("1for");
			if (p.equalsIgnoreCase(ut.get("password"))) {
				session.setAttribute("login", "ok");
				session.setAttribute("username", u);
				session.setAttribute("password", p);
				session.setAttribute("id", ut.get("id"));
				session.setAttribute("ruolo", ut.get("ruolo"));
				System.out.println("done");
				return "redirect:/";
			} else
				return "redirect:formlogin";
		} else {
			return "redirect:formlogin";
		}

	}

	@GetMapping("logout") // tutto a null e ritorni ad home
	public String logout(HttpSession session) {
		session.setAttribute("login", null);
		session.setAttribute("username", null);
		session.setAttribute("password", null);
		session.setAttribute("id", null);
		session.setAttribute("ruolo", null);
		return "redirect:/";
	}

	public boolean checkSession(HttpSession session) {
		boolean ris = false;
		System.out.println("Login: " + session.getAttribute("login"));
		if (session.getAttribute("login") != null)
			ris = true;
		return ris;
	}

	
	
	

	@GetMapping("eventi")
	public String elencoeventi(HttpSession session, Model model) {
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia=de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String,List<String>> sottog = new LinkedHashMap<>(); 
		Map<String,List<String>> zone = new LinkedHashMap<>(); 
		model.addAttribute("listazone", zone);
		model.addAttribute("eventi", de.eventiCasuali());
		for(String c : citta) {
			zone.put(c, dl.tutteLeZone(c));	
		}
		for(String g: tipologia) {
			sottog.put(g,de.listaGeneri(g));
		}
		model.addAttribute("listaSG",sottog);
		
		model.addAttribute("eventi", de.readAll());
		return "eventi.jsp";
	}
	


	@GetMapping("dettagli")
	public String dettagli(@RequestParam("id") int idEvento, Model model) {
		
		Evento e = de.cercaPerID(idEvento);
		if (e == null)
			return "redirect:eventi";
		else {
			List<String> citta = dl.tutteLeCitta();
			List<String> tipologia=de.listaTipologia();
			model.addAttribute("listacitta", citta);
			model.addAttribute("listatipologia", tipologia);
			Map<String,List<String>> sottog = new LinkedHashMap<>(); 
			Map<String,List<String>> zone = new LinkedHashMap<>(); 
			model.addAttribute("listazone", zone);
			model.addAttribute("eventi", de.eventiCasuali());
			for(String c : citta) {
				zone.put(c, dl.tutteLeZone(c));	
			}
			for(String g: tipologia) {
				sottog.put(g,de.listaGeneri(g));
			}
			model.addAttribute("listaSG",sottog);
			model.addAttribute("evento", e);
			return "dettagli.jsp";
		}
	}
	@GetMapping("ricerca")
	public String ricerca(@RequestParam("search") String par, Model model) {
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia=de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String,List<String>> sottog = new LinkedHashMap<>(); 
		Map<String,List<String>> zone = new LinkedHashMap<>(); 
		model.addAttribute("listazone", zone);
		model.addAttribute("eventi", de.eventiCasuali());
		for(String c : citta) {
			zone.put(c, dl.tutteLeZone(c));	
		}
		for(String g: tipologia) {
			sottog.put(g,de.listaGeneri(g));
		}
		model.addAttribute("listaSG",sottog);
		
		model.addAttribute("lNome",de.readByNome(par));
		model.addAttribute("lArtista",de.readByArtista(par));
		model.addAttribute("lLocalita",de.readByCitta(par));
		return "ricerca.jsp";
	}

	
	@GetMapping("leggizone")
	public String elencozone(@RequestParam("citta") String cit, 
			@RequestParam("zona") String zon, Model model)
	{
  List<String> citta = dl.tutteLeCitta();
		List<String> tipologia=de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String,List<String>> sottog = new LinkedHashMap<>(); 
		Map<String,List<String>> zone = new LinkedHashMap<>(); 
		model.addAttribute("listazone", zone);
    	for(String c : citta) {
			zone.put(c, dl.tutteLeZone(c));	
		}
		for(String g: tipologia) {
			sottog.put(g,de.listaGeneri(g));
		}
		model.addAttribute("listaSG",sottog);
    
  model.addAttribute("eventi", de.cercaPerZona(cit, zon));
  return "leggizone.jsp";
}


	@GetMapping("leggitipologia")
	public String cercatipologia(@RequestParam("tipologia")String tipo,Model model)
	{
    List<String> citta = dl.tutteLeCitta();
		List<String> tipologia=de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String,List<String>> sottog = new LinkedHashMap<>(); 
		Map<String,List<String>> zone = new LinkedHashMap<>(); 
		model.addAttribute("listazone", zone);
    	for(String c : citta) {
			zone.put(c, dl.tutteLeZone(c));	
		}
		for(String g: tipologia) {
			sottog.put(g,de.listaGeneri(g));
		}
		model.addAttribute("listaSG",sottog);
  
    model.addAttribute("eventi", de.readBytipologia(tipo));
    return "leggitipologia.jsp";
	}


	@GetMapping("leggicitta")
	public String leggicitta(@RequestParam("citta") String par, Model model) {

		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia=de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String,List<String>> sottog = new LinkedHashMap<>(); 
		Map<String,List<String>> zone = new LinkedHashMap<>(); 
		model.addAttribute("listazone", zone);

		for(String c : citta) {
			zone.put(c, dl.tutteLeZone(c));	
		}
		for(String g: tipologia) {
			sottog.put(g,de.listaGeneri(g));
		}
		model.addAttribute("listaSG",sottog);
    
		model.addAttribute("risultatocitta", de.readByCitta(par));
		return "leggicitta.jsp";

	}
}
