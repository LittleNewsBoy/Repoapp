package com.myapp.app;

import com.myapp.app.data.service.UserRepository;
import com.myapp.app.view.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.Collection;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AppApplication{

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
