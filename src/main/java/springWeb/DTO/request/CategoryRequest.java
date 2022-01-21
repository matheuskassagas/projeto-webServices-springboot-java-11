package springWeb.DTO.request;

import springWeb.repositoryJPA.entity.Category;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    private String name;

    public CategoryRequest() {
    }

    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toModel (CategoryRequest categoryRequest){
        return new Category(categoryRequest.getName());
    }
}
