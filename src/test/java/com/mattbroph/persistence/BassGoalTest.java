package com.mattbroph.persistence;

import com.mattbroph.entity.BassGoal;
import com.mattbroph.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the bass goal CRUD operations
 * @author mbrophy
 */
class BassGoalTest {

    GenericDao bassGoalDao;
    GenericDao userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Reloads a fresh database via a script before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        bassGoalDao = new GenericDao(BassGoal.class);
        userDao = new GenericDao(User.class);
    }

    /**
     * Tests getting a bass goal by id
     */
    @Test
    void getById() {
        // Get ID 1
        BassGoal bassGoal = (BassGoal)bassGoalDao.getById(1);
        // Check if bassGoal is null
        assertNotNull(bassGoal);
        // Check bassGoal name
        assertEquals(2025, bassGoal.getGoalYear());
        assertEquals(150, bassGoal.getGoalCount());
    }

    /**
     * Tests updating a bass goal by id
     */
    @Test
    void update() {
        // Get the first bassGoal
        BassGoal bassGoal = (BassGoal)bassGoalDao.getById(1);
        // Log the count of the bassGoal
        logger.info("The bassGoalCount before updating: " + bassGoal.getGoalCount());
        // Change the bassGoal count
        bassGoal.setGoalCount(100);
        // Update the bassGoal count in the db
        bassGoalDao.update(bassGoal);
        // Check the new bassGoal count
        assertEquals(100, bassGoal.getGoalCount());
        // Log the new bassGoal count
        logger.info("The bassGoalCount after updating: " + bassGoal.getGoalCount());
    }


    /**
     * Tests inserting a new bass goal
     */
    @Test
    void insert() {
        int insertedBassGoalId;

        // Get a user
        User user = (User)userDao.getById(3);

        // Create a new bassGoal
        BassGoal bassGoal = new BassGoal(user, 2024, 72);

        // Do the insert and store the bassGoal id
        insertedBassGoalId = bassGoalDao.insert(bassGoal);
        BassGoal bassGoalInserted = (BassGoal)bassGoalDao.getById(insertedBassGoalId);
        assertNotNull(bassGoalInserted);
        assertEquals(72, bassGoalInserted.getGoalCount());
    }

    /**
     * Tests deleting a bass goal by id
     */
    @Test
    void delete() {
        BassGoal bassGoal = (BassGoal)bassGoalDao.getById(2);
        bassGoalDao.delete(bassGoal);
        assertNull(bassGoalDao.getById(2));
    }

    /**
     * Tests getting a list of bass goals by property equals
     */
    @Test
    void getByPropertyEqual() {
        List<BassGoal> bassGoals = (List<BassGoal>)bassGoalDao.getByPropertyEqual("goalYear", "2025");
        assertEquals(3, bassGoals.size());
    }

    /* Hibernate requires a String for this value, but all the fields in the BassGoal
    * table are ints. This method cannot be tested for this class for that reason.
    * This class does not need this method for processing.
    */
    @Test
    void getByPropertyLike() {

    }

    /**
     * Tests getting all of the bass goals
     */
    @Test
    void getAll() {
        List<BassGoal> bassGoals = (List<BassGoal>)bassGoalDao.getAll();
        assertEquals(4, bassGoals.size());
    }

    /**
     * Tests getting a list of bass goal using a map with multiple property equals
     */
    @Test
    void findByPropertyEqual() {

        User user = (User)userDao.getById(1);

        Map<String, Object> propertyMap = new HashMap<String, Object>();
        propertyMap.put("user", user);
        propertyMap.put("goalYear", 2025);

        List<BassGoal> bassGoal
                = (List<BassGoal>)bassGoalDao.findByPropertyEqual(propertyMap);

        assertEquals(1, bassGoal.size());
        assertEquals(2025, bassGoal.get(0).getGoalYear());
        assertEquals(150, bassGoal.get(0).getGoalCount());
        assertEquals(1, bassGoal.get(0).getUser().getId());
    }
}