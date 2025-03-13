package com.mattbroph.persistence;

import com.fasterxml.jackson.databind.*;
//import com.swapi.Planet;


import com.mattbroph.jsonentity.Location;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    // IN YOUR PROJECT
    // You will have a dao that has this code in it
    // You would have the URI loaded into a properties file
    // Have a unit test to have a particular class
    @Test
    public void testswapiJSON() throws Exception {

        String baseLocationUrl = "http://api.geonames.org/postalCodeSearchJSON?username=mattbroph&postalcode=";
        String zipCodeParam = "53597";
        String countryCodeParam = "&country=US";
        String locationUrl = baseLocationUrl + zipCodeParam + countryCodeParam;

        System.out.println(locationUrl);

        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target(locationUrl);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        // Create a location object using ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        Location location = mapper.readValue(response, Location.class);


        // Test that the object was created properly
        assertEquals("53597", location.getPostalCodes().get(0).getPostalCode());





    }
}