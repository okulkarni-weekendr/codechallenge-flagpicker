# Code Challenge - Flag Picker

This repo contains code for the challenge. The specifics of this code is, it uses an embedded mongoDB server to run queries on the data.

### Country and Continent Endpoints

* Get all continents and its information : `GET /api/flagPicker/continents`
* Get information/flag of a country : `GET /api/flagPicker?country={countryName}`
* Get list of all countries for a continent : `GET /api/flagPicker/continent/{continent}`

### Audit Endpoints

Audit Endpoints give you a total count of endpoints/requests hit by the users

* Get total Count of countries hits : `GET /audit/countryRequests?country={countryName}`
* Get total count of continent hits : `GET /audit/continentRequest?continent={continentName}`

### Running the spring boot app

All you need to do is package it and run with `mvn package && java -jar target/codechallenge-0.0.1-SNAPSHOT.jar`

* Spring boot server runs on `8080`
* MongoDB server runs on `8900`

### MongoDB Schema for the data

##### Model One-to-Many Relationships with Embedded Documents
* Our app needs to frequently query the countries data with name, which would lead to multiple queries to resolve the references.
* A more optimal schema would be to embed the countries data entities in the continent data/document, as in the following document:
```
{
  name: "Asia",
  countries: [
    {
      name: "India",
      flag: "abc"
    },
    ..
  ]
 }
 ```
