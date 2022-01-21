package springWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springWeb.DTO.response.CategoryResponse;
import springWeb.DTO.response.OrderResponse;
import springWeb.exception.DomainException;
import springWeb.repositoryJPA.CategoryRepositoryJPA;
import springWeb.repositoryJPA.OrderRepositoryJPA;
import springWeb.repositoryJPA.entity.Category;
import springWeb.repositoryJPA.entity.Order;

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
}
