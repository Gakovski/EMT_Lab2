package com.emt.lab2.backend.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT s FROM Author s WHERE s.name = ?1")
    Optional<Author> findAuthorByName (String name);

}
