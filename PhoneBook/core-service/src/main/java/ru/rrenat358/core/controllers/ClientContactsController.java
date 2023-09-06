package ru.rrenat358.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.ClientDto;
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
import java.util.Map;

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
    public Map<String, List<?>> findAllContactsByClientId(@PathVariable Long id) {
        Map<String, List<?>> contactCollection  = clientContactsService.findAllContactsByClientId(id);
        return contactCollection;
    }

    @PostMapping("/{id}/email/{email}")
    public void saveEmailByClientId(@PathVariable Long id, @PathVariable String email) {
        emailService.saveEmailByClientId(id,email);
    }

    @PostMapping("/{id}/phone/{number}")
    public void savePhoneByClientId(@PathVariable Long id, @PathVariable String number) {
        phoneService.savePhoneByClientId(id,number);
    }


    @DeleteMapping("/{id}/email")
    public void deleteAllEmailByClientId(@PathVariable Long id) {
        emailService.deleteAllEmailByClientId(id);
    }

    @DeleteMapping("/{id}/phone")
    public void deleteAllPhoneByClientId(@PathVariable Long id) {
        phoneService.deleteAllPhoneByClientId(id);
    }





}
