package com.mattbroph.persistence;

import com.mattbroph.entity.Lake;
import com.mattbroph.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the user CRUD operations
 * @author mbrophy
 */
class UserDaoTest {


    GenericDao userDao;
    GenericDao lakeDao;

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Reloads a fresh database via a script before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("fresh_db.sql");
        lakeDao = new GenericDao(Lake.class);
        userDao = new GenericDao(User.class);
    }

    /**
     * Tests getting a user by id
     */
    @Test
    void getById() {
        // Get ID 1
        User user = (User)userDao.getById(1);
        // Check if user is null
        assertNotNull(user);
        // Check user email
        assertEquals("mattbroph@gmail.com", user.getUserEmail());
    }

    /**
     * Tests getting all of the users
     */
    @Test
    void getAll() {
        List<User> users = (List<User>)userDao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Tests updating a user by id
     */
    @Test
    void update() {
        // Get the first user
        User user = (User)userDao.getById(1);
        // Log the name of the user
        logger.info("The user email before updating: " + user.getUserEmail());
        // Change the user email
        user.setUserEmail("NewUserEmail@gmail.com");
        // Update the user name in the db
        userDao.update(user);
        // Check the new user email
        assertEquals("NewUserEmail@gmail.com", user.getUserEmail());
        // Log the new user email
        logger.info("The user email after updating: " + user.getUserEmail());
    }

    /**
     * Tests inserting a new user
     */
    @Test
    void insert() {
        int insertedUserId;

        // Create a new user
        User user = new User("MyNewName@gmail.com", "Matt", "Brophy", "urlToMyImage.com");
        // Do the insert and store the user id
        insertedUserId = userDao.insert(user);
        User userInserted = (User)userDao.getById(insertedUserId);
        assertNotNull(userInserted);
        assertEquals("MyNewName@gmail.com", userInserted.getUserEmail());
    }

    /**
     * Tests deleting a user by id
     */
    @Test
    void delete() {
        User user = (User)userDao.getById(1);
        // Delete the user
        userDao.delete(user);
        // Check that the user no longer exists in the user table
        assertNull(userDao.getById(1));
        // Check that the user's lakes no longer exist in the lake table
        assertNull(lakeDao.getById(1));
        assertNull(lakeDao.getById(2));
        assertNull(lakeDao.getById(3));
    }

    /**
     * Tests getting a list of users by property equals
     */
    @Test
    void getByPropertyEqual() {
        List<User> users = (List<User>)userDao.getByPropertyEqual("userEmail", "mattbroph@gmail.com");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    /**
     * Tests getting a list of users by property like
     */
    @Test
    void getByPropertyLike() {
        List<User> users = (List<User>)userDao.getByPropertyLike("userEmail", "matt");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }
}