package com.ant.goldenticket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		return "/admin/adminindex.jsp";	
	}
	@GetMapping("formnuovoevento")
	public String nuovoevento(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		return "/admin/formnuovoevento.jsp";
	}
	@GetMapping("formnuovoartista")
	public String nuovoartista(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		return "/admin/formnuovoartista.jsp";
	}
	@GetMapping("formnuovolocalita")
	public String nuovolocalita(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		return "/admin/formnuovolocalita.jsp";
	}
	@GetMapping("formnuovouser")
	public String nuovouser(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		return "/admin/formnuovouser.jsp";
	}
	@GetMapping("listaeventi")
	public String elencoeventi(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		model.addAttribute("listaeventi", de.readAll());
		return "/admin/listaeventi.jsp";
	}
	@GetMapping("listalocalita")
	public String elencolocalita(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		model.addAttribute("listalocalita", dl.readAll());
		return "/admin/listalocalita.jsp";
	}
	@GetMapping("listaartisti")
	public String elencoartisti(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		model.addAttribute("listaartisti", da.readAll());
		return "/admin/listaartisti.jsp";
	}
	@GetMapping("listauser")
	public String elencousers(HttpSession session, Model model) {
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		model.addAttribute("listauser", du.readAll());
		return "/admin/listausers.jsp";
	}
	
	@GetMapping("ricercaadmin")
	public String ricerca(@RequestParam("search") String par, Model model, HttpSession session) {
		if(!LoginController.checkSession(session))
			return"redirect:formlogin";
		if(!LoginController.checkAdmin(session))
			return"redirect:/";
		model.addAttribute("lNome", de.readByNome(par));
		model.addAttribute("lArtista", de.readByArtista(par));
		model.addAttribute("lLocalita", de.readByCitta(par));
		return "/admin/ricercaadmin.jsp";
	}
	
	
	
}
