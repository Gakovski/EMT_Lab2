package com.emt.lab2.backend.Country;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Country {
    @Id
    @SequenceGenerator(
            name= "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "country_sequence"
    )
    private Long id;
    private String name;
    private String continent;

    public Country(){}

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
