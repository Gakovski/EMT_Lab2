package com.emt.lab2.backend.Book;

import com.emt.lab2.backend.Categories.Category;
import lombok.Data;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long authorid;
    private Integer availableCopies;

    public BookDto(){}

    public BookDto(String name, Category category, Long authorid, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorid = authorid;
        this.availableCopies = availableCopies;
    }
}
