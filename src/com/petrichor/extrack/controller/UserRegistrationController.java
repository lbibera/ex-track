package com.petrichor.extrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.petrichor.extrack.domain.AccountOwner;
import com.petrichor.extrack.model.UserRegistrationForm;
import com.petrichor.extrack.service.UserRegistrationService;

@Controller
@RequestMapping
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegistrationService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(ModelMap model) {
		model.addAttribute("form", new UserRegistrationForm());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String submitRegistrationForm(@ModelAttribute("form") UserRegistrationForm form, ModelMap model) {
		AccountOwner newOwner = UserRegistrationForm.createAccount(form);
		userRegistrationService.register(newOwner);
		return "register-success";
	}
	
}
