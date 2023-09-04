package ru.rrenat358.core.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.api.core.ClientDto;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {


    private final ClientService clientService;

/*
    @GetMapping
    public List<ClientDto> findAllClients() {
        return clientService.findAll();
    }
*/
    @GetMapping
    public List<Client> findAllClients() {
        return clientService.findAll();
    }


}
