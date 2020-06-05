package pl.mt.magazyn.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.models.OrderElement;
import pl.mt.magazyn.models.Product;
import pl.mt.magazyn.services.ClientService;
import pl.mt.magazyn.services.OrderService;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    ClientService clientService;
    @Mock
    OrderService orderService;

    @InjectMocks
    OrderController orderController;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void create() throws Exception {

        //given
        Client client = new Client();
        client.setId(1L);
        when(clientService.findById(client.getId())).thenReturn(client);
        Order expected = new Order();
        expected.setOrderElements(new HashSet<>());
        expected.getOrderElements().add(new OrderElement());
        //when
        this.mockMvc.perform(post("/client/"+ client.getId()+"/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expected)))
                .andExpect(status().isOk());
        //then
        verify(clientService, times(1)).findById(client.getId());
        verify(orderService, times(1)).save(any());
    }
}