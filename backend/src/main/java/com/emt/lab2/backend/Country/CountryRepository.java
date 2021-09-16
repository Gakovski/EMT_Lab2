package com.emt.lab2.backend.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query("SELECT s FROM Country s WHERE s.name = ?1")
    Optional<Country> findCountryByName (String name);

}
