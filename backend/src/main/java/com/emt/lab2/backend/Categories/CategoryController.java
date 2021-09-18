package com.emt.lab2.backend.Categories;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @GetMapping
    public List<String> getCategories(){
        return Arrays.stream(Category.values()).map(category -> category.toString()).collect(Collectors.toList());
    }
}