package springWeb.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import springWeb.repositoryJPA.User;
import springWeb.repositoryJPA.UserRepositoryJPA;

import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;

    @Override
    public void run(String... args) throws Exception {


        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User( "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepositoryJPA.saveAll(Arrays.asList(u1, u2));
    }
}
