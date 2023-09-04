package ru.rrenat358.core.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.ClientDto;
import ru.rrenat358.core.converters.ClientConverter;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final ClientConverter clientConverter;


    @GetMapping
    public List<ClientDto> findAllClients() {
        List<Client> clientList = clientService.findAll();
        return clientConverter.entityToDtoList(clientList);
    }

    @GetMapping("/{id}")
    public ClientDto findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return clientConverter.entityToDto(client);
    }


    @PostMapping
    public ClientDto saveNewClient(@RequestBody ClientDto clientDto) {
        Client client = clientConverter.dtoToEntity(clientDto);
        client = clientService.saveNewClient(client);
        return clientConverter.entityToDto(client);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }



}
