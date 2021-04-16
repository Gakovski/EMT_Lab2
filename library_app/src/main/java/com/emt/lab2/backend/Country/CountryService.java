package com.emt.lab2.backend.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService (CountryRepository countryRepository)
    {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public void addNewCountry(Country country) {
        Optional<Country> countryOptional = countryRepository.findCountryByName(country.getName());
        if (countryOptional.isPresent()){
            throw new IllegalStateException("Postoi");
        }
        countryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        boolean exists = countryRepository.existsById(id);
        if (!exists)
        {
            throw new IllegalStateException("Country with id " + id + " does not exists");
        }
        countryRepository.deleteById(id);
    }

    @Transactional
    public void updateCountry(Long countryId, String name, String continent) {
        Country country = countryRepository.findById(countryId).orElseThrow(()
                -> new IllegalStateException(
                        "Country with id " + countryId + " does not exist"
                ));
        if (name != null && name.length()>0 && !Objects.equals(country.getName(),name)){
            country.setName(name);
        }
        if (continent != null && continent.length()>0 &&
                !Objects.equals(country.getContinent(),continent)){
            country.setContinent(continent);
        }
    }
}
