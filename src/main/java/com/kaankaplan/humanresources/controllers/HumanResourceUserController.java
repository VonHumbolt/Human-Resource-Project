package com.kaankaplan.humanresources.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaankaplan.humanresources.services.interfaces.HumanResourceUserService;

@RestController
@RequestMapping("/api/humanResourceUsers/")
@CrossOrigin
public class HumanResourceUserController {

	private HumanResourceUserService humanResourceUserService;
	
	@Autowired
	public HumanResourceUserController(HumanResourceUserService humanResourceUserService) {
		this.humanResourceUserService = humanResourceUserService;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("{userId}")
	public ResponseEntity<String> delete(int userId) {
		this.humanResourceUserService.delete(userId);
		
		return new ResponseEntity<String>(" Kullanıcı silindi ",HttpStatus.OK);
	}
}
