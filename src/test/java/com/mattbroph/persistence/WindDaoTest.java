package com.mattbroph.persistence;

import com.mattbroph.entity.Wind;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the wind CRUD operations
 * @author mbrophy
 */
class WindDaoTest {

    GenericDao windDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Reloads a fresh database via a script before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        windDao = new GenericDao(Wind.class);
    }

    /**
     * Tests getting all of the wind items
     */
    @Test
    void getAll() {
        List<Wind> winds = (List<Wind>)windDao.getAll();
        assertEquals(5, winds.size());
    }

    /**
     * Tests getting a wind item by id
     */
    @Test
    void getById() {
        // Get ID 1
        Wind wind = (Wind)windDao.getById(1);
        // Check if wind is null
        assertNotNull(wind);
        // Check wind type
        assertEquals("0-5 mph", wind.getWindType());
    }

    /**
     * Tests updating a wind item by id
     */
    @Test
    void update() {
        // Get the first wind
        Wind wind = (Wind)windDao.getById(1);
        // Log the name of the wind
        logger.info("The wind type before updating: " + wind.getWindType());
        // Change the wind type
        wind.setWindType("WindBeenUpdated");
        // Update the wind type in the db
        windDao.update(wind);
        // Check the new wind type
        assertEquals("WindBeenUpdated", wind.getWindType());
        // Log the new wind type
        logger.info("The wind type after updating: " + wind.getWindType());
    }

    /**
     * Tests inserting a new wind item
     */
    @Test
    void insert() {
        int insertedWindId;

        // Create a new wind type
        Wind wind = new Wind("300 mph");
        // Do the insert and store the wind id
        insertedWindId = windDao.insert(wind);
        Wind windInserted = (Wind)windDao.getById(insertedWindId);
        assertNotNull(windInserted);
        assertEquals("300 mph", windInserted.getWindType());
    }

    /**
     * Tests deleting a wind item by id
     */
    @Test
    void delete() {
        Wind wind = (Wind)windDao.getById(5);
        windDao.delete(wind);
        assertNull(windDao.getById(5));
    }

    /**
     * Tests getting a list of wind items by property equals
     */
    @Test
    void getByPropertyEqual() {
        List<Wind> winds = (List<Wind>)windDao.getByPropertyEqual("windType", "5-10 mph");
        assertEquals(1, winds.size());
        assertEquals(2, winds.get(0).getId());
    }

    /**
     * Tests getting a list of wind items by property like
     */
    @Test
    void getByPropertyLike() {
        List<Wind> winds = (List<Wind>)windDao.getByPropertyLike("windType", "20+");
        assertEquals(1, winds.size());
    }
}