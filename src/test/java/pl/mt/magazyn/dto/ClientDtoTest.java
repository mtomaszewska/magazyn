package pl.mt.magazyn.dto;

import org.junit.jupiter.api.Test;
import pl.mt.magazyn.models.Client;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientDtoTest {

    @Test
    void to() {
        //given
        ClientDto clientDTO = new ClientDto();
        clientDTO.setId(1L);
        clientDTO.setFirstName("FIRST_NAME");
        clientDTO.setLastName("LAST_NAME");
        clientDTO.setAddress("ADDRESS");
        clientDTO.setOrders(new HashSet<>());
        //when
        Client client = clientDTO.to();
        //then
        assertEquals(clientDTO.getId(), client.getId());
        assertEquals(clientDTO.getFirstName(), client.getFirstName());
        assertEquals(clientDTO.getLastName(), client.getLastName());
        assertEquals(clientDTO.getAddress(), client.getAddress());
    }

    @Test
    void from() {
        //given
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("FIRST_NAME");
        client.setLastName("LAST_NAME");
        client.setAddress("ADDRESS");
        client.setOrders(new HashSet<>());
        //when
        ClientDto clientDTO = new ClientDto().from(client);
        //then
        assertEquals(client.getId(), clientDTO.getId());
        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getAddress(), clientDTO.getAddress());
    }
}