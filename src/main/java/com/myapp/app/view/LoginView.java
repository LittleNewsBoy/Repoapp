package com.myapp.app.view;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

//@Route("")
//@AnonymousAllowed
public class LoginView extends Composite<LoginOverlay>{

	public LoginView() {
		getContent().setOpened(true);
		//getContent().setAction("login");
	}
}
