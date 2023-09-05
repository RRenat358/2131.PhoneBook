package ru.rrenat358.core.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.core.converters.EmailConverter;
import ru.rrenat358.core.entities.Email;
import ru.rrenat358.core.services.EmailService;

import java.util.List;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
public class ClientContactsController {

    private final EmailService emailService;
    private final EmailConverter emailConverter;


    @GetMapping("/{id}/email")
    public List<EmailDto> findAllEmailByClientId(@PathVariable Long id) {
        List<Email> emailList = emailService.findAllEmailByClientId(id);
        return emailConverter.entityToDtoList(emailList);
    }





}
