package com.emt.lab2.backend.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @PostMapping
    public void addNewAuthor (@RequestBody AuthorDto authorDto){
       authorService.addNewAuthor(authorDto);
    }

    @DeleteMapping(path = "{authorId}")
    public void deleteAuthor (@PathVariable("authorId") Long id){
        authorService.deleteAuthor(id);
    }

    @PutMapping(path = "{authorId}")
    public void updateAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestBody(required = false) AuthorDto authorDto){
        authorService.updateAuthor(authorId,authorDto);
    }

}
