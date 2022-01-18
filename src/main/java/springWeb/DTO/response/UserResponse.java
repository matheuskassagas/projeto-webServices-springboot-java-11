package springWeb.DTO.response;

import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.User;

import java.util.List;

public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private String phone;
    private List<Order> order;

    public UserResponse() {
    }

    public UserResponse(Integer id, String name, String email, String phone, List<Order> order) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.order = order;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public UserResponse toReponse (User user){
        return new UserResponse(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getOrders());
    }
}
