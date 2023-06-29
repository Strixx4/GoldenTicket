package com.ant.goldenticket.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOUtenti;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	DAOUtenti du;

	// [003]
	// formlogin che reindirizza l'utente alla pagina di login
	@GetMapping("formlogin")
	public String formlogin() {
		return "formlogin.jsp";
	}

	// [003]
	// login
	@PostMapping("login")
	public String login(@RequestParam("username") String u, @RequestParam("password") String p, HttpSession session) {
		Map<String, String> ut = du.cercaPerNome(u);
		System.out.println("Mappa : " + ut);
		System.out.println("Session: " + u + " " + p);
		if (ut != null) {
			if (p.equals(ut.get("password"))) {
				session.setAttribute("login", "ok");
				session.setAttribute("username", u);
				session.setAttribute("password", p);
				session.setAttribute("id", ut.get("id"));
				session.setAttribute("ruolo", ut.get("ruolo"));
				System.out.println("done");
				if (checkAdmin(session)) {
					return "redirect:admin/";
				} else
					return "redirect:/";
			}
		}
		return "redirect:formlogin";
	}

	@GetMapping("formregistra")
	public String formRegistra(HttpSession session) {
		if (!checkSession(session)) {
			return "formregistra.jsp";
		} else {
			if (checkUtenti(session)) {
				return "redirect:/";
			} else {
				return "redirect:/admin";
			}
		}
	}

	@PostMapping("registrati")
	public String registrati(HttpSession session, @RequestParam("username") String u,
			@RequestParam("password") String p) {
		if (!checkSession(session)) {
			if (du.cercaPerNome(u) == null) {
				System.out.println("u.size() == null");
				if (checkData(u, p)) {
					du.create(u, p, "loggato");
					session.setAttribute("login", "ok");
					session.setAttribute("username", u);
					session.setAttribute("password", p);
					session.setAttribute("id", du.cercaPerNome(u).get("id"));
					session.setAttribute("ruolo", du.cercaPerNome(u).get("ruolo"));
					System.out.println("done");
					return "redirect:/";
				} else
					return "redirect:formlogin";

			} else
				System.out.println("u.size !=0");
			return "redirect:formlogin";
		} else {
			if (checkUtenti(session)) {
				return "redirect:/";
			} else {
				return "redirect:admin/";
			}
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

	@GetMapping("/admin/logout") // tutto a null e ritorni ad home
	public String logoutAdmin(HttpSession session) {
		session.setAttribute("login", null);
		session.setAttribute("username", null);
		session.setAttribute("password", null);
		session.setAttribute("id", null);
		session.setAttribute("ruolo", null);
		return "redirect:/";
	}

	public static boolean checkSession(HttpSession session) {
		boolean ris = false;
		System.out.println("Login: " + session.getAttribute("login"));
		if (session.getAttribute("login") != null)
			ris = true;
		return ris;
	}

	public static boolean checkUtenti(HttpSession session) {
		boolean ris = false;
		if (checkSession(session) && session.getAttribute("ruolo").toString().equals("loggato"))
			ris = true;
		return ris;
	}

	public static boolean checkAdmin(HttpSession session) {
		boolean ris = false;
		if (checkSession(session) && session.getAttribute("ruolo").toString().equals("admin"))
			ris = true;
		return ris;
	}

	@GetMapping("formuser")
	public String formcambiapasswordparteuser() {
		return "formuser.jsp";
	}

	@PostMapping("formpassword")
	public String formcambiapasswordpartepassword(Model model, @RequestParam("username") String u,
			HttpSession session) {
		if (checkSession(session)) {
			return "redirect:/";
		}
		if (checkUtenti(session)) {
			return "redirect:/";
		}
		if (checkAdmin(session)) {
			return "redirect:admin/";
		}
		Map<String, String> ut = du.cercaPerNome(u);
		System.out.println(ut);
		if (ut != null) {
			if (u.equals(ut.get("username"))) {
				model.addAttribute("user", du.cercaPerNome(u));
				return "formpassword.jsp";
			} else
				return "redirect:formuser";
		} else
			return "redirect:formuser";

	}

	@PostMapping("cambiapassword")
	public String cambiapas(@RequestParam Map<String, String> inputs, HttpSession session) {
		if (checkSession(session)) {
			return "redirect:/";
		}
		if (checkUtenti(session)) {
			return "redirect:/";
		}
		if (checkAdmin(session)) {
			return "redirect:admin/";
		}
		if (checkData(inputs.get("username"), inputs.get("password")))
			du.updateByNome(inputs);
		return "redirect:formlogin";
	}

	public static boolean checkData(String u, String p) {
		if (u.length() < 1 || u.length() > 50)
			return false;
		if (p.length() < 1 || p.length() > 16)
			return false;
		return true;

	}
}
