package ru.rrenat358.core.converters;

import org.springframework.stereotype.Component;
import ru.rrenat358.api.core.ClientDto;
import ru.rrenat358.core.entities.Client;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientConverter {

    //============================================================
    public ClientDto entityToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName());
    }

    public Client dtoToEntity(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getName());
    }

    //============================================================
    public List<ClientDto> entityToDtoList(List<Client> clientList) {
        List<ClientDto> clientDtoList = clientList
                .stream()
                .map(client -> {
                    ClientDto clientDto = new ClientDto();
                    clientDto.setId(client.getId());
                    clientDto.setName(client.getName());
                    return clientDto;
                })
                .collect(Collectors.toList());
        return clientDtoList;
    }

    public List<Client> dtoToEntityList(List<ClientDto> clientDtoList) {
        List<Client> clientList = clientDtoList
                .stream()
                .map(clientDto -> {
                    Client client = new Client();
                    client.setId(client.getId());
                    client.setName(client.getName());
                    return client;
                })
                .collect(Collectors.toList());
        return clientList;
    }

    //============================================================







}
