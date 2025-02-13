package com.mattbroph.persistance;

import com.mattbroph.entity.Journal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JournalDaoTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
    }

    @Test
    void getById() {
        JournalDao journalDao = new JournalDao();
        // Get ID 1
        Journal journal = journalDao.getById(1);
        // Check if journal is null
        assertNotNull(journal);
        // Check journal name
        assertEquals("2025-02-25", journal.getJournalDate().toString());
    }

    @Test
    void update() {
        // Get the first journal
        JournalDao journalDao = new JournalDao();
        Journal journal = journalDao.getById(1);
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
        JournalDao journalDao = new JournalDao();
        LocalDate localDate = LocalDate.now();
        // Create a new journal
        Journal journal = new Journal(1, localDate, 2, 5, 2, 80, 2, 2, "Had a really good time fishing today", "https://myimage.com88", 2, 3, 4, 8, 1, 0);
        // Do the insert and store the journal id
        insertedjournalId = journalDao.insert(journal);
        Journal journalInserted = journalDao.getById(insertedjournalId);
        assertNotNull(journalInserted);
    }

    @Test
    void delete() {
        JournalDao journalDao = new JournalDao();
        Journal journal = journalDao.getById(3);
        journalDao.delete(journal);
        assertNull(journalDao.getById(3));
    }

    @Test
    void getByPropertyEqual() {
        JournalDao journalDao = new JournalDao();
        List<Journal> journals = journalDao.getByPropertyEqual("userID", "1");
        assertEquals(2, journals.size());
        assertEquals(1, journals.get(0).getId());



    }
}