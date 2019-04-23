package com.apple.api.flagPicker.service;

import com.apple.api.flagPicker.model.Continent;
import com.apple.api.flagPicker.model.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ApiService {
    public List<Continent> getContinents() throws JsonProcessingException;
    public Continent getContinentByName(String continentName) throws JsonProcessingException;
    public Country getCountryAndFlag(String countryName) throws JsonProcessingException;
}
