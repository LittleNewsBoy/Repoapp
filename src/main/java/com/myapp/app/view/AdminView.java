package com.myapp.app.view;

import com.myapp.app.data.entity.AppUser;
import com.myapp.app.data.repo.UserRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.ArrayList;


public class AdminView extends VerticalLayout {
	private final UserRepository userRepository;
	public AdminView(UserRepository userRepository) {
		this.userRepository = userRepository;

		//Создание таблицы со всеми пользователями:
		//____________________________________________
//		Grid<AppUser> grid = new Grid<>(AppUser.class, false);
//		grid.addColumn(AppUser::getUsername).setHeader("Username");
//		grid.addColumn(AppUser::getPasswordHash).setHeader("Pass");
//		grid.addColumn(AppUser::getRole).setHeader("Role");

//		var users = new ArrayList<AppUser>(0);
//		users.add(new AppUser("user1","pass1", Role.USER));
//		users.add(new AppUser("user2","pass1", Role.USER));
//		grid.setItems(users);
		//____________________________________________;

		//Добавление на экран:
		//____________________________________________
//		VerticalLayout verticalLayout = new VerticalLayout(grid);
//		add(verticalLayout);
		//____________________________________________;

	}


}
