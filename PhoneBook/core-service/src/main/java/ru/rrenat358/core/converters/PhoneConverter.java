package ru.rrenat358.core.converters;


import org.springframework.stereotype.Component;
import ru.rrenat358.api.core.PhoneDto;
import ru.rrenat358.core.entities.Phone;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhoneConverter {

    //============================================================
    public PhoneDto entityToDto(Phone phone) {
        return new PhoneDto(
                phone.getId(),
                phone.getNumber(),
                phone.getClient_id());
    }

    public Phone dtoToEntity(PhoneDto phoneDto) {
        return new Phone(
                phoneDto.getId(),
                phoneDto.getNumber(),
                phoneDto.getClient_id());
    }

    //============================================================
    public List<PhoneDto> entityToDtoList(List<Phone> phoneList) {
        List<PhoneDto> phoneDtoList = phoneList
                .stream()
                .map(phone -> new PhoneDto(
                        phone.getId(),
                        phone.getNumber(),
                        phone.getClient_id()
                ))
                .collect(Collectors.toList());
        return phoneDtoList;
    }

    public List<Phone> dtoToEntitList(List<PhoneDto> phoneDtoList) {
        List<Phone> phoneList = phoneDtoList
                .stream()
                .map(phoneDto -> new Phone(
                        phoneDto.getId(),
                        phoneDto.getNumber(),
                        phoneDto.getClient_id()
                )).collect(Collectors.toList());
        return phoneList;
    }

    //============================================================


}
