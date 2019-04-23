# Code Challenge - Flag Picker

This repo contains code for the challenge. The specifics of this code is, it uses an embedded mongoDB server to run queries on the data.

### Country and Continent Endpoints

Each endpoint manipulates or displays information related to the User whose
Token is provided with the request:

* Get all continents and its information : `GET /api/flagPicker/continents`
* Get information/flag of a country : `GET /api/flagPicker?country={countryName}`

### Audit Endpoints

Audit Endpoints give you a total count of endpoints/requests hit by the users

* Get total Count of countries hits : `GET /audit/countryRequests?country={countryName}`
* Get total count of continent hits : `GET /audit/continentRequest?continent={continentName}`
