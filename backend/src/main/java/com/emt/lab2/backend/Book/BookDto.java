package com.emt.lab2.backend.Book;

import com.emt.lab2.backend.Categories.Categories;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Categories category;
    private Long authorid;
    private Integer availableCopies;

    public BookDto(){}

    public BookDto(String name, Categories category, Long authorid, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorid = authorid;
        this.availableCopies = availableCopies;
    }
}
