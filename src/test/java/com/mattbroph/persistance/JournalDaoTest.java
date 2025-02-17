package com.mattbroph.persistance;

import com.mattbroph.entity.Journal;
import com.mattbroph.entity.Lake;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JournalDaoTest {

    GenericDao journalDao;
    GenericDao lakeDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        journalDao = new GenericDao(Journal.class);
        lakeDao = new GenericDao(Lake.class);
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

        // Create a new lake
        Lake lake = (Lake)lakeDao.getById(1);

        // Create a new journal
        Journal journal = new Journal(1, localDate, lake, 5, 2, 80, 2, 2, "Had a really good time fishing today", "https://myimage.com88", 2, 3, 4, 8, 1, 0);
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
        List<Journal> journals = (List<Journal>)journalDao.getByPropertyEqual("userID", "1");
        assertEquals(2, journals.size());
    }

    @Test
    void getByPropertyLike() {
        List<Journal> journals = (List<Journal>)journalDao.getByPropertyLike("imageURL", "https://myimage.com");
        assertEquals(1, journals.size());
    }
}