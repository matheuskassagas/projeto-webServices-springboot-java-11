package springWeb.DTO.request;

import springWeb.repositoryJPA.entity.Category;

import javax.validation.constraints.NotBlank;

public class CartegoryRequest {

    @NotBlank
    private String name;

    public CartegoryRequest() {
    }

    public CartegoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
