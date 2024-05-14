package com.myapp.app.data.entity;

import com.myapp.app.data.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

@Setter
@Getter
@Entity
@Table(name = "AppUser")
public class User extends AbstractEntity {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "AppUsername")
	private String username;
	//@Column(name = "AppPasswordSalt")
	private String passwordSalt;
	//@Column(name = "AppPasswordHash")
	private String passwordHash;
	//@Column(name = "AppRole")
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

}
