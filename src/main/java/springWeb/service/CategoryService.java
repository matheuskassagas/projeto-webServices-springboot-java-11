package springWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import springWeb.DTO.request.CategoryRequest;
import springWeb.DTO.request.ProductRequest;
import springWeb.DTO.response.CategoryResponse;
import springWeb.DTO.response.OrderResponse;
import springWeb.exception.DomainException;
import springWeb.repositoryJPA.CategoryRepositoryJPA;
import springWeb.repositoryJPA.OrderRepositoryJPA;
import springWeb.repositoryJPA.entity.Category;
import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.Product;
import springWeb.service.exception.DataBaseException;
import springWeb.service.exception.ResourceNotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepositoryJPA categoryRepositoryJPA;

    public List<CategoryResponse> findAll(){
        return categoryRepositoryJPA.findAll().stream().map(category -> new CategoryResponse().toResponse(category)).collect(Collectors.toList());
    }

    public CategoryResponse findById(Integer id) throws Exception{
        Optional<Category> category = categoryRepositoryJPA.findById(id);

        if(category.isPresent()){
            return new CategoryResponse().toResponse(category.get());
        }
        throw new DomainException("Id: " + id + " not found in database");

    }

    public Category create (CategoryRequest categoryRequest){
        Category categoryJpa = categoryRequest.toModel(categoryRequest);
        return categoryRepositoryJPA.save(categoryJpa);
    }

    public void delete (Integer id){
        try{
            categoryRepositoryJPA.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Category update (Integer id, CategoryRequest categoryRequest){
        try{
            Category entity = categoryRepositoryJPA.getById(id);//nao vai no banco de dados, só deixa um objeto monitorado pelo jpa para trabalhar com ele e depois efetuar a operação no bd
            updateDate(entity, categoryRequest);
            return categoryRepositoryJPA.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(Category entity, CategoryRequest categoryRequest) {
        entity.setName(categoryRequest.getName());
    }
}
