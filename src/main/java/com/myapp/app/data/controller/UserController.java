package com.myapp.app.data.controller;

import com.myapp.app.data.entity.AppUser;
import com.myapp.app.data.repo.UserRepository;
import com.myapp.app.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register/user")
	public AppUser createUser(@RequestBody AppUser appUser){
		appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
		return userRepository.save(appUser);
	}

}
