package springWeb.repositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springWeb.repositoryJPA.entity.OrderItem;
import springWeb.repositoryJPA.entity.User;

@Repository
public interface OrderItemRepositoryJPA extends JpaRepository<OrderItem, Integer> {
}
