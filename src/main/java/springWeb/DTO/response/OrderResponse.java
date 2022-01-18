package springWeb.DTO.response;

import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.User;

import java.time.Instant;

public class OrderResponse {


    private Integer id;
    private Instant moment;
    private User client;

    public OrderResponse() {
    }

    public OrderResponse(Integer id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderResponse toResponse (Order order){
        return new OrderResponse(order.getId(), order.getMoment(), order.getClient());
    }
}
