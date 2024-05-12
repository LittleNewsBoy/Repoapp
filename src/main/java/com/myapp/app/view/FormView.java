package com.myapp.app.view;

import com.myapp.app.data.entity.Role;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;

public class FormView extends VerticalLayout {

	public FormView() {

		//Выбор даты создания АОН
		Locale locale = new Locale("ru", "RU");
		DatePicker startDatePicker = new DatePicker("Дата:");
		startDatePicker.setLocale(locale);
		startDatePicker.setValue(LocalDate.now(ZoneId.systemDefault()));

		//Выбор участка
		ComboBox<Role> comboBox1Layer1 = new ComboBox<>("Участок:");
		comboBox1Layer1.setItems(Role.ADMIN, Role.USER);

		//Выбор изделия
		ComboBox<Role> comboBox2Layer1 = new ComboBox<>("Изделие:");
		comboBox2Layer1.setItems(Role.ADMIN, Role.USER);


		//Выбор децимального номера !!!(Надо продумать выбор децимального на основании изделия)!!!
		ComboBox<Role> comboBox2Layer2 = new ComboBox<>("Децимальный номер:");
		comboBox2Layer2.setItems(Role.ADMIN, Role.USER);


		//Выбор даты создания АОН
		TextField textFieldLayer1 = new TextField("Номер АОН:");
		textFieldLayer1.setRequiredIndicatorVisible(true);
		textFieldLayer1.setMinLength(1);
		textFieldLayer1.setMaxLength(18);
		textFieldLayer1.setHelperText("Формат: 123");

		//Внесение заводских номеров !!!(Можно добавить регулярку*)!!!
		TextField textFieldLayer2 = new TextField("Заводской(ие) номер(а):");
		textFieldLayer2.setRequiredIndicatorVisible(true);
		textFieldLayer2.setMinLength(1);
		textFieldLayer2.setMaxLength(18);
		//*тут
		textFieldLayer2.setHelperText("Формат: 123");

		//Выбор вида дефекта или, что виновник не установлен
		Checkbox checkbox1 = new Checkbox();
		checkbox1.setLabel("Производственный:");

		Checkbox checkbox2 = new Checkbox();
		checkbox2.setLabel("Конструкционный:");

		Checkbox checkbox3 = new Checkbox();
		checkbox3.setLabel("Виновник не установлен:");

		//Описание несоответствия
		int charLimit = 2500;
		TextArea textArea1 = new TextArea();
		textArea1.setWidthFull();
		textArea1.setLabel("Описание несоответствия:");
		textArea1.setMaxLength(charLimit);
		textArea1.setValueChangeMode(ValueChangeMode.EAGER);
		textArea1.addValueChangeListener(e -> {
			e.getSource()
					.setHelperText(e.getValue().length() + "/" + charLimit);
		});

		//Решение по дефектам
		TextArea textArea2 = new TextArea();
		textArea2.setWidthFull();
		textArea2.setLabel("Решение по дефектам:");
		textArea2.setMaxLength(charLimit);
		textArea2.setValueChangeMode(ValueChangeMode.EAGER);
		textArea2.addValueChangeListener(e -> {
			e.getSource()
					.setHelperText(e.getValue().length() + "/" + charLimit);
		});

		Button primaryButton = new Button("Сохранить АОН: ");
		primaryButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		primaryButton.addThemeVariants(ButtonVariant.LUMO_LARGE);

		//Настройка слоев
		HorizontalLayout horizontalLayout1Layer = new HorizontalLayout(startDatePicker, comboBox1Layer1,textFieldLayer1);
		HorizontalLayout horizontalLayout2Layer = new HorizontalLayout(comboBox2Layer1,comboBox2Layer2,textFieldLayer2);
		HorizontalLayout horizontalLayout3Layer = new HorizontalLayout(checkbox1,checkbox2,checkbox3);
		HorizontalLayout horizontalLayout4Layer = new HorizontalLayout(textArea1, textArea2);
		HorizontalLayout horizontalLayout5Layer = new HorizontalLayout(primaryButton);

		horizontalLayout1Layer.setFlexGrow(1,startDatePicker);
		horizontalLayout1Layer.setFlexGrow(1,comboBox1Layer1);
		horizontalLayout1Layer.setFlexGrow(1,textFieldLayer1);
		horizontalLayout1Layer.setJustifyContentMode(JustifyContentMode.AROUND);
		horizontalLayout1Layer.setWidthFull();
		horizontalLayout1Layer.setAlignItems(Alignment.BASELINE);

		horizontalLayout2Layer.setFlexGrow(1,comboBox2Layer1);
		horizontalLayout2Layer.setFlexGrow(1,comboBox2Layer2);
		horizontalLayout2Layer.setFlexGrow(1,textFieldLayer2);
		horizontalLayout2Layer.setJustifyContentMode(JustifyContentMode.AROUND);
		horizontalLayout2Layer.setWidthFull();
		horizontalLayout2Layer.setAlignItems(Alignment.BASELINE);

		horizontalLayout3Layer.setFlexGrow(1,checkbox1);
		horizontalLayout3Layer.setFlexGrow(1,checkbox2);
		horizontalLayout3Layer.setFlexGrow(1,checkbox3);
		horizontalLayout3Layer.setJustifyContentMode(JustifyContentMode.AROUND);
		horizontalLayout3Layer.setWidthFull();
		horizontalLayout3Layer.setAlignItems(Alignment.BASELINE);

		horizontalLayout4Layer.setFlexGrow(1,textArea1);
		horizontalLayout4Layer.setFlexGrow(1,textArea2);
		horizontalLayout4Layer.setJustifyContentMode(JustifyContentMode.AROUND);
		horizontalLayout4Layer.setWidthFull();
		horizontalLayout4Layer.setAlignItems(Alignment.BASELINE);

		horizontalLayout5Layer.setSpacing(false);
		horizontalLayout5Layer.setFlexGrow(1, primaryButton);
		horizontalLayout5Layer.setWidthFull();
		horizontalLayout5Layer.setJustifyContentMode(JustifyContentMode.AROUND);

		VerticalLayout verticalLayout = new VerticalLayout(horizontalLayout1Layer,horizontalLayout2Layer,
				horizontalLayout3Layer, horizontalLayout4Layer, horizontalLayout5Layer);
		add(verticalLayout);

	}
}
