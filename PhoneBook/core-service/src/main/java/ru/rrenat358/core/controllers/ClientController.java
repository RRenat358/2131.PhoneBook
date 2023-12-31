package ru.rrenat358.core.controllers;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.ClientDto;
import ru.rrenat358.api.exceptions.ResourceNotFoundException;
import ru.rrenat358.core.converters.ClientConverter;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.services.ClientService;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
@Tag(name = "Клиент", description = "Методы работы с Клиентом")
@OpenAPIDefinition
public class ClientController {

    private final ClientService clientService;
    private final ClientConverter clientConverter;


    @GetMapping
    @Operation(summary = "Список всех Клиентов")
    public List<ClientDto> findAllClients() {
        List<Client> clientList = clientService.findAll();
        return clientConverter.entityToDtoList(clientList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение Клиента по его ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "клиент найден"),
            @ApiResponse(responseCode = "404", description = "404 Not found -- Клиент для данного ID - НЕ найден"),
            @ApiResponse(responseCode = "500", description = "500 -- Клиент для данного ID - Возможно НЕ найден") //todo !следует обработать
    })
    public ClientDto findById(@PathVariable("id") @Parameter(description = "id клиента") Long id) {
        Client client = clientService.findById(id);
        return clientConverter.entityToDto(client);
    }


    @PostMapping
    @Operation(summary = "Сохранение нового Клиента (без контактов)",
                description = "В RequestBody посылаем только Имя клиента"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "клиент сохранён"),
    })
    @Parameter(name = "Имя клиента", description = "Имя для нового клиента передавать в json, без ID: \n { \"name\": \"Viktor\"}")
    public ClientDto saveNewClient(@RequestBody ClientDto clientDto) {
        Client client = clientConverter.dtoToEntity(clientDto);
        client = clientService.saveNewClient(client);
        return clientConverter.entityToDto(client);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление Клиента по его ID",
               description = "При удалении клиента -- будут удалены все связанные записи в таблицах контактов (Таблицы: Email, Phone, ...)"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "клиент удалён"),
    })
    public void deleteById(@PathVariable @Parameter(description = "id клиента") Long id) {
        clientService.deleteById(id);
    }


    @GetMapping("/client-by-email/{email}")
    @Operation(summary = "Получение Клиента по его Email")
    public ClientDto findClientByEmail(@PathVariable @Parameter(description = "Email клиента") String email) {
        Client client = clientService.findClientByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Клиент не найден для email : " + email));
        return clientConverter.entityToDto(client);
    }

    @GetMapping("/client-by-phone/{phone}")
    @Operation(summary = "Получение Клиента по его Phone")
    public ClientDto findClientByPhone(@PathVariable @Parameter(description = "Phone клиента") String phone) {
        Client client = clientService.findClientByPhone(phone)
                .orElseThrow(() -> new ResourceNotFoundException("Клиент не найден для phone : " + phone));
        return clientConverter.entityToDto(client);
    }


}
