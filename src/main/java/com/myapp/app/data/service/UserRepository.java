package com.myapp.app.data.service;

import com.myapp.app.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
	User getByUsername(String username);

//	User getByActivationCode(String activationCode);
}
