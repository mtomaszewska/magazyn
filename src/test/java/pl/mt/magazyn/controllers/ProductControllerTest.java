package pl.mt.magazyn.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.models.Product;
import pl.mt.magazyn.services.ClientService;
import pl.mt.magazyn.services.ProductService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void products() throws Exception {
        //given
        Set<Product> expected = new HashSet<>();
        Product product1 = new Product();
        Product product2 = new Product();
        expected.add(product1);
        expected.add(product2);
        //when
        when(productService.all()).thenReturn(expected);
        //then
        MvcResult actual = this.mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expected.size(), objectMapper
                        .readValue(actual.getResponse().getContentAsString(), List.class).size());
    }
}