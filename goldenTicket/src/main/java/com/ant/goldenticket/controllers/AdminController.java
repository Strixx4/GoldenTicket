package com.ant.goldenticket.controllers;

import java.util.ArrayList;
import java.util.List;
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
import com.ant.goldenticket.entities.Artista;
import com.ant.goldenticket.entities.Evento;
import com.ant.goldenticket.entities.Localita;

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
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "adminindex.jsp";
	}

	@GetMapping("formnuovoevento")
	public String formnuovoevento(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovoevento.jsp";
	}

	@GetMapping("nuovoevento")
	public String nuovoevento(HttpSession session, @RequestParam Map<String, String> params) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		Localita l = dl.cercaPerLocalita(params.get("zona"), params.get("zona"));
		List<Artista> ar = new ArrayList<>();
		String[] a = params.get("artisti").split(",");
		for (String s : a) {
			ar.add(da.cercaPerNominativo(s));
		}
		Evento e = context.getBean(Evento.class,params,ar,l);
		de.create(e);
		return "redirect:listaeventi";
	}

	@GetMapping("formnuovoartista")
	public String formnuovoartista(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovoartista.jsp";
	}

	@GetMapping("nuovoartista")
	public String nuovoartista(@RequestParam Map<String, String> m, HttpSession session) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";

		Artista a = context.getBean(Artista.class, m);
		da.create(a);
		return "redirect:listaartisti";
	}

	@GetMapping("formnuovolocalita")
	public String nuovolocalita(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovolocalita.jsp";
	}

	@GetMapping("formnuovouser")
	public String nuovouser(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovouser.jsp";
	}

	@GetMapping("nuovouser")
	public String nuovouser(@RequestParam Map<String, String> m, HttpSession session) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";

		du.create(m.get("username"), m.get("password"), "admin");
		return "redirect:listauser";
	}

	@GetMapping("listaeventi")
	public String elencoeventi(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listaeventi", de.readAll());
		return "listaeventi.jsp";
	}

	@GetMapping("listalocalita")
	public String elencolocalita(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listalocalita", dl.readAll());
		return "listalocalita.jsp";
	}

	@GetMapping("listaartisti")
	public String elencoartisti(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listaartisti", da.readAll());
		return "/admin/listaartisti.jsp";
	}

	@GetMapping("listauser")
	public String elencousers(HttpSession session, Model model) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listauser", du.readAll());
		return "listausers.jsp";
	}

	@GetMapping("ricercaadmin")
	public String ricerca(@RequestParam("search") String par, Model model, HttpSession session) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("lNome", de.readByNome(par));
		model.addAttribute("lArtista", de.readByArtista(par));
		model.addAttribute("lLocalita", de.readByCitta(par));
		return "ricercaadmin.jsp";
	}

	@GetMapping("eliminaevento")
	public String cancellaevento(@RequestParam("id") int idEvento, HttpSession session) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		de.delete(idEvento);
		return "redirect:/admin/";
	}

	@GetMapping("eliminaartista")
	public String cancellaartista(@RequestParam("id") int idArtista, HttpSession session) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		da.delete(idArtista);
		return "redirect:/admin/";
	}

	@GetMapping("eliminalocalita")
	public String cancellalocalita(@RequestParam("id") int idLocalita, HttpSession session) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		dl.delete(idLocalita);
		return "redirect:/admin/";
	}

	@GetMapping("eliminauser")
	public String cancellauser(@RequestParam("id") int idUser, HttpSession session) {
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		du.delete(idUser);
		return "redirect:/admin/";
	}
	
	@PostMapping("modificauser")
	public String modificaUtente(@RequestParam Map<String,String> inputs)
	{
		du.update(inputs);
			return "redirect:listausers";
	}

	@GetMapping("modificaartista")
	public String formmodificaArtista(@RequestParam Map<String,String> inputs){
	   Artista a = context.getBean(Artista.class,inputs);
		da.update(a);
			return "redirect:listaartisti";
		}

	@GetMapping("modificaevento")
	public String formmodificaEvento(@RequestParam Map <String,String> inputs){
		   List <Artista> la = new ArrayList<Artista>(); //lista di artisti
		   String [] sa = inputs.get("artisti").split(","); //splittiamo gli artisti con la virgola e li mettiamo in un array di Stringhe
		   for (String a:sa) { //ciclo for per riempire la lista di singoli nomi di artisti
			   la.add(da.cercaPerNominativo(a));
		   }
		   	dl.cercaPerLocalita(inputs.get("zona"), inputs.get("citta"));
		    Evento e = context.getBean(Evento.class,inputs,la,dl);
			de.update(e);
			return "redirect:listaeventi";
			}

	@GetMapping("modificalocalita")
	public String formmodificaLocalita(@RequestParam Map <String,String> inputs) {
		Localita l = context.getBean(Localita.class,inputs);
		dl.update(l);
		return "redirect:listalocalita";

	}
}
