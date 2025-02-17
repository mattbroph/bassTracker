package com.mattbroph.persistance;

import com.mattbroph.entity.Lake;
import com.mattbroph.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LakeDaoTest {

    GenericDao lakeDao;
    GenericDao userDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        lakeDao = new GenericDao(Lake.class);
        userDao = new GenericDao(User.class);
    }

    @Test
    void getById() {
        // Get ID 1
        Lake lake = (Lake)lakeDao.getById(1);
        // Check if lake is null
        assertNotNull(lake);
        // Check lake name
        assertEquals("Lake Kegonsa", lake.getLakeName());
    }

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

    @Test
    void delete() {
        Lake lake = (Lake)lakeDao.getById(5);
        lakeDao.delete(lake);
        assertNull(lakeDao.getById(5));
    }

    @Test
    void getByPropertyEqual() {
        List<Lake> userLakes = (List<Lake>)lakeDao.getByPropertyEqual("lakeName", "Lake Mendota");
        assertEquals(1, userLakes.size());
        assertEquals(2, userLakes.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<Lake> userLakes = (List<Lake>)lakeDao.getByPropertyLike("lakeName", "Lake M");
        assertEquals(3, userLakes.size());
    }
}