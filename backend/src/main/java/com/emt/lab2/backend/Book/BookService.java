package com.emt.lab2.backend.Book;

import com.emt.lab2.backend.Author.Author;
import com.emt.lab2.backend.Author.AuthorRepository;
import com.emt.lab2.backend.Country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository,
                       CountryRepository countryRepository)
    {
        this.bookRepository=bookRepository;
        this.authorRepository=authorRepository;
        this.countryRepository=countryRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(BookDto bookDto) {
        Optional<Book> bookOptional = bookRepository.findBookByName(bookDto.getName());
        if (bookOptional.isPresent()){
            throw new IllegalStateException("Postoi");
        }

        Author author = authorRepository.findById(bookDto.getAuthorid()).orElseThrow(
                () -> new RuntimeException("No such author found")
        );
        Book book = new Book(bookDto.getName(), bookDto.getCategory(),
                author, bookDto.getAvailableCopies());
        bookRepository.save(book);

    }

    public void deleteBook(Long id) {
        boolean exists = bookRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Ne postoi knigata so id " + id);
        }
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Ne postoi ovaa kniga, kako kje ja update alo!"));
        if (bookDto.getName() != null && bookDto.getName().length()> 0
                && !Objects.equals(book.getName(), bookDto.getName())) {
            book.setName(bookDto.getName());
        }
        if (bookDto.getCategory() != null &&
                !Objects.equals(book.getCategory(), bookDto.getCategory())) {
            book.setCategory(bookDto.getCategory());
        }
        Author author = authorRepository.findById(bookDto.getAuthorid()).orElseThrow(() ->
                new IllegalStateException("Ne postoi ovoj avtor so id "+ bookDto.getAuthorid()));
        book.setAuthor(author);
        if(bookDto.getAvailableCopies() != null && bookDto.getAvailableCopies()>0)
        {
            book.setAvailableCopies(bookDto.getAvailableCopies());
        }

    }

    public void rentBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty())
        {
            throw new IllegalStateException("Knigata so id "+ id + ", ne e pronajdena.");
        }
        else
        {
            Book book = bookOptional.get();
            book.odzemiKniga();
            bookRepository.save(book);
        }
    }


    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
