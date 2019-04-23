package com.apple.api.flagPicker.repository;

import com.apple.api.flagPicker.model.Continent;
import com.apple.api.flagPicker.model.Country;

import java.util.List;


/**
 * The repository interface that creates contract for necessary functions to be implemented.
 */
public interface ContinentsRepository {
    List<Continent> getAllContinents();
    Country findByCountryName(String countryName);
    void addContinent(Continent continent);
}
