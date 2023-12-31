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
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "adminindex.jsp";
	}

	// ----------------------------EVENTI----------------------------

	@GetMapping("formnuovoevento")
	public String formnuovoevento(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovoevento.jsp";
	}

	@GetMapping("nuovoevento")
	public String nuovoevento(HttpSession session, @RequestParam Map<String, String> params) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		Localita l = dl.cercaPerLocalita(params.get("zona"), params.get("citta"));
		List<Artista> ar = new ArrayList<>();
		String[] a = params.get("iArtisti").split(",");
		for (String s : a) {
			Artista p = da.cercaPerNominativo(s);
			ar.add(p);
		}
		if (l == null || ar.size() <= 0)
			return "redirect:formnuovoevento";
		Evento e = context.getBean(Evento.class, params, ar, l);
		if (checkEvento(e, l, ar))
			de.create(e);
		return "redirect:listaeventi";
	}

	@GetMapping("listaeventi")
	public String elencoeventi(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listaeventi", de.readAll());
		return "listaeventi.jsp";
	}

	@GetMapping("eliminaevento")
	public String cancellaevento(@RequestParam("id") int idEvento, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		de.delete(idEvento);
		return "redirect:listaeventi";
	}

	@GetMapping("formmodificaevento")
	public String formModificaEvento(HttpSession session, @RequestParam("id") int id, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("evento", de.cercaPerID(id));
		return "formmodificaevento.jsp";
	}

	@GetMapping("modificaevento")
	public String formmodificaEvento(@RequestParam Map<String, String> inputs, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		List<Artista> la = new ArrayList<Artista>(); // lista di artisti
		String[] sa = inputs.get("iArtisti").split(","); // splittiamo gli artisti con la virgola e li mettiamo in un
															// array di Stringhe
		for (String a : sa) { // ciclo for per riempire la lista di singoli nomi di artisti
			la.add(da.cercaPerNominativo(a));
		}
		Localita l = dl.cercaPerLocalita(inputs.get("zona"), inputs.get("citta"));
		if (l == null || la.size() <= 0)
			return "redirect:formmodificaevento";
		Evento e = context.getBean(Evento.class, inputs, la, l);
		if (checkEvento(e, l, la))
			de.update(e);
		return "redirect:listaeventi";
	}

	private boolean checkEvento(Evento e, Localita l, List<Artista> a) {
		boolean ris = true;
		// controllo data

		if (e.getNome().length() < 1 || e.getNome().length() > 100)
			return false;
		if (e.getTipologia().length() < 1 || e.getTipologia().length() > 40)
			return false;
		if (e.getGenere().length() < 1 || e.getGenere().length() > 30)
			return false;
		if (e.getData().length() != 10)
			return false;
		if (e.getOra().length() < 1 || e.getOra().length() > 10)
			return false;
		if (e.getGiornoSettimana().length() < 1 || e.getGiornoSettimana().length() > 30)
			return false;
		if (e.getLocandina().length() < 1 || e.getLocandina().length() > 300)
			return false;
		if (l == null)
			return false;
		if (a == null)
			return false;
		if (a.size() == 0)
			return false;
		return ris;
	}

	// ----------------------------ARTISTA----------------------------
	@GetMapping("formnuovoartista")
	public String formnuovoartista(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovoartista.jsp";
	}

	@GetMapping("formmodificaartista")
	public String formmodificaartista(HttpSession session, Model model, @RequestParam("id") int idArtista) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("artista", da.cercaPerId(idArtista));
		return "formmodificaartista.jsp";
	}

	@GetMapping("nuovoartista")
	public String nuovoartista(@RequestParam Map<String, String> m, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		Artista a = context.getBean(Artista.class, m);
		if (checkArtisti(a)) {
			da.create(a);
		}
		return "redirect:listaartisti";
	}

	@GetMapping("eliminaartista")
	public String cancellaartista(@RequestParam("id") int idArtista, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		da.delete(idArtista);
		return "redirect:listaartisti";
	}

	@GetMapping("modificaartista")
	public String modificaArtista(@RequestParam Map<String, String> inputs, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		Artista a = context.getBean(Artista.class, inputs);
		if (checkArtisti(a)) {
			da.update(a);
		}
		return "redirect:listaartisti";
	}

	@GetMapping("listaartisti")
	public String elencoartisti(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listaartisti", da.readAll());
		return "listaartisti.jsp";
	}

	private boolean checkArtisti(Artista a) {
		if (a.getNominativo().length() == 0 || a.getNominativo().length() > 100) {
			return false;
		}
		return true;
	}

	// '--------------------------------LOCALITA'--------------------------------
	@GetMapping("formnuovolocalita")
	public String nuovolocalita(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		return "formnuovolocalita.jsp";
	}

	@GetMapping("nuovolocalita")
	public String nuovolocalita(@RequestParam Map<String, String> m, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		Localita l = context.getBean(Localita.class, m);
		if (checkLocalita(l))
			dl.create(l);
		return "redirect:listalocalita";
	}

	@GetMapping("eliminalocalita")
	public String cancellalocalita(@RequestParam("id") int idLocalita, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		dl.delete(idLocalita);
		return "redirect:listalocalita";
	}

	@PostMapping("modificalocalita")
	public String formmodificaLocalita(@RequestParam Map<String, String> inputs, HttpSession session) {
		session.setAttribute("url", "/");

		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";

		Localita l = context.getBean(Localita.class, inputs);
		if (checkLocalita(l))
			dl.update(l);
		return "redirect:listalocalita";
	}

	@GetMapping("formmodificalocalita")
	public String formmodificalocalita(@RequestParam("id") int idLocalita, HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		Localita l = dl.cercaPerId(idLocalita);
		model.addAttribute("localita", l);
		return "formmodificalocalita.jsp";
	}

	@GetMapping("listalocalita")
	public String elencolocalita(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listalocalita", dl.readAll());
		return "listalocalita.jsp";

	}

	private boolean checkLocalita(Localita l) {
		if (l.getCitta().length() < 1 && l.getCitta().length() > 50)
			return false;
		if (l.getZona().length() < 1 && l.getZona().length() > 20)
			return false;
		if (l.getPosti() < 0)
			return false;
		if (l.getIndirizzo().length() < 1 && l.getIndirizzo().length() > 100)
			return false;
		
		return true;

	}

	// '--------------------------------USER'--------------------------------
	@GetMapping("formnuovouser")
	public String nuovouser(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";

		return "formnuovouser.jsp";
	}

	@GetMapping("nuovouser")
	public String nuovouser(@RequestParam Map<String, String> m, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		if (du.cercaPerNome(m.get("username")) == null) {
			if (LoginController.checkData(m.get("username"), m.get("password")))
				du.create(m.get("username"), m.get("password"), "admin");
			return "redirect:listauser";
		} else
			return "redirect:formnuovouser";
	}

	@GetMapping("formmodificauser")
	public String formmodificauser(HttpSession session, Model model, @RequestParam("id") int idUser) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("user", du.readByID(idUser));
		return "formmodificauser.jsp";
	}

	@PostMapping("modificauser")
	public String modificaUtente(@RequestParam Map<String, String> inputs, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		
		if (du.cercaPerNome(inputs.get("username")) == null) {
			System.out.println("ricerca == null");
			if (LoginController.checkData(inputs.get("username"), inputs.get("password"))) {
				System.out.println("Dati accettati");
				du.update(inputs);}
			return "redirect:listauser";
		} else {
			if (du.readByID(Integer.parseInt(inputs.get("id"))).get("username").equals(inputs.get("username"))) {
				if (LoginController.checkData(inputs.get("username"), inputs.get("password")))
					du.update(inputs);

				return "redirect:listauser";
			} else {
				System.out.println("!=");
				return "redirect:listauser";
			}
		}
	}

	@GetMapping("eliminauser")
	public String cancellauser(@RequestParam("id") int idUser, HttpSession session) {
		session.setAttribute("url", "/");

		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		du.delete(idUser);
		return "redirect:listauser";
	}

	@GetMapping("listauser")
	public String elencousers(HttpSession session, Model model) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("listauser", du.readAll());
		return "listausers.jsp";
	}

	@GetMapping("ricercaadmin")
	public String ricerca(@RequestParam("search") String par, Model model, HttpSession session) {
		session.setAttribute("url", "/");
		if (!LoginController.checkSession(session))
			return "redirect:/";
		if (!LoginController.checkAdmin(session))
			return "redirect:/";
		model.addAttribute("lNome", de.readByNome(par));
		model.addAttribute("lArtista", de.readByArtista(par));
		model.addAttribute("lLocalita", de.readByCitta(par));
		return "ricercaadmin.jsp";
	}
}
