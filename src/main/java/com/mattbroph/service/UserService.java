package com.mattbroph.service;


import com.mattbroph.entity.User;
import com.mattbroph.persistance.GenericDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Checks the UserEmail provided from the Auth controller and adds the user to
 * the session. If the user does not exist, the service will first add the user
 * to the database and then add the user to the session.
 */

public class UserService {


    /**
     * Checks if the user exists in the database and puts it in the session.
     * If user does not exist, add it to the database and then put it in the session.
     *
     * @param
     */
    public void addUserSession(User user, HttpServletRequest req) {

        GenericDao userDao = new GenericDao(User.class);

        HttpSession session = req.getSession();

        // Check if the user exists in the database
        List<User> userList = userDao.getByPropertyEqual("userEmail", user.getUserEmail());


        // If the user exists then add it to the session variable
        if (userList.size() == 1) {

            /* Only one user can exist with the same email, so grab the first
            *  and only user from the list
            */
            user = userList.get(0);
            // Store the user in the session
            session.setAttribute("user", user);

        } else {

            // If the user does not exist yet, add it to the database
//            userDao.


        }





    }




}
