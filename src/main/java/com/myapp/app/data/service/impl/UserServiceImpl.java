package com.myapp.app.data.service.impl;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import com.myapp.app.data.service.UserRepository;
import com.myapp.app.data.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public ResponseEntity<Object> addUser(User user) {
		try {
			return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>("Невозможно сохранить юзера", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public List<User> findUser() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByRole(Role role) {
		return userRepository.getUserByRole(role);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}


}
