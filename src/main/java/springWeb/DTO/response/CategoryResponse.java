package springWeb.DTO.response;

import springWeb.repositoryJPA.entity.Category;
import springWeb.repositoryJPA.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class CategoryResponse {

    private Integer id;
    private String name;
    private Set<Product> products = new HashSet<>();

    public CategoryResponse() {
    }

    public CategoryResponse(Integer id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public CategoryResponse toResponse (Category category){
        return new CategoryResponse(category.getId(), category.getName(), category.getProducts());
    }
}
