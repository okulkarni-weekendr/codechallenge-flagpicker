# Code Challenge - Flag Picker

This repo contains code for the challenge. The specifics of this code is, it uses an embedded mongoDB server to run queries on the data.

### Country and Continent Endpoints

* Get all continents and its information : `GET /api/flagPicker/continents`
* Get information/flag of a country : `GET /api/flagPicker?country={countryName}`

### Audit Endpoints

Audit Endpoints give you a total count of endpoints/requests hit by the users

* Get total Count of countries hits : `GET /audit/countryRequests?country={countryName}`
* Get total count of continent hits : `GET /audit/continentRequest?continent={continentName}`

### Running the spring boot app

All you need to do is package it and run with `mvn package && java -jar target/codechallenge-0.0.1-SNAPSHOT.jar`
