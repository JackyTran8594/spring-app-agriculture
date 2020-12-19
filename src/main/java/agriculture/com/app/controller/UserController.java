package agriculture.com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.dto.UserDTO;
import agriculture.com.app.model.User;

import agriculture.com.app.repositories.UserRepository;
import agriculture.com.app.service.UserService;

import java.util.List;

import org.apache.logging.log4j.core.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@Component
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	// @RequestMapping(value = "/users", method = RequestMethod.GET)
	@GetMapping("/users")
	@ResponseBody
	public ResponseEntity allUsers() {
		try {
			List<User> user = userService.findAll();
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "allUsers - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	// @RequestMapping(value = "/user", method = RequestMethod.POST)
	@PostMapping("/user")
	@ResponseBody
	public ResponseEntity postUser(@RequestBody UserDTO user) {
		try {
			userService.postUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "allUsers - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/user/{id}")
	// @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity updateUser(@RequestBody UserDTO user, @PathVariable(value = "id") String id) {
		try {
			userService.updateUser(user, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "allUsers - usercontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/users/count")
	// @RequestMapping(value = "/users/count", method = RequestMethod.GET)
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
	// @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
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
	// @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
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