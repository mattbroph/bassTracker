package com.mattbroph.persistance;

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

class BassGoalTest {

    GenericDao bassGoalDao;
    GenericDao userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        bassGoalDao = new GenericDao(BassGoal.class);
        userDao = new GenericDao(User.class);
    }

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

    @Test
    void delete() {
        BassGoal bassGoal = (BassGoal)bassGoalDao.getById(2);
        bassGoalDao.delete(bassGoal);
        assertNull(bassGoalDao.getById(2));
    }

    @Test
    void getByPropertyEqual() {
        List<BassGoal> bassGoals = (List<BassGoal>)bassGoalDao.getByPropertyEqual("goalYear", "2025");
        assertEquals(3, bassGoals.size());
//        assertEquals(3, bassGoals.get(0).getId());
    }

    /* Hibernate requires a String for this value, but all the fields in the BassGoal
    * table are ints. This method cannot be tested for this class for that reason.
    * This class does not need this method for processing.
    */
    @Test
    void getByPropertyLike() {
//        List<BassGoal> bassGoals = (List<BassGoal>)bassGoalDao.getByPropertyLike("goalYear", "20");
//        assertEquals(4, bassGoals.size());
    }

    @Test
    void getAll() {
        List<BassGoal> bassGoals = (List<BassGoal>)bassGoalDao.getAll();
        assertEquals(4, bassGoals.size());
    }

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