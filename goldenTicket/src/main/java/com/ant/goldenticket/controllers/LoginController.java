package com.ant.goldenticket.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ant.goldenticket.dao.DAOUtenti;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController 
{
	@Autowired
	DAOUtenti du;
	
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
				if (p.equals(ut.get("password"))) {
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

		public  static boolean checkSession(HttpSession session) {
			boolean ris = false;
			System.out.println("Login: " + session.getAttribute("login"));
			if (session.getAttribute("login") != null)
				ris = true;
			return ris;
		}
		public static boolean checkUtenti(HttpSession session)
		{
			boolean ris=false;
			if(checkSession(session)&&session.getAttribute("ruolo").toString().equals("loggato"))
				ris=true;
			return ris;
		}
		public static boolean checkAdmin(HttpSession session)
		{
			boolean ris=false;
			if(checkSession(session)&&session.getAttribute("ruolo").toString().equals("admin"))
				ris=true;
			return ris;
		}
}
