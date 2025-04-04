package com.mattbroph.controller;

import com.mattbroph.entity.User;
import com.mattbroph.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Edit the profile that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionEditProfileServlet",
        urlPatterns = { "/actionEditProfile" }
)
public class ActionEditProfile extends HttpServlet {


    /** Edits the user profile in the application database
     *
     *@param request the HttpServletRequest object
     *@param response the HttpServletRequest object
     *@exception ServletException if there is a Servlet failure
     *@exception IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Get the necessary daos
        GenericDao userDao = new GenericDao(User.class);

        // Declare the url
        String url = request.getContextPath()
                + "/viewProfile";

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Create the user to edit
        User userToEdit = (User) userDao.getById(sessionUser.getId());

        // Edit parameters of the existing user
        editUserParameters(userToEdit, request);

        // Update the User
        userDao.update(userToEdit);

        // Provide a success message
        session.setAttribute("message", "Your profile has been updated.");

        // Send a redirect to the view user profile page
        response.sendRedirect(url);
    }

    /**
     * Retrieve parameters from form and update user attributes
     */
     public void editUserParameters(User userToEdit, HttpServletRequest request) {

         // Get the first name and set it
         String firstName = request.getParameter("firstName");
         userToEdit.setFirstName(firstName);

         // Get the last name and set it
         String lastName = request.getParameter("lastName");
         userToEdit.setLastName(lastName);

         // Get the profile picture and set it
         String profilePicture = request.getParameter("photo");
         userToEdit.setProfilePicture(profilePicture);


     }

}
