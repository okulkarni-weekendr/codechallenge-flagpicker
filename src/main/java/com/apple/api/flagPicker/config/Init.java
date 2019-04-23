package com.apple.api.flagPicker.config;

import com.apple.api.flagPicker.model.Continent;
import com.apple.api.flagPicker.model.Country;
import com.apple.api.flagPicker.repository.ContinentsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Init {

    @Autowired
    private ContinentsRepository continentsRepository;

    public void loadDataOnStartup() throws IOException, ParseException {
        JSONParser parser = new JSONParser();

        InputStream inputStream = Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream("continents.txt");

        JSONArray jsonArray = (JSONArray) parser
                .parse(new BufferedReader(
                        new InputStreamReader(Objects.requireNonNull(inputStream)))
                );

        for (Object object: jsonArray) {
            JSONObject obj = (JSONObject) object;
            List<Country> countries = new ArrayList<>();

            JSONArray countriesList = ((JSONArray) obj.get("countries"));

            for (Object countryObject: countriesList) {
                JSONObject countryObj = (JSONObject)countryObject;
                Country country = new Country(countryObj.get("name").toString(), countryObj.get("flag").toString());
                countries.add(country);
            }

            Continent continent = new Continent(new ObjectId(), (String)obj.get("continent"), countries);
            continentsRepository.addContinent(continent);
        }
    }
}
