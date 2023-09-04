package ru.rrenat358.api.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {

    private Long id;

    private String name;


/*
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ClientDto() {
    }

    public ClientDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDto(String name) {
        this.name = name;
    }
*/


}
