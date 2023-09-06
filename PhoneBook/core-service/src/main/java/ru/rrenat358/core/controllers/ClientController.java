package ru.rrenat358.core.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.ClientDto;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.api.exceptions.ResourceNotFoundException;
import ru.rrenat358.core.converters.ClientConverter;
import ru.rrenat358.core.converters.EmailConverter;
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
    private final EmailConverter emailConverter;


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


    @GetMapping("/client-by-email/{email}")
    public ClientDto findClientByEmail(@PathVariable String email) {
        Client client = clientService.findClientByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Клиент не найден для email : " + email));
        return clientConverter.entityToDto(client);
    }

    @GetMapping("/client-by-phone/{phone}")
    public ClientDto findClientByPhone(@PathVariable String phone) {
        Client client = clientService.findClientByPhone(phone)
                .orElseThrow(() -> new ResourceNotFoundException("Клиент не найден для phone : " + phone));
        return clientConverter.entityToDto(client);
    }






}
