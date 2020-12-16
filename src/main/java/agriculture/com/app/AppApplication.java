package agriculture.com.app;

import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableAutoConfiguration
// @EntityScan("agriculture.com.app.model")
@ComponentScan("agriculture.com.app.repositories")
public class AppApplication {

	private static final Logger LOGGER = LogManager.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	// @Bean
	// CommandLineRunner init(UserRepository userRepository) {
	// return args -> {
	// Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
	// User user = new User(name, name.toLowerCase() + "@domain.com");
	// userRepository.save(user);
	// });
	// userRepository.findAll().forEach(System.out::println);
	// };
	// }

}
