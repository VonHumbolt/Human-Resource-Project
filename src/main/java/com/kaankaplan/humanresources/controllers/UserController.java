package com.kaankaplan.humanresources.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaankaplan.humanresources.models.User;
import com.kaankaplan.humanresources.services.interfaces.UserService;

@RestController
@RequestMapping("/api/users/")
@CrossOrigin
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("getall")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam Optional<Integer> pageNo, @RequestParam Optional<Integer> pageSize) {
		
		return new ResponseEntity<List<User>>(
				this.userService.getallUsers(pageNo.orElse(1), pageSize.orElse(10)),
				HttpStatus.OK
			);
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
	@GetMapping("getById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		
		return new ResponseEntity<User>(
				this.userService.getUserById(userId),
				HttpStatus.OK
			);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping("delete/{userId}")
	public ResponseEntity<String> deleteById(@PathVariable int userId) {
		
		this.userService.delete(userId);
		
		return new ResponseEntity<String>(
				"User silindi...",
				HttpStatus.OK
			);
	}
}
