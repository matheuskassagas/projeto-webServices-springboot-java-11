package springWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import springWeb.DTO.request.ProductRequest;
import springWeb.DTO.request.UserRequest;
import springWeb.DTO.response.ProductResponse;
import springWeb.exception.DomainException;
import springWeb.repositoryJPA.ProductRepositoryJPA;
import springWeb.repositoryJPA.entity.Product;
import springWeb.repositoryJPA.entity.User;
import springWeb.service.exception.DataBaseException;
import springWeb.service.exception.ResourceNotFoundException;

import javax.persistence.EntityNotFoundException;
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

    public Product create (ProductRequest productRequest){
        Product productJpa = productRequest.toModel(productRequest);
        return productRepositoryJPA.save(productJpa);
    }

    public void delete (Integer id){
        try{
            productRepositoryJPA.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Product update (Integer id, ProductRequest productRequest){
        try{
            Product entity = productRepositoryJPA.getById(id);//nao vai no banco de dados, só deixa um objeto monitorado pelo jpa para trabalhar com ele e depois efetuar a operação no bd
            updateDate(entity, productRequest);
            return productRepositoryJPA.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(Product entity, ProductRequest productRequest) {
        entity.setName(productRequest.getName());
        entity.setDescricao(productRequest.getDescricao());
        entity.setPrice(productRequest.getPrice());
        entity.setImgUrl(productRequest.getImgUrl());
    }
}
