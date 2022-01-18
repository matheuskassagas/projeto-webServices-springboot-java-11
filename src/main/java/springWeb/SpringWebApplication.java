package springWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springWeb.repositoryJPA.UserRepositoryJPA;
import springWeb.repositoryJPA.User;

import java.util.Arrays;

@SpringBootApplication
public class SpringWebApplication implements CommandLineRunner {

	@Autowired
	private UserRepositoryJPA userRepositoryJPA;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User( "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepositoryJPA.saveAll(Arrays.asList(u1, u2));
	}
}
