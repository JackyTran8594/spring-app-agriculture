package agriculture.com.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication()
@EnableAutoConfiguration()

public class AppApplication {

	private static final Logger LOGGER = LogManager.getLogger(AppApplication.class);

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// String encodedPassword = passwordEncoder.encode("jack");
		// System.out.println("--encodedPassword---");
		// System.out.println(encodedPassword);
		// System.out.println("--end---");

		SpringApplication.run(AppApplication.class, args);
	}

}
