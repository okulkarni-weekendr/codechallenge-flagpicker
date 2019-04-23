package com.apple.api.flagPicker.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "continents")
public class Continent {

    @Id
    private ObjectId _id;
    private String name;
    private List<Country> countries;

    public Continent(ObjectId _id, String name, List<Country> countries) {
        this._id = _id;
        this.name = name;
        this.countries = countries;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "Continent{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", countries=" + countries +
                '}';
    }
}
