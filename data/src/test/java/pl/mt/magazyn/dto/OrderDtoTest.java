package pl.mt.magazyn.dto;

import org.junit.jupiter.api.Test;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.models.Order;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderDtoTest {

    @Test
    void from() {
        //given
        Order order = new Order();
        order.setId(12L);
        Client client = new Client();
        client.setId(1L);
        order.setClient(client);
        order.setDate(LocalDateTime.now());
        //when
        OrderDto orderDto = new OrderDto().from(order);
        //then
        assertEquals(order.getId(), orderDto.getId());
        assertEquals(order.getClient().getId(), orderDto.getClient().getId());
        assertEquals(order.getDate(), orderDto.getDate());
    }

    @Test
    void to() {
        //given
        OrderDto orderDto = new OrderDto();
        orderDto.setId(1L);
        ClientDto clientDto = new ClientDto();
        clientDto.setId(2L);
        orderDto.setClient(clientDto);
        orderDto.setDate(LocalDateTime.now());
        //when
        Order order = orderDto.to();
        //then
        assertEquals(orderDto.getId(), order.getId());
        assertEquals(orderDto.getClient().getId(), order.getClient().getId());
        assertEquals(orderDto.getDate(), order.getDate());
    }
}