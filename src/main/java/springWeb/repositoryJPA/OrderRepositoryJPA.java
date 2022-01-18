package springWeb.repositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.User;

@Repository
public interface OrderRepositoryJPA extends JpaRepository<Order, Integer> {
}
