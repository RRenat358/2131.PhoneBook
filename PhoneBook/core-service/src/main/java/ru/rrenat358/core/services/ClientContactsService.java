package ru.rrenat358.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.converters.EmailConverter;
import ru.rrenat358.core.converters.PhoneConverter;
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
    private final EmailConverter emailConverter;
    private final PhoneConverter phoneConverter;



    public Map<String, List<?>> findAllContactsByClientId(Long id) {

        List<Email> emailList = emailRepository.findAllEmailByClientId(id);
        List<Phone> phoneList = phoneRepository.findAllPhoneByClientId(id);

        Map<String, List<?>> contactsMap = new HashMap<>();
        contactsMap.put("email", emailConverter.entityToDtoList(emailList));
        contactsMap.put("phone", phoneConverter.entityToDtoList(phoneList));

        return contactsMap;
    }



}
