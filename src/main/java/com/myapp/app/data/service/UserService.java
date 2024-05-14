package com.myapp.app.data.service;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
	ResponseEntity<Object> addUser(User user);
	List<User> findUser();
	User getUserByRole(Role role);
	User saveUser(User user);
	User updateUser(User user);
}
