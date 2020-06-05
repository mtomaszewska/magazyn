package pl.mt.magazyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mt.magazyn.dto.ClientDto;
import pl.mt.magazyn.services.ClientService;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    void createClient(@RequestBody ClientDto client){
        clientService.save(client.to());
    }

    @GetMapping
    Set<ClientDto> clients(){
        return clientService.all().stream()
                .map(client -> new ClientDto().from(client)).collect(Collectors.toSet());
    }
}
