package pl.mt.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mt.magazyn.dto.ClientDto;
import pl.mt.magazyn.dto.OrderDto;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.services.ClientService;
import pl.mt.magazyn.services.OrderService;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    public OrderController(OrderService orderService, ClientService clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }

    @PostMapping("client/{clientId}/order")
    void create(@PathVariable Long clientId, @RequestBody OrderDto orderDto, HttpServletResponse response){
        Client client = clientService.findById(clientId);
        if(client != null){
            orderDto.setDate(LocalDateTime.now());
            Order order = orderDto.to();
            order.setClient(client);
            orderService.save(order);
        }else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
