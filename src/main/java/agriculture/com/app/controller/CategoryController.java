package agriculture.com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.dto.CategoryDTO;
import agriculture.com.app.model.Category;
import agriculture.com.app.service.CategoryService;

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
@RequestMapping(value = "/api/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	private static final Logger LOGGER = LogManager.getLogger(PostController.class);

	@GetMapping("/getAll")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity getAll() {
		try {
			List<Category> items = service.findAll();
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": get all - CategoryController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/tag")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity postTag(@RequestBody CategoryDTO data) {
		try {
			service.post(data);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": Post - CategoryController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/tag/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity updateTag(@RequestBody CategoryDTO data, @PathVariable(value = "id") String id) {
		try {
			service.update(data, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": update post - CategoryController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/tags/count")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity<String> count() {
		try {
			Long count = service.count();
			return new ResponseEntity<String>(count.toString(), HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "count - CategoryController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/tag/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity getById(@PathVariable String id) {
		try {
			Category Role = service.getById(id);
			return new ResponseEntity<>(Role, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "getById - CategoryController");

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/tag/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable String id) {

		try {
			Long _id = Long.parseLong(id);
			service.deleteById(_id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			// TODO: handle exception
			LOGGER.info(e.getMessage() + "delete - TagController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

}