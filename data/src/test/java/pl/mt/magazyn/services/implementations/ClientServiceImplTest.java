package pl.mt.magazyn.services.implementations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.repositories.ClientRepository;
import pl.mt.magazyn.services.ClientService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceImplTest {

    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @Mock
    ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        //given
        Client expected = new Client();
        when(clientRepository.save(expected)).thenReturn(expected);
        //when
        Client actual = clientServiceImpl.save(expected);
        //then
        assertEquals(actual, expected);
        verify(clientRepository, times(1)).save(expected);
    }

    @Test
    void saveNull() {
        //given
        //when
        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> clientServiceImpl.save(null));
    }

    @Test
    void all() {
        //given
        Set<Client> expected = new HashSet<>();
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        expected.add(client1);
        expected.add(client2);
        expected.add(client3);
        when(clientRepository.findAll()).thenReturn(expected);
        //when
        Set<Client> actual = clientServiceImpl.all();
        //then
        assertEquals(actual, expected);

    }
}