package pl.mt.magazyn.dto;

import pl.mt.magazyn.models.Order;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderDto {
    private Long id;
    private LocalDateTime date;
    private Set<OrderElementDto> elements = new HashSet<>();
    private ClientDto client;

    public OrderDto from(Order order) {
        this.setId(order.getId());
        this.setDate(order.getDate());
        this.setElements(order.getOrderElements().stream()
                .map(element -> new OrderElementDto().from(element)).collect(Collectors.toSet()));
        this.setClient(new ClientDto().from(order.getClient()));
        return this;
    }

    public Order to() {
        Order order = new Order();
        order.setId(this.getId());
        order.setDate(this.getDate());
        order.setOrderElements(this.getElements().stream()
            .map(OrderElementDto::to).collect(Collectors.toSet()));
        if(this.getClient() != null) {
            order.setClient(this.getClient().to());
        }
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Set<OrderElementDto> getElements() {
        return elements;
    }

    public void setElements(Set<OrderElementDto> elements) {
        this.elements = elements;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
