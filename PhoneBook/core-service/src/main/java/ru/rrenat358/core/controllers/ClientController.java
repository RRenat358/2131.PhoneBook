package ru.rrenat358.core.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.services.ClientService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {


    private final ClientService clientService;

    @GetMapping
    public List<Client> findAllClient(){
        return clientService.findAll();
    }



}
