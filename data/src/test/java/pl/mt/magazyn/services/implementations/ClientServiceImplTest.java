package pl.mt.magazyn.services.implementations;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.repositories.BaseEntityRepository;
import pl.mt.magazyn.repositories.ClientRepository;

class ClientServiceImplTest extends BaseServiceImplTest<Client> {

    @InjectMocks
    ClientServiceImpl clientServiceImpl;

    @Mock
    ClientRepository clientRepository;


    @Override
    Client create() {
        return new Client();
    }

    @Override
    BaseServiceImpl<Client> service() {
        return clientServiceImpl;
    }

    @Override
    BaseEntityRepository<Client> repository() {
        return clientRepository;
    }
}