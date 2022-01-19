package springWeb.repositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springWeb.repositoryJPA.entity.Category;
import springWeb.repositoryJPA.entity.Order;

@Repository
public interface CategoryRepositoryJPA extends JpaRepository<Category, Integer> {
}
