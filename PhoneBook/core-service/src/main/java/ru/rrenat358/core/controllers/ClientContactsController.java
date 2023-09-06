package ru.rrenat358.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.api.core.PhoneDto;
import ru.rrenat358.core.converters.EmailConverter;
import ru.rrenat358.core.converters.PhoneConverter;
import ru.rrenat358.core.entities.Email;
import ru.rrenat358.core.entities.Phone;
import ru.rrenat358.core.services.ClientContactsService;
import ru.rrenat358.core.services.EmailService;
import ru.rrenat358.core.services.PhoneService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientContactsController {

    private final EmailService emailService;
    private final PhoneService phoneService;
    private final ClientContactsService clientContactsService;
    private final EmailConverter emailConverter;
    private final PhoneConverter phoneConverter;


    @GetMapping("/{id}/email")
    public List<EmailDto> findAllEmailByClientId(@PathVariable Long id) {
        List<Email> emailList = emailService.findAllEmailByClientId(id);
        return emailConverter.entityToDtoList(emailList);
    }

    @GetMapping("/{id}/phone")
    public List<PhoneDto> findAllPhoneByClientId(@PathVariable Long id) {
        List<Phone> phoneList = phoneService.findAllPhoneByClientId(id);
        return phoneConverter.entityToDtoList(phoneList);
    }

    @GetMapping("/{id}/contacts")
    public Collection<String> findAllContactsByClientId(@PathVariable Long id) {
        Collection<String> contactCollection  = clientContactsService.findAllContactsByClientId(id);
        return contactCollection;
    }


}
