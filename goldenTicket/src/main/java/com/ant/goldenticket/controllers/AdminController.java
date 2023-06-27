package com.ant.goldenticket.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOArtista;
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
	DAOArtista da;
	@Autowired
	DAOUtenti du;
	
	@GetMapping("/")
	public String indexadmin(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		return "adminindex.jsp";	
	}
	@GetMapping("formnuovoevento")
	public String nuovoevento(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovoevento.jsp";
	}
	@GetMapping("formnuovoartista")
	public String nuovoartista(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovoartista.jsp";
	}
	@GetMapping("formnuovolocalita")
	public String nuovolocalita(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovolocalita.jsp";
	}
	@GetMapping("formnuovouser")
	public String nuovouser(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovouser.jsp";
	}
	@GetMapping("listaeventi")
	public String elencoeventi(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listaeventi", de.readAll());
		return "listaeventi.jsp";
	}
	@GetMapping("listalocalita")
	public String elencolocalita(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listalocalita", dl.readAll());
		return "listalocalita.jsp";
	}
	@GetMapping("listaartisti")
	public String elencoartisti(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listaartisti", da.readAll());
		return "/admin/listaartisti.jsp";
	}
	@GetMapping("listauser")
	public String elencousers(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listauser", du.readAll());
		return "listausers.jsp";
	}
	
	@GetMapping("ricercaadmin")
	public String ricerca(@RequestParam("search") String par, Model model, HttpSession session) {
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("lNome", de.readByNome(par));
		model.addAttribute("lArtista", de.readByArtista(par));
		model.addAttribute("lLocalita", de.readByCitta(par));
		return "ricercaadmin.jsp";
	}
}
