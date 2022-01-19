package springWeb.DTO.response;

import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.User;
import springWeb.repositoryJPA.entity.enums.OrderStatus;

import java.time.Instant;

public class OrderResponse {


    private Integer id;
    private Instant moment;
    private Integer orderStatus;
    private User client;

    public OrderResponse() {
    }

    public OrderResponse(Integer id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
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

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    public OrderResponse toResponse (Order order){
        return new OrderResponse(order.getId(), order.getMoment(), order.getOrderStatus(), order.getClient());
    }
}
