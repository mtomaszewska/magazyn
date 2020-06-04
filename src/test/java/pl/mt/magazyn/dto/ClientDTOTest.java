package pl.mt.magazyn.dto;

import org.junit.jupiter.api.Test;
import pl.mt.magazyn.models.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientDTOTest {

    @Test
    void toClient() {
        //given
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(1L);
        clientDTO.setFirstName("FIRST_NAME");
        clientDTO.setLastName("LAST_NAME");
        clientDTO.setAddress("ADDRESS");
        //when
        Client client = clientDTO.toClient();
        //then
        assertEquals(clientDTO.getId(), client.getId());
        assertEquals(clientDTO.getFirstName(), client.getFirstName());
        assertEquals(clientDTO.getLastName(), client.getLastName());
        assertEquals(clientDTO.getAddress(), client.getAddress());
    }

    @Test
    void fromClient() {
        //given
        Client client = new Client();
        client.setId(1L);
        client.setFirstName("FIRST_NAME");
        client.setLastName("LAST_NAME");
        client.setAddress("ADDRESS");
        //when
        ClientDTO clientDTO = new ClientDTO().fromClient(client);
        //then
        assertEquals(client.getId(), clientDTO.getId());
        assertEquals(client.getFirstName(), clientDTO.getFirstName());
        assertEquals(client.getLastName(), clientDTO.getLastName());
        assertEquals(client.getAddress(), clientDTO.getAddress());
    }
}