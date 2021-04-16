package com.emt.lab2.backend.Author;

import com.emt.lab2.backend.Country.Country;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Author {
    @Id
    @SequenceGenerator(
            name= "author_sequence",
            sequenceName = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "author_sequence"
    )
    private Long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author(){}

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
