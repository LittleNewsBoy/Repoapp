package com.myapp.app.view;

import com.myapp.app.data.service.AuthService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Configuration;
@Route("login")
@AnonymousAllowed
public class LoginView extends Composite<LoginOverlay>{

	public LoginView(AuthService authService) {

		LoginOverlay loginOverlay = getContent();
		loginOverlay.setTitle("Учет АОН");
		loginOverlay.setDescription("Вход в систему");
		loginOverlay.setOpened(true);


		loginOverlay.addForgotPasswordListener(event -> {
			Notification.show("You faggot password?!");
		});

		loginOverlay.addLoginListener(event -> {
			try {
				authService.authenticate(event.getUsername(), event.getPassword());
				UI.getCurrent().navigate(HomeView.class);
			} catch (AuthService.AuthException e) {
				Notification.show("Ошибка");
				UI.getCurrent().close();
			}

		});
	}

}
