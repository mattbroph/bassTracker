package com.mattbroph.persistence;

import com.mattbroph.entity.Weather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Tests the weather CRUD operations
 * @author mbrophy
 */
class WeatherDaoTest {

    GenericDao weatherDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Reloads a fresh database via a script before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        weatherDao = new GenericDao(Weather.class);
    }

    /**
     * Tests getting all of the weather items
     */
    @Test
    void getAll() {
        List<Weather> weathers = (List<Weather>)weatherDao.getAll();
        assertEquals(5, weathers.size());
    }

    /**
     * Tests getting a weather item by id
     */
    @Test
    void getById() {
        // Get ID 1
        Weather weather = (Weather)weatherDao.getById(1);
        // Check if weather is null
        assertNotNull(weather);
        // Check weather type
        assertEquals("Sunny", weather.getWeatherType());
    }

    /**
     * Tests updating a weather item by id
     */
    @Test
    void update() {
        // Get the first weather
        Weather weather = (Weather)weatherDao.getById(1);
        // Log the name of the weather
        logger.info("The weather type before updating: " + weather.getWeatherType());
        // Change the weather type
        weather.setWeatherType("WeatherBeenUpdated");
        // Update the weather type in the db
        weatherDao.update(weather);
        // Check the new weather type
        assertEquals("WeatherBeenUpdated", weather.getWeatherType());
        // Log the new weather type
        logger.info("The weather type after updating: " + weather.getWeatherType());
    }

    /**
     * Tests inserting a new weather item
     */
    @Test
    void insert() {
        int insertedWeatherId;

        // Create a new weather type
        Weather weather = new Weather("Super Rainy");
        // Do the insert and store the weather id
        insertedWeatherId = weatherDao.insert(weather);
        Weather weatherInserted = (Weather)weatherDao.getById(insertedWeatherId);
        assertNotNull(weatherInserted);
        assertEquals("Super Rainy", weatherInserted.getWeatherType());
    }

    /**
     * Tests deleting a weather item by id
     */
    @Test
    void delete() {
        Weather weather = (Weather)weatherDao.getById(5);
        weatherDao.delete(weather);
        assertNull(weatherDao.getById(5));
    }

    /**
     * Tests getting a list of weather items by property equals
     */
    @Test
    void getByPropertyEqual() {
        List<Weather> weathers = (List<Weather>)weatherDao.getByPropertyEqual("weatherType", "Sunny");
        assertEquals(1, weathers.size());
        assertEquals(1, weathers.get(0).getId());
    }

    /**
     * Tests getting a list of weather items by property like
     */
    @Test
    void getByPropertyLike() {
        List<Weather> weathers = (List<Weather>)weatherDao.getByPropertyLike("weatherType", "Cloudy");
        assertEquals(2, weathers.size());
    }
}