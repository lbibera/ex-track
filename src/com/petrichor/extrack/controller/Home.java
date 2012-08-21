package com.petrichor.extrack.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petrichor.extrack.domain.ExTrackAuthority;

@Controller
public class Home {
	
	@PersistenceContext
	EntityManager em;

	@RequestMapping("/")
	public String home() {
		
		ExTrackAuthority accountOwner = new ExTrackAuthority();
		accountOwner.setAuthority("ROLE_ACCOUNT_OWNER");
		em.persist(accountOwner);
		
		ExTrackAuthority admin = new ExTrackAuthority();
		admin.setAuthority("ROLE_ADMIN");
		em.persist(admin);
		
		ExTrackAuthority user = new ExTrackAuthority();
		user.setAuthority("ROLE_USER");
		em.persist(user);
		
		return "home";
	}
}
