package com.mattbroph.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mattbroph.jsonentity.Location;
import com.mattbroph.jsonentity.MeteoStat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the meteostat API operations
 * @author mbrophy
 */
class MeteoStatWeatherDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Tests the API call and response to MeteoStat to get the Weather data
     * @throws JsonProcessingException if an error occurs while processing the JSON response
     */
    @Test
    void getMeteoStatWeather() throws JsonProcessingException {

        // Get the Location object to access it's lat & lng
        GeoNamesDao geoNamesDao = new GeoNamesDao();
        String zipCode = "53704";
        String countryCode = "US";
        Location location = geoNamesDao.getLocationInformation(zipCode, countryCode);

        // Uncomment below to force an error by setting the lat and lng to incorrect values
        // location.getPostalCodes().get(0).setLat(999);
        // location.getPostalCodes().get(0).setLng(999);

        // Get the weather from the MeteoStat object
        MeteoStatWeatherDao meteostatDao = new MeteoStatWeatherDao();
        LocalDate startDate = LocalDate.parse("2025-03-25");
        LocalDate endDate = LocalDate.parse("2025-03-26");

        MeteoStat meteoStat = meteostatDao.getMeteoStatWeather(location, startDate, endDate);


        if (meteoStat != null && meteoStat.getData().size() > 0 ) {

            // Check meteoStat is not null
            assertNotNull(meteoStat);
            // Check the sun value is correct
            assertEquals(33.4, meteoStat.getData().get(2).getTemp());
            logger.info("The temp at 2:00am is: " + meteoStat.getData().get(2).getTemp());
            // Check the weather condition at 2pm
            assertEquals("Clear", meteoStat.getData().get(14).getCocoDescription());
            logger.info("The weather condition at 2:00pm is: " + meteoStat.getData().get(14).getCocoDescription());

        } else {

            logger.error("Something went wrong in the meteostat api call - received null"
                    + " or empty MeteoStat object.");
            // Force an error
            fail("Something went wrong in the meteostat api call - received null"
                    + " or empty MeteoStat object.");
        }



    }
}