package com.emt.lab2.backend.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService)
    {
        this.countryService = countryService;
    }


    @GetMapping
    public List<Country> getCountries(){
        return countryService.getCountries();
    }

    @PostMapping
    public void addNewCountry (@RequestBody Country country){
        countryService.addNewCountry(country);
    }

    @DeleteMapping(path = "{countryId}")
    public void deleteCountry (@PathVariable("countryId") Long id){
        countryService.deleteCountry(id);
    }

    @PutMapping(path = "{countryId}")
    public void updateCountry(
            @PathVariable("countryId") Long countryId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String continent){
        countryService.updateCountry(countryId, name, continent);
    }

}
