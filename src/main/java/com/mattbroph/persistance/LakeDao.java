package com.mattbroph.persistance;

import com.mattbroph.entity.Journal;
import com.mattbroph.entity.Lake;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class LakeDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get lake by id
     */
    public Lake getById(int id) {
        Session session = sessionFactory.openSession();
        Lake user = session.get(Lake.class, id);
        session.close();
        return user;
    }

    /**
     * Update a Lake
     * @param lake  Lake to be updated
     */
    public void update(Lake lake) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(lake);
        transaction.commit();
        session.close();
    }


    /**
     * Insert a new lake
     * @param lake  Lake to be inserted
     */
    public int insert(Lake lake) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(lake);
        transaction.commit();
        id = lake.getId();
        session.close();
        return id;
    }

    /**
     * Delete a Lake
     * @param lake Lake to be deleted
     */
    public void delete(Lake lake) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(lake);
        transaction.commit();
        session.close();
    }

    /**
     * Get Lakes by User ID
     *
     */
    public List<Lake> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Lake> query = builder.createQuery(Lake.class);
        Root<Lake> root = query.from(Lake.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<Lake> userLakes = session.createSelectionQuery( query ).getResultList();

        session.close();
        return userLakes;
    }



}
