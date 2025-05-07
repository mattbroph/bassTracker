package com.mattbroph.persistence;

import com.mattbroph.entity.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the method CRUD operations
 * @author mbrophy
 */
class MethodDaoTest {

    GenericDao methodDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Reloads a fresh database via a script before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        methodDao = new GenericDao(Method.class);
    }

    /**
     * Tests getting all of the methods
     */
    @Test
    void getAll() {
        List<Method> methods = (List<Method>)methodDao.getAll();
        assertEquals(12, methods.size());
    }

    /**
     * Tests getting a method by id
     */
    @Test
    void getById() {
        // Get ID 1
        Method method = (Method)methodDao.getById(1);
        // Check if method is null
        assertNotNull(method);
        // Check method type
        assertEquals("Crankbaits", method.getMethodName());
    }

    /**
     * Tests updating a method by id
     */
    @Test
    void update() {
        // Get the first method
        Method method = (Method)methodDao.getById(1);
        // Log the name of the method
        logger.info("The method name before updating: " + method.getMethodName());
        // Change the method name
        method.setMethodName("MethodBeenUpdated");
        // Update the method name in the db
        methodDao.update(method);
        // Check the new method name
        assertEquals("MethodBeenUpdated", method.getMethodName());
        // Log the new method name
        logger.info("The method name after updating: " + method.getMethodName());
    }

    /**
     * Tests inserting a new method
     */
    @Test
    void insert() {
        int insertedMethodId;

        // Create a new method type
        Method method = new Method("SuperFishing");
        // Do the insert and store the method id
        insertedMethodId = methodDao.insert(method);
        Method methodInserted = (Method)methodDao.getById(insertedMethodId);
        assertNotNull(methodInserted);
        assertEquals("SuperFishing", methodInserted.getMethodName());
    }

    /**
     * Tests deleting a method by id
     */
    @Test
    void delete() {
        Method method = (Method)methodDao.getById(5);
        methodDao.delete(method);
        assertNull(methodDao.getById(5));
    }

    /**
     * Tests getting a list of methods by property equals
     */
    @Test
    void getByPropertyEqual() {
        List<Method> methods = (List<Method>)methodDao.getByPropertyEqual("methodName", "Bed fishing");
        assertEquals(1, methods.size());
        assertEquals(3, methods.get(0).getId());
    }

    /**
     * Tests getting a list of methods by property like
     */
    @Test
    void getByPropertyLike() {
        List<Method> methods = (List<Method>)methodDao.getByPropertyLike("methodName", "fishing");
        assertEquals(4, methods.size());
    }
}