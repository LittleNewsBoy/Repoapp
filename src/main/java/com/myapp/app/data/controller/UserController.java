package com.myapp.app.data.controller;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import com.myapp.app.data.service.UserService;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@RestController
@RequestMapping("/AppUser")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/findAllUsers")
	public List<User> findAllUser() {
		return userService.findUser();
	}

	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user){
		return userService.addUser(user);

	}


	@PostMapping("/findUserByRole")
	public User getUserByRole(@RequestBody Role role) {
		return userService.getUserByRole(role);
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}


}
