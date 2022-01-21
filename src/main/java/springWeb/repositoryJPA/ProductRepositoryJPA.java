package springWeb.repositoryJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springWeb.repositoryJPA.entity.Category;
import springWeb.repositoryJPA.entity.Product;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<Product, Integer> {
}
