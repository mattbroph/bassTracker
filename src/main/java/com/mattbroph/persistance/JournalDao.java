package com.mattbroph.persistance;

import com.mattbroph.entity.Journal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class JournalDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get journal by id
     */
    public Journal getById(int id) {
        Session session = sessionFactory.openSession();
        Journal journal = session.get(Journal.class, id);
        session.close();
        return journal;
    }

    /**
     * Update a journal
     * @param journal  Journal to be updated
     */
    public void update(Journal journal) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(journal);
        transaction.commit();
        session.close();
    }


    /**
     * Insert a new journal
     * @param journal  Journal to be inserted
     */
    public int insert(Journal journal) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(journal);
        transaction.commit();
        id = journal.getId();
        session.close();
        return id;
    }

    /**
     * Delete a Journal
     * @param journal journal to be deleted
     */
    public void delete(Journal journal) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(journal);
        transaction.commit();
        session.close();
    }



}
