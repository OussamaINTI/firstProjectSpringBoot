package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Role;
import com.adaming.services.IRoleService;

@RestController
public class RoleController {
	@Autowired
	IRoleService roleService;

	@RequestMapping(value = "roles", method = RequestMethod.GET)
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@RequestMapping(value = "roles/{id}", method = RequestMethod.GET)
	public Role findOne(@PathVariable("id") Long id) {
		return roleService.findOne(id);
	}

	@RequestMapping(value = "roles", method = RequestMethod.POST)
	public Role saveRole(@RequestBody Role role) {
		return roleService.save(role);
	}

	@RequestMapping(value = "roles/{id}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") Long id) {
		roleService.delete(id);
	}

	@RequestMapping(value = "roles/{id}", method = RequestMethod.PUT)
	public Role updateRole(@PathVariable("id") Long id,@RequestBody Role role) {
		Role currentRole = roleService.findOne(id);
		currentRole.setLibelle(role.getLibelle());
		return roleService.save(role);
	}
}
