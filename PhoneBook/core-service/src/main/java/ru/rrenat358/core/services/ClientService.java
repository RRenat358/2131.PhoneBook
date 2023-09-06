package ru.rrenat358.core.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.api.exceptions.ResourceNotFoundException;
import ru.rrenat358.core.entities.Client;
import ru.rrenat358.core.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;


    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Клиент не найден для ID : " + id));
    }

    public Client saveNewClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }


    public Optional<Client> findClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    public Optional<Client> findClientByPhone(String phone) {
        return clientRepository.findClientByPhone(phone);
    }


}
