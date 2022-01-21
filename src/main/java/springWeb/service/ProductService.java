package springWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springWeb.DTO.response.ProductResponse;
import springWeb.exception.DomainException;
import springWeb.repositoryJPA.ProductRepositoryJPA;
import springWeb.repositoryJPA.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepositoryJPA productRepositoryJPA;

    public List<ProductResponse> findAll (){
        return productRepositoryJPA.findAll().stream().map(product -> new ProductResponse().toResponse(product)).collect(Collectors.toList());
    }

    public ProductResponse findById(Integer id) throws DomainException {
        Optional<Product> product = productRepositoryJPA.findById(id);
        if (product.isPresent()){
            return new ProductResponse().toResponse(product.get());
        }
        throw new DomainException("Id: " + id + " not found in database");
    }
}
