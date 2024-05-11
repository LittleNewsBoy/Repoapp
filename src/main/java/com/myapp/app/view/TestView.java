package com.myapp.app.view;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import com.myapp.app.data.service.AuthService;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility;

public class TestView extends AppLayout {


	private final AuthService authService;

	public TestView(AuthService authService) {
		this.authService = authService;
		DrawerToggle toggle = new DrawerToggle();

		H1 title = new H1("MyApp");
		title.getStyle().set("font-size", "var(--lumo-font-size-l)")
				.set("margin", "0");

		SideNav nav = getSideNav();

		Scroller scroller = new Scroller(nav);
		scroller.setClassName(LumoUtility.Padding.SMALL);

		addToDrawer(scroller);
		addToNavbar(toggle, title);
	}

	private SideNav getSideNav() {
		SideNav sideNav = new SideNav();
		var user = VaadinSession.getCurrent().getAttribute(User.class);
		if (user.getRole().equals(Role.USER)){
			sideNav.addItem(
					new SideNavItem("User", UserView.class, VaadinIcon.DASHBOARD.create()),
					new SideNavItem("Home", HomeView.class, VaadinIcon.CHART.create()),
					new SideNavItem("Logout", LogoutView.class, VaadinIcon.LIST.create()));
		}else {
			sideNav.addItem(
					new SideNavItem("User", UserView.class, VaadinIcon.DASHBOARD.create()),
					new SideNavItem("Admin", AdminView.class, VaadinIcon.CART.create()),
					new SideNavItem("Home", HomeView.class, VaadinIcon.CHART.create()),
					new SideNavItem("Logout", LogoutView.class, VaadinIcon.LIST.create()));
		}
		return sideNav;

	}

}
