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
//    private Long countryId;

    public Author(){}

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public static Author build (Long authorId, String name, String surname, Country country){
        Author a = new Author();
        a.id = authorId;
        a.name = name;
        a.surname = surname;
        a.country = country;
        return  a;
    }

}
