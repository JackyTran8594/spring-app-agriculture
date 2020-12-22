package agriculture.com.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.dto.LogInDTO;
import agriculture.com.app.model.User;
import agriculture.com.app.service.LoginService;

@RestController
@RequestMapping(name = "/api")
public class LoginController {

	@Autowired
	private LoginService loginService;

	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody LogInDTO userInfo) {
		try {
			var exist = loginService.loadUserByEmail(userInfo.email, userInfo.password);
			if (exist == null) {
				LOGGER.info("Email or password wrong" + "login - loigincontroller");
				return new ResponseEntity<>("Email or password wrong", HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>("Successfully", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "login - loigincontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
