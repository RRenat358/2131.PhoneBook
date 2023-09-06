package ru.rrenat358.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.entities.Email;
import ru.rrenat358.core.entities.Phone;
import ru.rrenat358.core.repositories.ClientRepository;
import ru.rrenat358.core.repositories.EmailRepository;
import ru.rrenat358.core.repositories.PhoneRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ClientContactsService {

    private final ClientRepository clientRepository;
    private final EmailRepository emailRepository;
    private final PhoneRepository phoneRepository;


    public Map<String, List<?>> findAllContactsByClientId(Long id) {

        List<Email> emailCollection = emailRepository.findAllEmailByClientId(id);
        List<Phone> phoneCollection = phoneRepository.findAllPhoneByClientId(id);

/*
        stringCollection = emailCollection
                .stream()
                .map( Email::getAddress
                ).toList();

        System.out.println("====================");
        System.out.println(stringCollection);
        System.out.println("====================");
*/

        Map<String, List<?>> emailMap = new HashMap<>();

        emailMap.put("email", emailCollection);
        emailMap.put("phone", phoneCollection);

        return emailMap;
    }


}
