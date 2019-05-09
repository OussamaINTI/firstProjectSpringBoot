package com.adaming.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Utilisateur;
import com.adaming.services.IUtilisateurService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	IUtilisateurService utilisateurService;
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public Utilisateur login(Principal principal) {
		return utilisateurService.findOneByUsername(principal.getName());
	}
	
}
