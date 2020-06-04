package pl.mt.magazyn.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.services.ClientService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    ClientService clientService;

    @InjectMocks
    ClientController clientController;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    void createClient() throws Exception {
        //given
        Client expected = new Client();
        when(clientService.save(expected)).thenReturn(expected);
        //when
        this.mockMvc.perform(post("/clients").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expected)))
                .andExpect(status().isOk());
        //then
        verify(clientService, times(1)).save(any());
    }

    @Test
    void clients() throws Exception {
        //given
        Set<Client> expected = new HashSet<>();
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        expected.add(client1);
        expected.add(client2);
        expected.add(client3);
        //when
        when(clientService.all()).thenReturn(expected);
        //then
        MvcResult actual = this.mockMvc.perform(get("/clients"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expected.size(), objectMapper
                        .readValue(actual.getResponse().getContentAsString(), List.class).size());
    }
}