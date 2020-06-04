package pl.mt.magazyn.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.repositories.ClientRepository;
import pl.mt.magazyn.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(Client client) {
        if(client != null){
            clientRepository.save(client);
        }else{
            throw new IllegalArgumentException("client cannot be null");
        }
    }
}
