package com.mattbroph.persistance;

import com.mattbroph.entity.Lake;
import com.mattbroph.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {


    GenericDao userDao;
    GenericDao lakeDao;

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
        User user = (User)userDao.getById(1);
        // Check if user is null
        assertNotNull(user);
        // Check username
        assertEquals("MattyB", user.getUserName());
    }

    @Test
    void getAll() {
        List<User> users = (List<User>)userDao.getAll();
        assertEquals(3, users.size());
    }

    @Test
    void update() {
        // Get the first user
        User user = (User)userDao.getById(1);
        // Log the name of the user
        logger.info("The user name before updating: " + user.getUserName());
        // Change the username
        user.setUserName("NewUserName");
        // Update the user name in the db
        userDao.update(user);
        // Check the new username
        assertEquals("NewUserName", user.getUserName());
        // Log the new username
        logger.info("The user name after updating: " + user.getUserName());
    }

    @Test
    void insert() {
        int insertedUserId;

        // Create a new user
        User user = new User("MyNewName", "Matt", "Brophy", "urlToMyImage.com");
        // Do the insert and store the user id
        insertedUserId = userDao.insert(user);
        User userInserted = (User)userDao.getById(insertedUserId);
        assertNotNull(userInserted);
        assertEquals("MyNewName", userInserted.getUserName());
    }


    // If a user is deleted, check that lakes are deleted as well
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

    @Test
    void getByPropertyEqual() {
        List<User> users = (List<User>)userDao.getByPropertyEqual("userName", "MattyB");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }

    @Test
    void getByPropertyLike() {
        List<User> users = (List<User>)userDao.getByPropertyLike("userName", "John");
        assertEquals(1, users.size());
        assertEquals(2, users.get(0).getId());
    }
}