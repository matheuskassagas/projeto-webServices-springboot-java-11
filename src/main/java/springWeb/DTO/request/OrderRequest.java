package springWeb.DTO.request;

import springWeb.repositoryJPA.entity.Order;
import springWeb.repositoryJPA.entity.User;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

public class OrderRequest {

    private Instant moment;
    @NotBlank
    private Integer client_id;

    public OrderRequest() {
    }

    public OrderRequest(Instant moment, Integer client_id) {
        this.moment = moment;
        this.client_id = client_id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }
}
