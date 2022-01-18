package springWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springWeb.DTO.response.OrderResponse;
import springWeb.DTO.response.UserResponse;
import springWeb.exception.DomainException;
import springWeb.repositoryJPA.OrderRepositoryJPA;
import springWeb.repositoryJPA.UserRepositoryJPA;
import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepositoryJPA orderRepositoryJPA;

    public List<OrderResponse> findAll(){
        return orderRepositoryJPA.findAll().stream().map(order -> new OrderResponse().toResponse(order)).collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) throws Exception{
        Optional<Order> order = orderRepositoryJPA.findById(id);

        if(order.isPresent()){
            return new OrderResponse().toResponse(order.get());
        }else{
            throw new DomainException("Id: " + id + " not found in database");
        }
    }
}
