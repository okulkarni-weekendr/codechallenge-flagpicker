package com.apple.api.flagPicker.controller;

import com.apple.api.flagPicker.constants.RestConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTraceEndpoint;
import org.springframework.web.bind.annotation.*;

import static com.apple.api.flagPicker.constants.RestConstants.URI.*;

/**
 * The logger controller that gives the counts of hits for each country
 * and continent.
 */
@RestController
public class AuditLoggingController {

    @Autowired
    private HttpTraceEndpoint httpTraceEndpoint;

    @RequestMapping(value = RestConstants.URI.AUDIT_ENDPOINT_COUNTRY, method = RequestMethod.GET)
    public @ResponseBody
    Long getCountryCount(@RequestParam(COUNTRY_REQUEUST_PARAM) String countryName) {
        countryName = countryName.replace(" ", "%20");
        String finalCountryName = new StringBuilder()
                .append(MAIN_URI)
                .append("?country=")
                .append(countryName).toString();

        return returnCount(finalCountryName);
    }

    @RequestMapping(value = RestConstants.URI.AUDIT_ENDPOINT_CONTINENT, method = RequestMethod.GET)
    public @ResponseBody
    Long getContinentCount(@RequestParam(CONTINENT_REQUEUST_PARAM) String continent) {
        continent = continent.replace(" ", "%20");

        String finalContinent = new StringBuilder()
                .append(MAIN_URI)
                .append("/continent/")
                .append(continent).toString();

        return returnCount(finalContinent);
    }

    private Long returnCount(String parameter) {
        return httpTraceEndpoint
                .traces()
                .getTraces()
                .stream()
                .filter(trace -> trace.getRequest().getUri().toString().contains(parameter)).count();
    }
}
