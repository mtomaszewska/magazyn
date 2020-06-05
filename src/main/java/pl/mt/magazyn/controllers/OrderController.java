package pl.mt.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mt.magazyn.dto.ClientDto;
import pl.mt.magazyn.dto.OrderDto;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.services.ClientService;
import pl.mt.magazyn.services.OrderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ClientService clientService;

    public OrderController(OrderService orderService, ClientService clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @PostMapping("client/{clientId}/order")
    public void create(@PathVariable Long clientId, @RequestBody OrderDto orderDto){
        Client client = clientService.findById(clientId);
        if(client != null){
            orderDto.setDate(LocalDateTime.now());
            Order order = orderDto.to();
            order.setClient(client);
            orderService.save(order);
        }else {
            throw new IllegalArgumentException("client does not exist");
        }
    }
}
