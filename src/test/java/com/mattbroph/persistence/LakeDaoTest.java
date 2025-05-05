package com.mattbroph.persistence;

import com.mattbroph.entity.Lake;
import com.mattbroph.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the lake CRUD operations
 * @author mbrophy
 */
class LakeDaoTest {

    GenericDao lakeDao;
    GenericDao userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Reloads a fresh database via a script before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        lakeDao = new GenericDao(Lake.class);
        userDao = new GenericDao(User.class);
    }

    /**
     * Tests getting all of the lakes
     */
    @Test
    void getAll() {
        List<Lake> lakes = (List<Lake>)lakeDao.getAll();
        assertEquals(7, lakes.size());
    }

    /**
     * Tests getting a lake by id
     */
    @Test
    void getById() {
        // Get ID 1
        Lake lake = (Lake)lakeDao.getById(1);
        // Check if lake is null
        assertNotNull(lake);
        // Check lake name
        assertEquals("Lake Kegonsa", lake.getLakeName());
    }

    /**
     * Tests updating a lake by id
     */
    @Test
    void update() {
        // Get the first lake
        Lake lake = (Lake)lakeDao.getById(1);
        // Log the name of the lake
        logger.info("The lake name before updating: " + lake.getLakeName());
        // Change the lake name
        lake.setLakeName("Lake BeenUpdated");
        // Update the lake name in the db
        lakeDao.update(lake);
        // Check the new lake name
        assertEquals("Lake BeenUpdated", lake.getLakeName());
        // Log the new lake name
        logger.info("The lake name after updating: " + lake.getLakeName());
    }

    /**
     * Tests inserting a new lake
     */
    @Test
    void insert() {
        int insertedLakeId;

        // Get a user
        User user = (User)userDao.getById(3);

        // Create a new lake
        Lake lake = new Lake("Lake Waubesa", user, true);
        // Do the insert and store the lake id
        insertedLakeId = lakeDao.insert(lake);
        Lake lakeInserted = (Lake)lakeDao.getById(insertedLakeId);
        assertNotNull(lakeInserted);
        assertEquals("Lake Waubesa", lakeInserted.getLakeName());
    }

    /**
     * Tests deleting a lake by id
     */
    @Test
    void delete() {
        Lake lake = (Lake)lakeDao.getById(5);
        lakeDao.delete(lake);
        assertNull(lakeDao.getById(5));
    }

    /**
     * Tests getting a list of lakes by property equals
     */
    @Test
    void getByPropertyEqual() {
        List<Lake> userLakes = (List<Lake>)lakeDao.getByPropertyEqual("lakeName", "Lake Mendota");
        assertEquals(1, userLakes.size());
        assertEquals(2, userLakes.get(0).getId());
    }

    /**
     * Tests getting a list of lakes by property like
     */
    @Test
    void getByPropertyLike() {
        List<Lake> userLakes = (List<Lake>)lakeDao.getByPropertyLike("lakeName", "Lake M");
        assertEquals(3, userLakes.size());
    }

    /**
     * This class tests the Lake object validator annotations. This will be used
     * for form validation.
     */
    @Test
    void checkInvalidLakeValidation() {

        // Create a validator factory and validator
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        // Get a user
        User user = (User)userDao.getById(3);

        // Create an invalid lake
        Lake invalidLake = new Lake("", user, true);

        // Check for any violations
        Set<ConstraintViolation<Lake>> violations = validator.validate(invalidLake);

        if (violations.isEmpty()) {
            logger.info("Lake is valid");
        } else {
            logger.error("Lake is not valid");
            for (ConstraintViolation<Lake> violation : violations) {
                logger.info(violation.getMessage());
            }
        }
        /* There are two violations
        * 1. Lake size is not bewtween 1-50
        * 2. Lake name is empty
        */
        assertEquals(2, violations.size());

    }
}