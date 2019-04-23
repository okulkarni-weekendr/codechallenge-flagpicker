package com.apple.api.flagPicker.controller;

import com.apple.api.flagPicker.model.Continent;
import com.apple.api.flagPicker.model.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.apple.api.flagPicker.constants.RestConstants.URI;
import com.apple.api.flagPicker.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.apple.api.flagPicker.constants.RestConstants.URI.COUNTRY_REQUEUST_PARAM;

/**
 * Main controller class for countries and continents
 */
@RestController
public class ApiController {

    @Autowired
    private ApiService apiService;

    @RequestMapping(value = URI.LIST_ALL_URI, method = RequestMethod.GET)
    public List<Continent> getAllContinents() throws JsonProcessingException {
        return apiService.getContinents();
    }

    @RequestMapping(value = URI.MAIN_URI, method = RequestMethod.GET)
    public @ResponseBody
    Country getCountryAndFlag(@RequestParam(COUNTRY_REQUEUST_PARAM) String countryName) throws JsonProcessingException {
        return apiService.getCountryAndFlag(countryName);
    }
}
