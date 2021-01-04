package agriculture.com.app.controller;

// import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import agriculture.com.app.utils.JwtResponse;
import agriculture.com.app.config.Jwt.JwtUtils;
import agriculture.com.app.dto.LogInDTO;

import agriculture.com.app.repositories.RoleRepository;
import agriculture.com.app.repositories.UserRepository;

import agriculture.com.app.service.UserDetailsImpl;

@RestController
public class AuthController {


	private static final Logger LOGGER = LogManager.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/auth/token")
	@ResponseBody
	public ResponseEntity<?> AuthenticationLogin(@RequestBody LogInDTO logInDTO) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(logInDTO.userName, logInDTO.password));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

			return new ResponseEntity<>(
					new JwtResponse(jwt, userDetails.getUsername(), userDetails.getEmail(), userDetails.getId()),
					HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.info(e.getMessage() + "login - loigincontroller");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

}
