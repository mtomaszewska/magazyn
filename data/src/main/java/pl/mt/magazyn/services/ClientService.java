package pl.mt.magazyn.services;

import pl.mt.magazyn.models.Client;

import java.util.Set;

public interface ClientService {
    Client save(Client client);
    Set<Client> all();
}
