package ru.rrenat358.core.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.ClientDto;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.core.converters.ClientConverter;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.entities.Email;
import ru.rrenat358.core.services.ClientService;
import ru.rrenat358.core.services.EmailService;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final EmailService emailService;
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


/*
    @GetMapping("/{id}/email")
    public List<Email> findAllEmailByClientId(@PathVariable Long id) {
        List<Email> emailList = emailService.findAllEmailByClientId(id);
        return emailList;
    }
*/

/*
    @GetMapping("/2/email")
    public List<Email> findAllEmailByClientId() {
        List<Email> emailList = emailService.findAllEmailByClientId(2L);
        return emailList;
    }
*/


    @GetMapping("/2/email")
    public List<EmailDto> findAllEmailByClientId() {
        List<EmailDto> emailList = emailService.findAllEmailByClientId(2L);
        return emailList;
    }


}
