package pl.mt.magazyn.dto;

import pl.mt.magazyn.models.Client;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClientDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private Set<OrderDto> orders = new HashSet<>();

    public Client to(){
        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setAddress(address);
        client.setOrders(orders.stream().map(OrderDto::to)
                .collect(Collectors.toSet()));
        return client;
    }

    public ClientDto from(Client client) {
        this.setId(client.getId());
        this.setFirstName(client.getFirstName());
        this.setLastName(client.getLastName());
        this.setAddress(client.getAddress());
        this.setOrders(client.getOrders().stream()
                .map(order -> new OrderDto().from(order)).collect(Collectors.toSet()));
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }



}
