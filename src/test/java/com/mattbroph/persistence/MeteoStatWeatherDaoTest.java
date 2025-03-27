package com.mattbroph.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mattbroph.jsonentity.MeteoStat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MeteoStatWeatherDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    void getMeteoStatWeather() throws JsonProcessingException {




        MeteoStatWeatherDao meteostatDao = new MeteoStatWeatherDao();
        Object lat = 52.5244;
        Object lng = 13.4105;
        LocalDate date = LocalDate.parse("2020-01-01");

        MeteoStat meteoStat = meteostatDao.getMeteoStatWeather(lat, lng, date);

        // Check meteoStat is not null
        assertNotNull(meteoStat);
        // Check the sun value is correct
        assertEquals(102, meteoStat.getData().get(0).getTsun());
        logger.info("The tsun value is: " + meteoStat.getData().get(0).getTsun());




    }
}