package ru.rrenat358.core.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.repositories.ClientRepository;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Collection<Client> findAll() {
        return clientRepository.findAll();
    }


}
