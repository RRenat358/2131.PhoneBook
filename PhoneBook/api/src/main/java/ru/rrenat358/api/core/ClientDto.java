package ru.rrenat358.api.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ClientDto {

    private Long id;

    private String name;

    private List<EmailDto> emailList;

    private List<PhoneDto> phoneList;


    public ClientDto(Long id, String name, List<EmailDto> emailList, List<PhoneDto> phoneList) {


    }
}
