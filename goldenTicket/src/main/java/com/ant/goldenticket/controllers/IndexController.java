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

import com.ant.goldenticket.dao.DAOEvento;
import com.ant.goldenticket.dao.DAOLocalita;
import com.ant.goldenticket.entities.Evento;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@Autowired
	ApplicationContext context;
	@Autowired
	DAOEvento de;
	@Autowired
	DAOLocalita dl;

//home
	@GetMapping("/")

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
		model.addAttribute("listaSG", sottog);
		model.addAttribute("eventi", de.eventiCasuali());
		model.addAttribute("controllologin", session.getAttribute("login"));

		return "index.jsp";
	}

	@GetMapping("eventi")
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
		return "eventi.jsp";
	}

	@GetMapping("dettagli")
	public String dettagli(@RequestParam("id") int idEvento, Model model) {

		Evento e = de.cercaPerID(idEvento);
		if (e == null)
			return "redirect:eventi";
		else {
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

			model.addAttribute("evento", e);
			return "dettagli.jsp";
		}
	}

	@GetMapping("ricerca")
	public String ricerca(@RequestParam("search") String par, Model model) {
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
		return "ricerca.jsp";
	}

	@GetMapping("leggigenere")
	public String leggiGenere(@RequestParam("genere") String g, @RequestParam("tipologia") String c, Model model) {
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia = de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String, List<String>> sottog = new LinkedHashMap<>();
		Map<String, List<String>> zone = new LinkedHashMap<>();
		model.addAttribute("listazone", zone);
		model.addAttribute("eventi", de.eventiCasuali());
		for (String d : citta) {
			zone.put(d, dl.tutteLeZone(d));
		}
		for (String e : tipologia) {
			sottog.put(e, de.listaGeneri(e));
		}
		model.addAttribute("listaSG", sottog);

		model.addAttribute("lista", de.readBygenere(c, g));
		return "leggigenere.jsp";
	}

	@GetMapping("leggizone")
	public String elencozone(@RequestParam("citta") String cit, @RequestParam("zona") String zon, Model model) {
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia = de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String, List<String>> sottog = new LinkedHashMap<>();
		Map<String, List<String>> zone = new LinkedHashMap<>();
		model.addAttribute("listazone", zone);
		for (String c : citta) {
			zone.put(c, dl.tutteLeZone(c));
		}
		for (String g : tipologia) {
			sottog.put(g, de.listaGeneri(g));
		}
		model.addAttribute("listaSG", sottog);

		model.addAttribute("eventi", de.cercaPerZona(cit, zon));
		return "leggizone.jsp";
	}

	@GetMapping("leggitipologia")
	public String cercatipologia(@RequestParam("tipologia") String tipo, Model model) {
		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia = de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String, List<String>> sottog = new LinkedHashMap<>();
		Map<String, List<String>> zone = new LinkedHashMap<>();
		model.addAttribute("listazone", zone);
		for (String c : citta) {
			zone.put(c, dl.tutteLeZone(c));
		}
		for (String g : tipologia) {
			sottog.put(g, de.listaGeneri(g));
		}
		model.addAttribute("listaSG", sottog);

		model.addAttribute("eventi", de.readBytipologia(tipo));
		return "leggitipologia.jsp";
	}

	@GetMapping("leggicitta")
	public String leggicitta(@RequestParam("citta") String par, Model model) {

		List<String> citta = dl.tutteLeCitta();
		List<String> tipologia = de.listaTipologia();
		model.addAttribute("listacitta", citta);
		model.addAttribute("listatipologia", tipologia);
		Map<String, List<String>> sottog = new LinkedHashMap<>();
		Map<String, List<String>> zone = new LinkedHashMap<>();
		model.addAttribute("listazone", zone);

		for (String c : citta) {
			zone.put(c, dl.tutteLeZone(c));
		}
		for (String g : tipologia) {
			sottog.put(g, de.listaGeneri(g));
		}
		model.addAttribute("listaSG", sottog);

		model.addAttribute("risultatocitta", de.readByCitta(par));
		return "leggicitta.jsp";

	}
}
