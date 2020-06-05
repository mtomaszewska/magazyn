package pl.mt.magazyn.services.implementations;

import org.springframework.stereotype.Service;
import pl.mt.magazyn.models.Client;
import pl.mt.magazyn.repositories.BaseEntityRepository;
import pl.mt.magazyn.services.ClientService;

@Service
public class ClientServiceImpl extends BaseServiceImpl<Client> implements ClientService {


    public ClientServiceImpl(BaseEntityRepository<Client> repository) {
        super(repository);
    }

    @Override
    public Client findById(Long clientId) {
        return repository.findById(clientId).orElse(null);
    }
}
