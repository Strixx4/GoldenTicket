package com.ant.goldenticket.controllers;

import javax.servlet.http.HttpSession;

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

@Controller
public class IndexController {
	
@Autowired
ApplicationContext context;

@Autowired
DAOUtenti du;
DAOEvento de;

//home
@GetMapping("/")
public String index(HttpSession session)
{ 
	return "index.jsp";
 }


//se autenticato carrello, se no logga
@GetMapping("carrello")
public String carrello (HttpSession session) {
	if (session.getAttribute("login") == null) //guardo se è autentificato
			return "redirect:formlogin";
	return "redirect:carrello.jsp";
	
}

//formlogin che reindirizza l'utente alla pagina di login
@GetMapping("formlogin")
public String formlogin() {
	return "login.jsp";
}

//login
@PostMapping("login")
public String login (@RequestParam("user") String u,
					 @RequestParam("password") String p,
					 HttpSession session) {
	
	return null;
}


@GetMapping("logout") //tutto a null e ritorni ad home
public String logout(HttpSession session)
{
	session.setAttribute("login", null);
	session.setAttribute("login",null);
	session.setAttribute("login", null);
	return "redirect:index.jsp";
	}



public boolean checkSession(HttpSession session)
{
	boolean ris = false;
	System.out.println("Login: " + session.getAttribute("login"));
	if(session.getAttribute("login") != null)
		ris = true;
	return ris;
}

@GetMapping("eventi")
public String elencoeventi (HttpSession session, Model model)
{
	model.addAttribute("eventi", de.readAll());
	return "eventi.jsp";
	}


@GetMapping ("dettagli") 
public String dettagli (@RequestParam("id") int idEvento, Model model) {
	Evento e = de.cercaPerID(idEvento);
	if (e == null)
		return "redirect:eventi";
	else {
		model.addAttribute("evento",e);
		return "dettaglievento.jsp";
	}
}
}
