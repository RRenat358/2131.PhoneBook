package ru.rrenat358.core.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.repositories.ClientRepository;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }


}
