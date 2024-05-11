package com.myapp.app.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


public class AdminView extends VerticalLayout {

	public AdminView() {
		add(new H1("Привет админ!"));
	}
}
