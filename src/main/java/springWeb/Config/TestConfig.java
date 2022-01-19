package springWeb.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import springWeb.repositoryJPA.OrderRepositoryJPA;
import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.User;
import springWeb.repositoryJPA.UserRepositoryJPA;
import springWeb.repositoryJPA.entity.enums.OrderStatus;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepositoryJPA userRepositoryJPA;
    @Autowired
    private OrderRepositoryJPA orderRepositoryJPA;

    @Override
    public void run(String... args) throws Exception {


        User u1 = new User("Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User( "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);

        userRepositoryJPA.saveAll(Arrays.asList(u1, u2));
        orderRepositoryJPA.saveAll(Arrays.asList(o1, o2, o3));
    }
}
