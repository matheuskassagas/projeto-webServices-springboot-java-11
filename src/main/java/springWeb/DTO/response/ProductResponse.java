package springWeb.DTO.response;

import springWeb.repositoryJPA.entity.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductResponse {

    private Integer id;
    private String name;
    private String descricao;
    private Double price;
    private String imgUrl;

    public ProductResponse() {
    }

    public ProductResponse(Integer id, String name, String descricao, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public ProductResponse toResponse (Product product){
        return new ProductResponse(product.getId(), product.getName(), product.getDescricao(), product.getPrice(), product.getImgUrl());
    }
}
