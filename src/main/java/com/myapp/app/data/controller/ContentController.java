package com.myapp.app.data.controller;

import com.myapp.app.view.HomeView;
import com.myapp.app.view.LoginView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {


	@GetMapping("/home")
	public String handleWelcome() {
		return "home";
	}

	@GetMapping("/admin/home")
	public String handleAdminHome() {
		return "home_admin";
	}

	@GetMapping("/user/home")
	public String handleUserHome() {
		return "home";
	}

}
