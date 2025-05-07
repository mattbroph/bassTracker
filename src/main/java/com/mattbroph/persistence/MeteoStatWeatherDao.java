package com.mattbroph.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mattbroph.jsonentity.Location;
import com.mattbroph.jsonentity.MeteoStat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.time.LocalDate;
import java.util.Properties;

/**
 * Retrieves the weather information from Metostat API based on user input
 * @author mbrophy
 */
public class MeteoStatWeatherDao implements PropertiesLoader {

    // Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Calls the meteostat api to retrieve weather information
     *
     * @param location the geonames Location object containing lat and lng data
     * @param startDate the start date of the weather being requested
     * @param endDate the end date of the weatehr being requested
     * @return the MeteoStatWeather information based on lat, lng & dates
     *
     * @throws JsonProcessingException if an error occurs while processing the json
     */
     public MeteoStat getMeteoStatWeather(Location location, LocalDate startDate, LocalDate endDate)
            throws JsonProcessingException {

         // Get the latitude and longitude values
         Object lat = location.getPostalCodes().get(0).getLat();
         Object lng = location.getPostalCodes().get(0).getLng();

         // Build the base URL from the properties file values
         Properties meteostatProperties = loadProperties("/weatherApi.properties");
         String baseUrl = meteostatProperties.getProperty("meteostat.baseURL");

         String completeUrl = baseUrl + "?lat=" + lat + "&lon=" + lng + "&start=" + startDate + "&end=" + endDate + "&units=imperial";
         // https://meteostat.p.rapidapi.com/point/daily?lat=-89.352295&lon=43.120526&start=2020-01-01&end=2020-01-01&units=imperial

         logger.info("The test meteostat url is: " + completeUrl);

         // Store the header values
         MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
         headers.add(meteostatProperties.getProperty("meteostat.header.apiHost"), meteostatProperties.getProperty("meteostat.header.apiHostValue"));
         headers.add(meteostatProperties.getProperty("meteostat.auth.apiKey"), meteostatProperties.getProperty("meteostat.auth.apiKeyValue"));

         Client client = ClientBuilder.newClient();
         WebTarget target =
                 client.target(completeUrl);
         String response = target.request(MediaType.APPLICATION_JSON)
                 .headers(headers)
                 .get(String.class);

         // Create a MeteoStat object using ObjectMapper
         ObjectMapper mapper = new ObjectMapper();
         MeteoStat meteoStat = mapper.readValue(response, MeteoStat.class);

         return meteoStat;

        }


     }
