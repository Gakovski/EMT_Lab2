package com.emt.lab2.backend.Author;

import com.emt.lab2.backend.Country.Country;
import com.emt.lab2.backend.Country.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @PostConstruct
    public void initData(){
        Country c1 = Country.build("Makedonija","Evropa");
        if(countryRepository.findAll().isEmpty()){
            countryRepository.save(c1);
        }
        Author a1 = Author.build(
                1L,
                "Igor",
                "Dzambazov",
                c1
        );

        if(authorRepository.findAll().isEmpty()){
            authorRepository.save(a1);
        }
    }
}
