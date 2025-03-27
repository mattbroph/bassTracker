package com.mattbroph.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


public class MeteoStatWeatherDao implements PropertiesLoader {

    // Logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Calls the meteostat api to retrieve weather information
     *
     * @param lat the latitude of the geonames location
     * @param lng the longitude of the geonames location
     * @param date the date of the weather being requested
     * @return the MeteoStatWeather information based on lat, lng & date
     *
     * @throws JsonProcessingException if an error occurs while processing the json
     */
     public MeteoStat getMeteoStatWeather(Object lat, Object lng, LocalDate date)
            throws JsonProcessingException {

         // Build the base URL from the properties file values
         Properties meteostatProperties = loadProperties("/weatherApi.properties");
         String baseUrl = meteostatProperties.getProperty("meteostat.baseURL");

         String completeUrl = baseUrl + "?lat=" + lat + "&lon=" + lng + "&start=" + date + "&end=" + date;
         // https://meteostat.p.rapidapi.com/point/daily?lat=52.5244&lon=13.4105&start=2020-01-01&end=2020-01-01

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
