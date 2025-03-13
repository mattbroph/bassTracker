package com.mattbroph.persistence;

import com.mattbroph.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JournalDaoTest {

    GenericDao journalDao;
    GenericDao lakeDao;
    GenericDao userDao;
    GenericDao windDao;
    GenericDao weatherDao;
    GenericDao methodDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        journalDao = new GenericDao(Journal.class);
        lakeDao = new GenericDao(Lake.class);
        userDao = new GenericDao(User.class);
        windDao = new GenericDao(Wind.class);
        weatherDao = new GenericDao(Weather.class);
        methodDao = new GenericDao(Method.class);
    }

    @Test
    void getAll() {
        List<Journal> journals = (List<Journal>)journalDao.getAll();
        assertEquals(14, journals.size());
    }

    @Test
    void getById() {
        // Get ID 1
        Journal journal = (Journal)journalDao.getById(1);
        // Check if journal is null
        assertNotNull(journal);
        // Check journal name
        assertEquals("2025-02-25", journal.getJournalDate().toString());
    }

    @Test
    void update() {
        // Get the first journal
        Journal journal = (Journal)journalDao.getById(1);
        // Log the name of the journal
        logger.info("The LM19+ count before updating: " + journal.getLargeMouth19Plus());
        // Change the journal name
        journal.setLargeMouth19Plus(19);
        // Update the journal name in the db
        journalDao.update(journal);
        // Check the new journal name
        assertEquals(19, journal.getLargeMouth19Plus());
        // Log the new journal name
        logger.info("The LM19+ count after updating: " + journal.getLargeMouth19Plus());
    }

    @Test
    void insert() {
        int insertedjournalId;
        LocalDate localDate = LocalDate.now();

        // Get a lake
        Lake lake = (Lake)lakeDao.getById(1);
        // Get a user
        User user = (User)userDao.getById(1);
        // Get the wind
        Wind wind = (Wind)windDao.getById(1);
        // Get the weather
        Weather weather = (Weather)weatherDao.getById(1);
        // Get the method
        Method method = (Method)methodDao.getById(1);

        // Create a new journal
        Journal journal = new Journal(user, localDate, lake, 5, method, 80, weather, wind, "Had a really good time fishing today", "https://myimage.com88", 2, 3, 4, 8, 1, 0);
        // Do the insert and store the journal id
        insertedjournalId = journalDao.insert(journal);
        Journal journalInserted = (Journal)journalDao.getById(insertedjournalId);
        assertNotNull(journalInserted);
    }

    @Test
    void delete() {
        Journal journal = (Journal)journalDao.getById(3);
        journalDao.delete(journal);
        assertNull(journalDao.getById(3));
    }

    @Test
    void getByPropertyEqual() {

        List<Journal> journals = (List<Journal>)journalDao.getByPropertyEqual("id", "1");
        assertEquals(1, journals.size());
    }

    @Test
    void getByPropertyLike() {
        List<Journal> journals = (List<Journal>)journalDao.getByPropertyLike("imageURL", "https://myimage.com");
        assertEquals(1, journals.size());
    }

    @Test
    void findByPropertyEqual() {


        // Find all journals where user ID = 1 and Weather ID = 3
        User user = (User)userDao.getById(1);
        Weather weather = (Weather)weatherDao.getById(3);

        Map<String, Object> propertyMap = new HashMap<String, Object>();
        propertyMap.put("user", user);
        propertyMap.put("weather", weather);

        List<Journal> journals =
                 (List<Journal>)journalDao.findByPropertyEqual(propertyMap);

        assertEquals(2, journals.size());
        assertEquals("http://fakeImage2.com", journals.get(0).getImageURL());
        assertEquals(2, journals.get(0).getLargeMouth1416());
        assertEquals("http://fakeImage7.com", journals.get(1).getImageURL());
        assertEquals(3, journals.get(1).getLargeMouth1416());

    }
}