package pl.mt.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mt.magazyn.dto.ClientDTO;
import pl.mt.magazyn.services.ClientService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    void createClient(@RequestBody ClientDTO client){
        clientService.save(client.toClient());
    }

    @GetMapping
    Set<ClientDTO> clients(){
        return clientService.all().stream()
                .map(client -> new ClientDTO().fromClient(client)).collect(Collectors.toSet());
    }
}
