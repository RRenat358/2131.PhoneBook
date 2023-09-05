package ru.rrenat358.core.converters;


import org.springframework.stereotype.Component;
import ru.rrenat358.api.core.EmailDto;
import ru.rrenat358.core.entities.Email;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmailConverter {

    //============================================================
    private EmailDto entityToDto(Email email) {
        return new EmailDto(
                email.getId(),
                email.getAddress(),
                email.getClient_id());
    }

    private Email dtoToEntity(EmailDto emailDto) {
        return new Email(
                emailDto.getId(),
                emailDto.getAddress(),
                emailDto.getClient_id());
    }

    //============================================================
    private List<EmailDto> entityToDtoList(List<Email> emailList) {
        List<EmailDto> emailDtoList = emailList
                .stream()
                .map(email -> new EmailDto(
                        email.getId(),
                        email.getAddress(),
                        email.getClient_id()))
                .collect(Collectors.toList());
        return emailDtoList;
    }

    private List<Email> dtoToEntitList(List<EmailDto> emailDtoList) {
        List<Email> emailList = emailDtoList
                .stream()
                .map(emailDto -> new Email(
                        emailDto.getId(),
                        emailDto.getAddress(),
                        emailDto.getClient_id()
                )).collect(Collectors.toList());
        return emailList;
    }

    //============================================================



}
