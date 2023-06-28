package com.ant.goldenticket.controllers;

<<<<<<< Updated upstream
import java.util.*;
=======
import java.util.Map;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
import com.ant.goldenticket.entities.Artista;
=======
>>>>>>> Stashed changes
import com.ant.goldenticket.entities.Evento;

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
<<<<<<< Updated upstream
	@GetMapping("nuovoevento")
	public String aggiungiEvento(@RequestParam Map<String,String> m, HttpSession session){
=======

	@GetMapping("nuovoevento")
	public String modificaevento(HttpSession session, @RequestParam Map<String,String> params)
	{
>>>>>>> Stashed changes
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		
		return "redirect:listaeventi";
	}


	@GetMapping("formnuovoartista")
	public String formnuovoartista(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovoartista.jsp";
	}
<<<<<<< Updated upstream
	@GetMapping("nuovoartista")
	public String nuovoartista(@RequestParam Map<String,String> m, HttpSession session){
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";

		Artista a = context.getBean(Artista.class, m);
		de.create(e);
		return "redirect:listaartisti";
	}
=======

>>>>>>> Stashed changes
	@GetMapping("formnuovolocalita")
	public String nuovolocalita(HttpSession session, Model model)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovolocalita.jsp";
	}
	@GetMapping("nuovalocalita")
	public String nuovoartista(@RequestParam Map<String,String> m, HttpSession session){
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";

		Localita a = context.getBean(Localita.class, m);
		de.create(e);
		return "redirect:listalocalita";
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
	@GetMapping("nuovouser")
	public String nuovoartista(@RequestParam Map<String,String> m, HttpSession session){
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";

		du.create(m.get("username"), m.get("password"), "admin");
		return "redirect:listauser";
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
	@GetMapping("eliminaevento")
	public String cancellaevento(@RequestParam("id") int idEvento, HttpSession session)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		de.delete(idEvento);
		return "redirect:/admin/";
	}
	@GetMapping("eliminaartista")
	public String cancellaartista(@RequestParam("id") int idArtista, HttpSession session)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		da.delete(idArtista);
		return "redirect:/admin/";
	}
	@GetMapping("eliminalocalita")
	public String cancellalocalita(@RequestParam("id") int idLocalita, HttpSession session)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		dl.delete(idLocalita);
		return "redirect:/admin/";
	}
	@GetMapping("eliminauser")
	public String cancellauser(@RequestParam("id") int idUser, HttpSession session)
	{
		if(!LoginController.checkSession(session))
			return"redirect:/";
		if(!LoginController.checkAdmin(session))
			return "redirect:/";
		du.delete(idUser);
		return "redirect:/admin/";
	}
	
}
