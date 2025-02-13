package com.mattbroph.persistance;

import com.mattbroph.entity.Journal;
import com.mattbroph.entity.Lake;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mysql.cj.conf.PropertyKey.logger;
import static org.junit.jupiter.api.Assertions.*;

class LakeDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
    }

    @Test
    void getById() {
        LakeDao lakeDao = new LakeDao();
        // Get ID 1
        Lake lake = lakeDao.getById(1);
        // Check if lake is null
        assertNotNull(lake);
        // Check lake name
        assertEquals("Lake Kegonsa", lake.getLakeName());
    }

    @Test
    void update() {
        // Get the first lake
        LakeDao lakeDao = new LakeDao();
        Lake lake = lakeDao.getById(1);
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
        LakeDao lakeDao = new LakeDao();
        // Create a new lake
        Lake lake = new Lake("Lake Waubesa", 2);
        // Do the insert and store the lake id
        insertedLakeId = lakeDao.insert(lake);
        Lake lakeInserted = lakeDao.getById(insertedLakeId);
        assertNotNull(lakeInserted);
        assertEquals("Lake Waubesa", lakeInserted.getLakeName());
    }

    @Test
    void delete() {
        LakeDao lakeDao = new LakeDao();
        Lake lake = lakeDao.getById(5);
        lakeDao.delete(lake);
        assertNull(lakeDao.getById(5));
    }

    @Test
    void getByPropertyEqual() {
        LakeDao lakeDao = new LakeDao();
        List<Lake> userLakes = lakeDao.getByPropertyEqual("userId", "1");
        assertEquals(3, userLakes.size());
        assertEquals(1, userLakes.get(0).getId());
    }
}