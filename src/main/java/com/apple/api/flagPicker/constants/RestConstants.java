package com.apple.api.flagPicker.constants;

/**
 * High level rest constants
 */
public class RestConstants {
    public static class URI {
        public static final String MAIN_URI = "/api/flagPicker";
        public static final String LIST_ALL_URI = MAIN_URI + "/continents";
        public static final String COUNTRY_REQUEUST_PARAM = "country";
        public static final String AUDIT_ENDPOINT_COUNTRY = "/audit/countryRequests";
        public static final String AUDIT_ENDPOINT_CONTINENT = "/audit/continentRequest";

    }
}
