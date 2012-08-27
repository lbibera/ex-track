package com.petrichor.extrack.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@PersistenceContext
	EntityManager em;

	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
