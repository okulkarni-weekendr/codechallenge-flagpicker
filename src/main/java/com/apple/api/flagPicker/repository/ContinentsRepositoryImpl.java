package com.apple.api.flagPicker.repository;

import com.apple.api.flagPicker.model.Continent;
import com.apple.api.flagPicker.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContinentsRepositoryImpl implements ContinentsRepository{

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ContinentsRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Continent> getAllContinents() {
        return mongoTemplate.findAll(Continent.class);
    }

    @Override
    public void addContinent(Continent continent) {
        mongoTemplate.save(continent, "continents");
    }

    @Override
    public Continent findByContinentName(String continentName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(continentName));
        return mongoTemplate.find(query, Continent.class).get(0);
    }

    @Override
    public Country findByCountryName(String countryName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("countries.name").is(countryName));
        query.fields().include("countries.$");
        return mongoTemplate.find(query, Continent.class).get(0).getCountries().get(0);
    }
}
