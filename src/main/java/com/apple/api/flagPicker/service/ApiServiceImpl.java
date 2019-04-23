package com.apple.api.flagPicker.service;

import com.apple.api.flagPicker.model.Continent;
import com.apple.api.flagPicker.model.Country;
import com.apple.api.flagPicker.repository.ContinentsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ContinentsRepository continentsRepository;

    @Override
    public List<Continent> getContinents() throws JsonProcessingException {
         return continentsRepository.getAllContinents();
    }

    @Override
    public Continent getContinentByName(String continentName) throws JsonProcessingException {
        return continentsRepository.findByContinentName(continentName);
    }

    @Override
    public Country getCountryAndFlag(String countryName) throws JsonProcessingException {
        return continentsRepository.findByCountryName(countryName);
    }
}
