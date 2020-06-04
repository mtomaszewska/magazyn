package pl.mt.magazyn.repositories;

import pl.mt.magazyn.models.Client;

import java.util.Set;

public interface ClientRepository extends BaseEntityRepository<Client> {
    Set<Client> findAll();
    Client save(Client client);
}
