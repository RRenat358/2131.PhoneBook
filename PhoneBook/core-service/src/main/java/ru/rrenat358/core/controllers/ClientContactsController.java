package ru.rrenat358.core.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.api.core.PhoneDto;
import ru.rrenat358.core.converters.EmailConverter;
import ru.rrenat358.core.converters.PhoneConverter;
import ru.rrenat358.core.entities.Email;
import ru.rrenat358.core.entities.Phone;
import ru.rrenat358.core.services.ClientContactsService;
import ru.rrenat358.core.services.EmailService;
import ru.rrenat358.core.services.PhoneService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/clients")
@RequiredArgsConstructor
@Tag(name = "Контакты клиента", description = "Методы работы с Контактами клиента")
public class ClientContactsController {

    private final EmailService emailService;
    private final PhoneService phoneService;
    private final ClientContactsService clientContactsService;
    private final EmailConverter emailConverter;
    private final PhoneConverter phoneConverter;


    @GetMapping("/{id}/email")
    @Operation(summary = "Получение всех Email, связанных с Клиентом по его ClientID")
    public List<EmailDto> findAllEmailByClientId(@PathVariable @Parameter(description = "id клиента") Long id) {
        List<Email> emailList = emailService.findAllEmailByClientId(id);
        return emailConverter.entityToDtoList(emailList);
    }

    @GetMapping("/{id}/phone")
    @Operation(summary = "Получение всех Phone, связанных с Клиентом по его ClientID")
    public List<PhoneDto> findAllPhoneByClientId(@PathVariable @Parameter(description = "id клиента") Long id) {
        List<Phone> phoneList = phoneService.findAllPhoneByClientId(id);
        return phoneConverter.entityToDtoList(phoneList);
    }

    @GetMapping("/{id}/contacts")
    @Operation(summary = "Получение всех контактов (Email, Phone, ..), связанных с Клиентом по его ClientID")
    public Map<String, List<?>> findAllContactsByClientId(@PathVariable @Parameter(description = "id клиента") Long id) {
        Map<String, List<?>> contactCollection = clientContactsService.findAllContactsByClientId(id);
        return contactCollection;
    }

    @PostMapping("/{id}/email/{email}")
    @Operation(summary = "Сохранение Email, для Клиента по его ClientID")
    public void saveEmailByClientId(@PathVariable @Parameter(description = "id клиента") Long id,
                                    @PathVariable @Parameter(description = "Email клиента") String email) {
        emailService.saveEmailByClientId(id, email);
    }

    @PostMapping("/{id}/phone/{number}")
    @Operation(summary = "Сохранение Phone, для Клиента по его ClientID")
    public void savePhoneByClientId(@PathVariable @Parameter(description = "id клиента") Long id,
                                    @PathVariable @Parameter(description = "Phone клиента") String number) {
        phoneService.savePhoneByClientId(id, number);
    }






    @DeleteMapping("/{clientId}/email/{emailId}")
    @Operation(summary = "Удаление Email по ID, для Клиента по его ClientID")
    public void deleteEmailByIdByClientId(@PathVariable @Parameter(description = "id клиента") Long clientId,
                                    @PathVariable @Parameter(description = "Email клиента") Long emailId) {
        emailService.deleteEmailByIdByClientId(clientId, emailId);
    }

    @DeleteMapping("/{clientId}/phone/{phoneId}")
    @Operation(summary = "Удаление Phone по ID, для Клиента по его ClientID")
    public void deletePhoneByIdByClientId(@PathVariable @Parameter(description = "id клиента") Long clientId,
                                    @PathVariable @Parameter(description = "Phone клиента") Long phoneId) {
        phoneService.deletePhoneByIdByClientId(clientId, phoneId);
    }

    @DeleteMapping("/{id}/email")
    @Operation(summary = "Удаление ВСЕХ Email, для Клиента по его ClientID")
    public void deleteAllEmailByClientId(@PathVariable @Parameter(description = "id клиента") Long id) {
        emailService.deleteAllEmailByClientId(id);
    }

    @DeleteMapping("/{id}/phone")
    @Operation(summary = "Удаление ВСЕХ Phone, для Клиента по его ClientID")
    public void deleteAllPhoneByClientId(@PathVariable @Parameter(description = "id клиента") Long id) {
        phoneService.deleteAllPhoneByClientId(id);
    }


}
