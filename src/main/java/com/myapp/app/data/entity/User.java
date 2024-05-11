package com.myapp.app.data.entity;

import com.myapp.app.data.AbstractEntity;
import jakarta.persistence.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
@Table(name = "\"user\"")
public class User extends AbstractEntity {

	private String username;
	private String passwordSalt;
	private String passwordHash;
	private Role role;


	public User() {
	}

	public User(String username, String password, Role role) {
		this.username = username;
		this.role = role;
		this.passwordSalt = RandomStringUtils.random(32);
		this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);
	}

	public boolean chekPassword (String password){
		return DigestUtils.sha1Hex(password + passwordSalt).equals(passwordHash);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
