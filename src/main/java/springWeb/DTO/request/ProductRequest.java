package springWeb.DTO.request;

import springWeb.repositoryJPA.entity.Product;

import javax.validation.constraints.NotBlank;

public class ProductRequest {

    @NotBlank
    private String name;
    private String descricao;
    @NotBlank
    private Double price;
    private String imgUrl;

    public ProductRequest() {
    }

    public ProductRequest(String name, String descricao, Double price, String imgUrl) {
        this.name = name;
        this.descricao = descricao;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Product toModel(ProductRequest productRequest){
        return new Product(productRequest.getName(), productRequest.getDescricao(), productRequest.getPrice(), productRequest.getImgUrl());
    }
}
