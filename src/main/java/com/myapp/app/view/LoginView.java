package com.myapp.app.view;

import com.myapp.app.data.service.AuthService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("Login")
public class LoginView extends Composite<LoginOverlay> {

	public LoginView(AuthService authService) {
		LoginOverlay loginOverlay = getContent();
		loginOverlay.setTitle("Учет АОН");
		loginOverlay.setDescription("Вход в систему");
		loginOverlay.setOpened(true);

		loginOverlay.addLoginListener(event -> {
			try {
				authService.authenticate(event.getUsername(), event.getPassword());
				UI.getCurrent().navigate(AdminView.class);
			} catch (AuthService.AuthExeption e) {
				Notification.show("Ошибка");
			}

		});
	}
}
