package com.myapp.app.view;

import com.myapp.app.data.entity.AppUser;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

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
//		Grid<AppUser> grid = new Grid<>(AppUser.class, false);
//		grid.addColumn(AppUser::getUsername).setHeader("Username");
//		grid.addColumn(AppUser::getPasswordHash).setHeader("Pass");
//		grid.addColumn(AppUser::getRole).setHeader("Role");
//
//		var users = new ArrayList<AppUser>(0);
//		users.add(new AppUser("user1","pass1", Role.USER));
//		users.add(new AppUser("user2","pass1", Role.USER));
//		grid.setItems(users);
		//____________________________________________


//		VerticalLayout verticalLayout = new VerticalLayout(grid);
//		HorizontalLayout horizontalLayout = new HorizontalLayout(primaryButton, startDatePicker, finishDatePicker);
//		horizontalLayout.setFlexGrow(1,primaryButton);
//		horizontalLayout.setFlexGrow(1,startDatePicker);
//		horizontalLayout.setFlexGrow(1,finishDatePicker);
//		horizontalLayout.setJustifyContentMode(JustifyContentMode.AROUND);
//		horizontalLayout.setWidthFull();
//		horizontalLayout.setAlignItems(Alignment.BASELINE);
//		add(horizontalLayout);
//		add(verticalLayout);
	}

}
