package agriculture.com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.dto.UserDTO;
import agriculture.com.app.model.User;

import agriculture.com.app.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@Component
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@GetMapping("/test")
	@PreAuthorize("hasRole('user')")
	@ResponseBody
	public ResponseEntity test() {
		try {

			return new ResponseEntity<>("test ok user authorization", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/users")
	@PreAuthorize("hasRole('user') or hasRole('moderator') or hasRole('admin')")
	@ResponseBody
	public ResponseEntity allUsers() {
		try {
			List<User> user = userService.findAll();
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": allUsers - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/user")
	@PreAuthorize("hasRole('admin')")
	@ResponseBody
	public ResponseEntity postUser(@RequestBody UserDTO user) {
		try {
			userService.postUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": postUser - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/user/{id}")
	@PreAuthorize("hasRole('admin')")
	@ResponseBody
	public ResponseEntity updateUser(@RequestBody UserDTO user, @PathVariable(value = "id") String id) {
		try {
			userService.updateUser(user, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": updateUser - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/users/count")
	@PreAuthorize("hasRole('user') or hasRole('moderator') or hasRole('admin')")
	@ResponseBody
	public ResponseEntity<String> count() {
		try {
			Long count = userService.count();
			return new ResponseEntity<String>(count.toString(), HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "count - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/user/{id}")
	@PreAuthorize("hasRole('user') or hasRole('moderator') or hasRole('admin')")
	@ResponseBody
	public ResponseEntity getById(@PathVariable String id) {
		try {
			User user = userService.getById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "count - usercontroller");

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/user/{id}")
	@PreAuthorize("hasRole('admin')")
	public ResponseEntity<String> delete(@PathVariable String id) {

		try {
			Long userId = Long.parseLong(id);
			userService.deleteById(userId);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			// TODO: handle exception
			LOGGER.info(e.getMessage() + "delete - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

}