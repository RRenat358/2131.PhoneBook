package ru.rrenat358.core.converters;

import org.springframework.stereotype.Component;
import ru.rrenat358.api.core.ClientDto;
import ru.rrenat358.core.entities.Client;

@Component
public class ClientConverter {

    //============================================================
    public Client dtoToEntity(ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getName(),
                clientDto.getEmailList(),
                clientDto.getPhoneList());
    }

    public ClientDto entityToDto(Client client) {
        return new ClientDto(
                client.getId(),
                client.getName(),
                client.getEmailList(),
                client.getPhoneList());
    }



}
