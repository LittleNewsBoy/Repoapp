package com.myapp.app.data.service;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User getUserByRole(Role role);
	User getByUsername(String username);
}
