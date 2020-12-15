package agriculture.com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.model.User;

import agriculture.com.app.repositories.UserRepository;
import agriculture.com.app.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	// @Autowired
	// private final UserRepository userRepository;

	// @RequestMapping("/")
	// public String index() {
	// return "Greetings from Spring Boot!";
	// }

	// public UserController(UserRepository userRepository) {
	// this.userRepository = userRepository;
	// }

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> allUsers() {

		return userService.findAll();
	}

	@GetMapping("/users/count")
	public Long count() {

		return userService.count();
	}

	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable String id) {

		Long userId = Long.parseLong(id);
		userService.deleteById(userId);
	}

}