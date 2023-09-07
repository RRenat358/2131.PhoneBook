package ru.rrenat358.core.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
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
    public ClientDto findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return clientConverter.entityToDto(client);
    }


    @PostMapping
    @Operation(summary = "Сохранение нового Клиента (без контактов)",
                description = "В RequestBody посылаем только Имя клиента"
    )
    public ClientDto saveNewClient(@RequestBody ClientDto clientDto) {
        Client client = clientConverter.dtoToEntity(clientDto);
        client = clientService.saveNewClient(client);
        return clientConverter.entityToDto(client);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление Клиента по его ID",
               description = "При удалении клиента -- будут удалены все связанные записи в таблицах контактов (Таблицы: Email, Phone, ...)"
    )
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }


    @GetMapping("/client-by-email/{email}")
    @Operation(summary = "Получение Клиента по его Email")
    public ClientDto findClientByEmail(@PathVariable String email) {
        Client client = clientService.findClientByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Клиент не найден для email : " + email));
        return clientConverter.entityToDto(client);
    }

    @GetMapping("/client-by-phone/{phone}")
    @Operation(summary = "Получение Клиента по его Phone")
    public ClientDto findClientByPhone(@PathVariable String phone) {
        Client client = clientService.findClientByPhone(phone)
                .orElseThrow(() -> new ResourceNotFoundException("Клиент не найден для phone : " + phone));
        return clientConverter.entityToDto(client);
    }


}
