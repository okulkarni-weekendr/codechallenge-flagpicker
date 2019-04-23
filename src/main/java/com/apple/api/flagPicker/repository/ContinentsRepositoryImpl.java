package com.apple.api.flagPicker.repository;

import com.apple.api.flagPicker.model.Continent;
import com.apple.api.flagPicker.model.Country;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
    public Country findByCountryName(String countryName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("countries.name").is(countryName));
        query.fields().include("countries.$");
        return mongoTemplate.find(query, Continent.class).get(0).getCountries().get(0);
    }
}
