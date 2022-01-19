package springWeb.DTO.response;

import springWeb.repositoryJPA.entity.Category;

public class CategoryResponse {

    private Integer id;
    private String name;

    public CategoryResponse() {
    }

    public CategoryResponse(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public CategoryResponse toResponse (Category category){
        return new CategoryResponse(category.getId(), category.getName());
    }
}
