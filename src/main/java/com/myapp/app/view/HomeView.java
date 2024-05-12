package com.myapp.app.view;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import com.myapp.app.data.generator.DataGenerator;
import com.myapp.app.data.service.AuthService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


import java.util.ArrayList;
import java.util.List;

public class HomeView extends VerticalLayout {

	public HomeView() {

		//Создание таблицы со всеми созданными АОНами (добавить функцию просмотра АОН):
		//____________________________________________
		Grid<User> grid = new Grid<>(User.class, false);
		grid.addColumn(User::getUsername).setHeader("Username");
		grid.addColumn(User::getPasswordHash).setHeader("Pass");
		grid.addColumn(User::getRole).setHeader("Role");

		var users = new ArrayList<User>(0);
		users.add(new User("user1","pass1", Role.USER));
		users.add(new User("user2","pass1", Role.USER));
		grid.setItems(users);
		//____________________________________________

		//Кнопка переброски на форму АОН:
		//____________________________________________
		Button primaryButton = new Button("Создать АОН");
		primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		primaryButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
		primaryButton.addClickListener(r -> {
			UI.getCurrent().navigate(FormView.class);
		});
		//____________________________________________

		//Добавление на экран:
		//____________________________________________
		HorizontalLayout horizontalLayout = new HorizontalLayout(primaryButton);
		VerticalLayout verticalLayout = new VerticalLayout(grid);
		add(horizontalLayout);
		add(verticalLayout);
		//____________________________________________

	}

}
