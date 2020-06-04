package pl.mt.magazyn.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.repositories.ClientRepository;
import pl.mt.magazyn.services.ClientService;

import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        if(client != null){
            return clientRepository.save(client);
        }else{
            throw new IllegalArgumentException("client cannot be null");
        }
    }

    @Override
    public Set<Client> all() {
        return clientRepository.findAll();
    }
}
