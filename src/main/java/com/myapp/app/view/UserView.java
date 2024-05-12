package com.myapp.app.view;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Locale;


public class UserView extends VerticalLayout {

	public UserView(){
		//Кнопка для создания отчета
		//____________________________________________
		Button primaryButton = new Button("Создать отчет по АОН за промежуток времени: ");
		primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		primaryButton.addThemeVariants(ButtonVariant.LUMO_LARGE);
		//____________________________________________

		//Выбор даты начала и конца отчета
		//____________________________________________
		Locale locale = new Locale("ru", "RU");

		DatePicker startDatePicker = new DatePicker("Выберите дату начала отчета:");
		DatePicker finishDatePicker = new DatePicker("Выберите дату конца отчета:");

		startDatePicker.setLocale(locale);
		finishDatePicker.setLocale(locale);

		startDatePicker.addValueChangeListener(e -> finishDatePicker.setMin(e.getValue()));
		finishDatePicker.addValueChangeListener(e -> startDatePicker.setMax(e.getValue()));
		//____________________________________________

		//Создание таблицы со всеми созданными пользователем АОНами (добавить функцию просмотра АОН):
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


		VerticalLayout verticalLayout = new VerticalLayout(grid);
		HorizontalLayout horizontalLayout = new HorizontalLayout(primaryButton, startDatePicker, finishDatePicker);
		horizontalLayout.setFlexGrow(1,primaryButton);
		horizontalLayout.setFlexGrow(1,startDatePicker);
		horizontalLayout.setFlexGrow(1,finishDatePicker);
		horizontalLayout.setJustifyContentMode(JustifyContentMode.AROUND);
		horizontalLayout.setWidthFull();
		horizontalLayout.setAlignItems(Alignment.BASELINE);
		add(horizontalLayout);
		add(verticalLayout);	}

}
