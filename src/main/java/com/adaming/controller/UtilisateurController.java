package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Utilisateur;
import com.adaming.services.IUtilisateurService;

@RestController
public class UtilisateurController {
	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long id) {
		return utilisateurService.findOne(id);
	}

	@RequestMapping(value = "users", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur user1 = new Utilisateur();
		user1.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		user1.setNom(utilisateur.getNom());
		user1.setPrenom(utilisateur.getPrenom());
		user1.setUsername(utilisateur.getUsername());
		user1.setImage(utilisateur.getImage());
		user1.setRoles(utilisateur.getRoles());
		return utilisateurService.save(user1);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		utilisateurService.delete(id);
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUser = utilisateurService.findOne(id);
		currentUser.setNom(utilisateur.getNom());
		currentUser.setPrenom(utilisateur.getPrenom());
		currentUser.setUsername(utilisateur.getUsername());
		currentUser.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		currentUser.setRoles(utilisateur.getRoles());
		currentUser.setImage(utilisateur.getImage());
		return utilisateurService.save(currentUser);
	}

}
