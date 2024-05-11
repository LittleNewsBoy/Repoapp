package com.myapp.app.view;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class HomeView extends VerticalLayout {

	public HomeView() {
		add(new H1("Домашняя страница!"));
	}
}
