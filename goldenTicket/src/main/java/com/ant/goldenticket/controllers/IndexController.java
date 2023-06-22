package com.ant.goldenticket.controllers;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOEvento;
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

//home
	@GetMapping("/")
	public String index(HttpSession session ,Model model) 
	{
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

//[002]
	@GetMapping("eventi")
	public String elencoeventi(HttpSession session, Model model) {
		model.addAttribute("eventi", de.readAll());
		return "eventi.jsp";
	}

//[001]
	@GetMapping("dettagli")
	public String dettagli(@RequestParam("id") int idEvento, Model model) {
		Evento e = de.cercaPerID(idEvento);
		if (e == null)
			return "redirect:eventi";
		else {
			model.addAttribute("evento", e);
			return "dettagli.jsp";
		}
	}
}
