package com.myapp.app.view;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;


public class AdminView extends VerticalLayout {
	public AdminView() {
		//Создание таблицы со всеми пользователями:
		//____________________________________________
		Grid<User> grid = new Grid<>(User.class, false);
		grid.addColumn(User::getUsername).setHeader("Username");
		grid.addColumn(User::getPasswordHash).setHeader("Pass");
		grid.addColumn(User::getRole).setHeader("Role");

		var users = new ArrayList<User>(0);
		users.add(new User("user1","pass1", Role.USER));
		users.add(new User("user2","pass1", Role.USER));
		grid.setItems(users);
		//____________________________________________;

		//Добавление на экран:
		//____________________________________________
		VerticalLayout verticalLayout = new VerticalLayout(grid);
		add(verticalLayout);
		//____________________________________________;

	}


}
