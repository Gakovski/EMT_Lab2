package com.emt.lab2.backend.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks (){
       return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return bookService.findById(id).map(b -> ResponseEntity.ok().body(b)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping(path = "/add")
    public void addNewBook(@RequestBody BookDto bookDto){
        bookService.addNewBook(bookDto);
    }

    @DeleteMapping(path = "/delete/{bookId}")
    public void deleteBook(@PathVariable ("bookId") Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "/edit/{bookId}")
    public void updateBook(@PathVariable ("bookId") Long id,
                           @RequestBody(required = false) BookDto bookDto)
    {
        bookService.updateBook(id, bookDto);
    }

    @DeleteMapping("/rent/{id}")
    public void rentBook(@PathVariable ("id") Long id) {
    bookService.rentBook(id);
    }

}
