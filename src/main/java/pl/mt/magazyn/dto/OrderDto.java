package pl.mt.magazyn.dto;

import pl.mt.magazyn.models.Order;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderDto {
    private Long id;
    private LocalDateTime date;
    private Set<ProductDto> products = new HashSet<>();
    private ClientDto client;

    public OrderDto from(Order order) {
        this.setId(order.getId());
        this.setDate(order.getDate());
        this.setProducts(order.getProducts().stream()
                .map(product -> new ProductDto().from(product)).collect(Collectors.toSet()));
        this.setClient(new ClientDto().from(order.getClient()));
        return this;
    }

    public Order to() {
        Order order = new Order();
        order.setId(this.getId());
        order.setDate(this.getDate());
        order.setProducts(this.getProducts().stream()
            .map(ProductDto::to).collect(Collectors.toSet()));
        order.setClient(this.getClient().to());
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

    public Set<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDto> products) {
        this.products = products;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }
}
