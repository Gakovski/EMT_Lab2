package com.emt.lab2.backend.Author;

import com.emt.lab2.backend.Country.Country;
import com.emt.lab2.backend.Country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }


    public void addNewAuthor(AuthorDto authorDto) {
        Optional<Author> authorOptional = authorRepository.findAuthorByName(authorDto.getName());
        if (authorOptional.isPresent()){
            throw new IllegalStateException("Postoi");
        }
        Country country = countryRepository.findById(authorDto.getCountryid()).orElseThrow(
                () -> new RuntimeException("No such country found!")
        );
        Author author1 = new Author(authorDto.getName(), authorDto.getSurname(), country);
        authorRepository.save(author1);
    }

    public void deleteAuthor(Long id) {
        boolean exists = authorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Ne postoi avtorot so id " + id + " koj sakate da go izbrishete");
        }
        authorRepository.deleteById(id);
    }

    @Transactional
    public void updateAuthor(Long authorId, AuthorDto authorDto) {
        Author author = authorRepository.findById(authorId).orElseThrow(()
                -> new IllegalStateException(
                "Avtor with id " + authorId + " ne postoi!"
        ));
        if (authorDto.getName() != null && authorDto.getName().length()> 0
                && !Objects.equals(author.getName(), authorDto.getName())) {
            author.setName(authorDto.getName());
        }
        if (authorDto.getSurname() != null && authorDto.getSurname().length()> 0
                && !Objects.equals(author.getSurname(), authorDto.getSurname())) {
            author.setSurname(authorDto.getSurname());
        }
        Country country = countryRepository.findById(authorDto.getCountryid()).orElseThrow(()
                -> new IllegalStateException(
                "Drzhava with id " + authorDto.getCountryid() + " ne postoi!"
        ));
        country.setId(authorDto.getCountryid());
        author.setCountry(country);
    }
}
