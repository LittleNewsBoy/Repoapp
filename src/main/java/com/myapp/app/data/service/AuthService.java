package com.myapp.app.data.service;

import com.myapp.app.data.entity.Role;
import com.myapp.app.data.entity.User;
import com.myapp.app.view.AdminView;
import com.myapp.app.view.TestView;
import com.myapp.app.view.UserView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthService {

	public class AuthExeption extends Exception{

	}

	private final UserRepository userRepository;

	public record AuthorizedRoute(String route, String name, Class<? extends Component> view){

	}
	@Autowired
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void authenticate(String username, String password) throws AuthExeption {
		User user = userRepository.getByUsername(username);
		if (user != null && user.chekPassword(password)){
			createRoutes(user.getRole());
		}else {
			throw new AuthExeption();
		}
	}

	private void createRoutes(Role role) {
		getAuthorizedRoute(role).stream()
				.forEach(route ->
						RouteConfiguration.forSessionScope().setRoute(
								route.route, route.view, TestView.class));
	}
	public List<AuthorizedRoute> getAuthorizedRoute(Role role){
		var routes = new ArrayList<AuthorizedRoute>();
		if (role.equals(Role.USER)){
			routes.add(new AuthorizedRoute("user", "User", UserView.class));
		}else if (role.equals(Role.ADMIN)){
			routes.add(new AuthorizedRoute("user", "User", UserView.class));
			routes.add(new AuthorizedRoute("admin", "Admin", AdminView.class));
		}
		return routes;
	}
}
