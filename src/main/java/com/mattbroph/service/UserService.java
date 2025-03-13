package com.mattbroph.service;


import com.mattbroph.entity.BassGoal;
import com.mattbroph.entity.User;
import com.mattbroph.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

/**
 * Checks the UserEmail provided from the Auth controller and adds the user to
 * the session. If the user does not exist, the service will first add the user
 * to the database and then add the user to the session.
 */

public class UserService {

    // Instance variables
    private final Logger logger = LogManager.getLogger(this.getClass());
    private final GenericDao userDao = new GenericDao(User.class);
    private final GenericDao bassGoalDao = new GenericDao(BassGoal.class);

    /**
     * Checks if the user exists in the database and puts it in the session.
     * If user does not exist, add it to the database and then put it in the session.
     *
     * @param user the user from cognito
     * @param req the HttpServletRequest object
     */
    public void addUserSession(User user, HttpServletRequest req) {

        // Get access to the session
        HttpSession session = req.getSession();

        // Check if the user exists in the database
        List<User> userList = userDao.getByPropertyEqual("userEmail", user.getUserEmail());


        /* If the user exists then add it to the session variable.
        *  This will grab the First Name and Last Name and Profile Picture from
        * the database.
        */
        if (userList.size() == 1) {
            /* Only one user can exist with the same email, so grab the first
            *  and only user from the list
            */
            user = userList.get(0);
            // Store the user in the session
            session.setAttribute("user", user);

        } else {
            /*
            * If the user does not exist yet, add it to the database. Use the
            * Cognito jwt claim variables for first name and last name to create
            * the user.
            */
            int insertedUserId = 0;

            insertedUserId = userDao.insert(user);

            User newUser = (User) userDao.getById(insertedUserId);

            if (insertedUserId > 0) {
                /*
                * If the user was inserted successfully, create a bass goal for
                * the current year for the user.
                */
                int insertedBassGoalId = 0;
                LocalDate localDate = LocalDate.now();
                int year = localDate.getYear();

                // Insert bass goal
                BassGoal bassGoal = new BassGoal(newUser, year, 0);
                insertedBassGoalId = bassGoalDao.insert(bassGoal);

                // TODO not sure if this is true if an insert fails or not
                if (insertedBassGoalId == 0) {

                    logger.error("User created but bass goal insert failed"
                            + " for user: " + user.getUserEmail());
                    session.setAttribute("newUserError", "User created but"
                            + " bass goal insert failed");
                }

                session.setAttribute("user", newUser);

            } else {
                logger.error("Failed to insert new user into database: "
                        + user.getUserEmail());
                session.setAttribute("newUserError", "User could not be"
                        + " created, please try to sign up again.");
            }

        }
    }
}
