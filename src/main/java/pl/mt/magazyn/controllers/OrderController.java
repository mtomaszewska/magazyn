package pl.mt.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mt.magazyn.dto.OrderDto;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.services.ClientService;
import pl.mt.magazyn.services.OrderService;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@RestController
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @Autowired
    private final ClientService clientService;

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
