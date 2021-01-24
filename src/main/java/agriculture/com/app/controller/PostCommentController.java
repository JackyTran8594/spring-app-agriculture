package agriculture.com.app.controller;

import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.dto.PostCommentDTO;
import agriculture.com.app.model.PostComment;

import agriculture.com.app.service.PostCommentService;

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
@RequestMapping(value = "/api/comment")
public class PostCommentController {

	@Autowired
	private PostCommentService service;

	private static final Logger LOGGER = LogManager.getLogger(PostController.class);

	@GetMapping("/getComments")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity getComments() {
		try {
			List<PostComment> items = service.findAll();
			return new ResponseEntity<>(items, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": getComments - PostCommentController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/post")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity postRole(@RequestBody PostCommentDTO data) {
		try {
			service.post(data);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": Post - PostCommentController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateComment/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity update(@RequestBody PostCommentDTO data, @PathVariable(value = "id") String id) {
		try {
			service.update(data, id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + ": update post - PostCommentController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/comments/count")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity<String> count() {
		try {
			Long count = service.count();
			return new ResponseEntity<String>(count.toString(), HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "count - PostCommentController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/comment/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
	@ResponseBody
	public ResponseEntity getById(@PathVariable String id) {
		try {
			PostComment item = service.getById(id);
			return new ResponseEntity<>(item, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "getById- PostCommentController");

			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/post/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> delete(@PathVariable String id) {

		try {
			Long _id = Long.parseLong(id);
			service.deleteById(_id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			// TODO: handle exception
			LOGGER.info(e.getMessage() + "delete - PostCommentController");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

}