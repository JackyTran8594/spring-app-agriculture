package agriculture.com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.dto.PostMetaDTO;
import agriculture.com.app.model.PostMeta;
import agriculture.com.app.service.PostMetaService;

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
@RequestMapping(value = "/api/postMeta")
public class PostMetaController {

	@Autowired
	private PostMetaService service;

	private static final Logger LOGGER = LogManager.getLogger(PostController.class);

	@GetMapping("/getAll")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity getAll() {
		try {
			List<PostMeta> items = service.findAll();
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": get all - PostMetaController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/postMeta")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity postTag(@RequestBody PostMetaDTO data) {
		try {
			service.post(data);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": Post - PostMetaController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/postMeta/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity updateTag(@RequestBody PostMetaDTO data, @PathVariable(value = "id") String id) {
		try {
			service.update(data, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": update post - PostMetaController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/postMeta/count")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity<String> count() {
		try {
			Long count = service.count();
			return new ResponseEntity<String>(count.toString(), HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "count - PostMetaController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/postMeta/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity getById(@PathVariable String id) {
		try {
			PostMeta item = service.getById(id);
			return new ResponseEntity<>(item, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "getById - PostMetaController");

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/postMeta/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable String id) {

		try {
			Long _id = Long.parseLong(id);
			service.deleteById(_id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			// TODO: handle exception
			LOGGER.info(e.getMessage() + "delete - PostMetaController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

}