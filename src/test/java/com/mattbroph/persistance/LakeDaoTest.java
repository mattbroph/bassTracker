package com.mattbroph.persistance;

import com.mattbroph.entity.Lake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LakeDaoTest {

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
}