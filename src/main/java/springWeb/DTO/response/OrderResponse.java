package springWeb.DTO.response;

import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.OrderItem;
import springWeb.repositoryJPA.entity.Payment;
import springWeb.repositoryJPA.entity.User;
import springWeb.repositoryJPA.entity.enums.OrderStatus;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class OrderResponse {


    private Integer id;
    private Instant moment;
    private Integer orderStatus;
    private User client;
    private Set<OrderItem> items = new HashSet<>();
    private Payment payment;

    public OrderResponse() {
    }

    public OrderResponse(Integer id, Instant moment, OrderStatus orderStatus, User client, Set<OrderItem> items, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.orderStatus = orderStatus.getCode();
        this.client = client;
        this.items = items;
        this.payment = payment;
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

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus.getCode();
    }

    public Payment getPayment() {
        return payment;
    }

    public OrderResponse toResponse (Order order){
        return new OrderResponse(order.getId(), order.getMoment(), order.getOrderStatus(), order.getClient(), order.getItems(), order.getPayment());
    }
}
