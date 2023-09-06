package ru.rrenat358.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.entities.Email;
import ru.rrenat358.core.repositories.ClientRepository;
import ru.rrenat358.core.repositories.EmailRepository;
import ru.rrenat358.core.repositories.PhoneRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientContactsService {

    private final ClientRepository clientRepository;
    private final EmailRepository emailRepository;
    private final PhoneRepository phoneRepository;


    public Collection<String> findAllContactsByClientId(Long id) {
        Collection<String> stringCollection = new ArrayList<>();

        List<Email> emailCollection = emailRepository.findAllEmailByClientId(id);

//        stringCollection.addAll(emailRepository.findAllEmailByClientId(id));

        stringCollection = emailCollection
                .stream()
                .map( Email::getAddress

                ).toList();


//                .collect(Collectors.toList());

//        emailRepository.findAllEmailByClientId(id).stream().map(String -> stringCollection);

        return stringCollection;
    }


}
