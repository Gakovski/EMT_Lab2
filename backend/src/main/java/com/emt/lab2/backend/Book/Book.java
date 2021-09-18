package com.emt.lab2.backend.Book;

import com.emt.lab2.backend.Author.Author;
import com.emt.lab2.backend.Categories.Category;
import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity
public class Book {
    @Id
    @SequenceGenerator(
            name= "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "book_sequence"
    )
    private Long id;
    private String name;
    private Category category;
    @ManyToOne
    private Author author;
    private Integer availableCopies;

    public Book(){}
    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public void odzemiKniga()
    {
        if(availableCopies>0)
        {
            availableCopies--;
        }
    }

}
