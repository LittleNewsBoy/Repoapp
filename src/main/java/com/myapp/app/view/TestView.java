package com.myapp.app.view;

import com.myapp.app.data.entity.AppUser;
import com.myapp.app.data.repo.UserRepository;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TestView extends AppLayout {



	@Autowired
	private UserRepository userRepository;

	public TestView() {
//		DrawerToggle toggle = new DrawerToggle();
//
//		H1 title = new H1("MyApp");
//		title.getStyle().set("font-size", "var(--lumo-font-size-l)")
//				.set("margin", "0");
//
//		SideNav nav = getSideNav();
//
//		Scroller scroller = new Scroller(nav);
//		scroller.setClassName(LumoUtility.Padding.SMALL);
//
//		addToDrawer(scroller);
//		addToNavbar(toggle, title);
	}

//	private SideNav getSideNav() {
//		SideNav sideNav = new SideNav();
//		Optional<AppUser> user = userRepository.findByUsername(username);
//		if (user.getRole().equals(userRepository.g)){
//			sideNav.addItem(
//					new SideNavItem("Home", HomeView.class, VaadinIcon.CHART.create()),
//					new SideNavItem("User", UserView.class, VaadinIcon.DASHBOARD.create()),
//					new SideNavItem("Logout", LogoutView.class, VaadinIcon.LIST.create()));
//		}else {
//			sideNav.addItem(
//					new SideNavItem("Home", HomeView.class, VaadinIcon.CHART.create()),
//					new SideNavItem("Admin", AdminView.class, VaadinIcon.CART.create()),
//					new SideNavItem("User", UserView.class, VaadinIcon.DASHBOARD.create()),
//					new SideNavItem("Logout", LogoutView.class, VaadinIcon.LIST.create()));
//		}
//		return sideNav;
//
//	}

}
