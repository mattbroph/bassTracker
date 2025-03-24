package com.mattbroph.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.mattbroph.jsonentity.Location;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import java.util.Properties;


public class GeoNamesDao implements PropertiesLoader {

    /**
     * Calls the geonames API to retrieve location information from a zip code.
     *
     * @param zipCode the zip code to send to geonames
     * @param countryCode the country the zip code resides in
     * @return the Location information that matches the zip code
     *
     * @throws JsonProcessingException if an error occurs while processing the json
     */
     public Location getLocationInformation(String zipCode, String countryCode)
            throws JsonProcessingException {

         // Get the base URL from the properties file
         Properties geoNamesProperties = loadProperties("/geoNames.properties");
         String baseLocationUrl = geoNamesProperties.getProperty("baseURL");
         String completeUrl = baseLocationUrl + "&postalcode=" + zipCode + "&country=" + countryCode;

         System.out.println(completeUrl);

         Client client = ClientBuilder.newClient();
         WebTarget target =
                 client.target(completeUrl);
         String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

         // Create a location object using ObjectMapper
         ObjectMapper mapper = new ObjectMapper();
         Location location = mapper.readValue(response, Location.class);

         return location;

        }


     }
