package com.emt.lab2.backend.Author;

import lombok.Data;

@Data
public class AuthorDto {
    private String name;
    private String surname;
    private Long countryid;

    public AuthorDto(){}

    public AuthorDto(String name, String surname, Long countryid) {
        this.name = name;
        this.surname = surname;
        this.countryid = countryid;
    }
}
