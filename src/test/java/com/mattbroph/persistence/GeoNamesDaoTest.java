package com.mattbroph.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mattbroph.jsonentity.Location;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the geonames API operations
 * @author mbrophy
 */
class GeoNamesDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Tests the API call and response to GeoNames to get the Location data
     * @throws JsonProcessingException if an error occurs while processing the JSON response
     */
    @Test
    void getLocationInformation() throws JsonProcessingException {

        // Use: String zipCode = "99999" to produce an error
        // Use: String zipCode = "53704" to produce successful test
        String zipCode = "53704";
        String countryCode = "US";
        GeoNamesDao geoNamesDao = new GeoNamesDao();

        // Log the zip and country code prior to calling method
        logger.info("Getting location information for " + zipCode + " " + countryCode);

        // Get the Location object back from the GeoNamesDao
        Location madisonLocation = geoNamesDao.getLocationInformation(zipCode, countryCode);

        if (madisonLocation != null && madisonLocation.getPostalCodes().size() > 0) {

            // Check that location is not null
            assertNotNull(madisonLocation);
            // Check that the zip code is correct
            assertEquals("53704", madisonLocation.getPostalCodes().get(0).getPostalCode());
            logger.info("The Location zip code is " + madisonLocation.getPostalCodes().get(0).getPostalCode());
            // Check that the placeName is correct
            assertEquals("Madison", madisonLocation.getPostalCodes().get(0).getPlaceName());
            logger.info("The Location place name is " + madisonLocation.getPostalCodes().get(0).getPlaceName());
            // Check that the adminName1 is correct
            assertEquals("Wisconsin", madisonLocation.getPostalCodes().get(0).getAdminName1());
            logger.info("The Location admin name 1 is " + madisonLocation.getPostalCodes().get(0).getAdminName1());

        } else {

            logger.error("Something went wrong. Either the zip code "
                    + zipCode + ", or the country code " + countryCode
                    + " was not found");
            // Force an error
            assertEquals(1, 2);

        }



    }
}