package com.emt.lab2.backend.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT s FROM Book s WHERE s.name = ?1")
    Optional<Book> findBookByName (String name);

}
