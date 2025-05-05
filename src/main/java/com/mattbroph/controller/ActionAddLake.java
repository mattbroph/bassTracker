package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.FormValidation;
import com.mattbroph.service.UserSessionValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Adds a lake entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionAddLakeServlet",
        urlPatterns = { "/actionAddLake" }
)
public class ActionAddLake extends HttpServlet implements FormValidation {


    /** Adds a new lake to the application database
     *
     *@param request the HttpServletRequest object
     *@param response the HttpServletRequest object
     *@exception ServletException if there is a Servlet failure
     *@exception IOException if there is an IO failure
     */
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Local variables
        boolean lakeExists = false;

        // Get the necessary daos
        GenericDao lakeDao = new GenericDao(Lake.class);
        GenericDao userDao = new GenericDao(User.class);

        // Create a list to hold validator error messages
        List<String> violationMessages;

        // Build forwarding url variable
        String url = "";

        // Id of the row inserted
        int insertedLakeId = 0;

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
            return;
        }

        // Reload user from database to avoid stale data
        User user = (User) userDao.getById(sessionUser.getId());

        // Retrieve the data from the form
        Lake newLake = retrieveFormData(request, user);

        // Check for any hibernate using implemented FormValidation Interface
        violationMessages = validateFormData(newLake);

        // If there are violations, stop processing doPost and display errors on jsp
        if (!violationMessages.isEmpty()) {
            session.setAttribute("errorMessages", violationMessages);
            url = request.getContextPath() + "/addLake";
            response.sendRedirect(url);
            return;
        }

        // Check to see if lake already exists for this user
        List<Lake> existingLakes = user.getLakes();

        for (Lake lake : existingLakes) {

            if (lake.getLakeName().equalsIgnoreCase((newLake.getLakeName()))) {
                lakeExists = true;
                break;
            }
        }
        /* If lake name already exists for this user, don't do the insert
        * and send them back to the jsp with a message saying that lake already
        * exists.
         */
        if (lakeExists) {

            session.setAttribute("lakeMessage", newLake.getLakeName()
                    + " already exists. Lake name must be unique.");

            url = request.getContextPath() + "/addLake";

        } else {

            // Add the lake to the database
            insertedLakeId = lakeDao.insert(newLake);

            // If insertedLakeId > 0 insert was successful, send to the view lakes jsp
            // and note that the lake has been added
            if (insertedLakeId > 0) {
                session.setAttribute("lakeMessage", newLake.getLakeName()
                        + " was added.");

                url = request.getContextPath() + "/viewLakes";
            }
        }

        // Send a redirect to the view lakes page or the error page
        response.sendRedirect(url);
    }


    /**
     * Retrieves the data from the add lake form and creates a lake object with it.
     * @return the lake to add to the database
     */
     private Lake retrieveFormData(HttpServletRequest request, User user) {

         // Get the form data
         String lakeName = request.getParameter("lakeName");
         boolean isActive = Boolean.parseBoolean(request.getParameter("status"));

         // Construct the lake object
         Lake newLake = new Lake(lakeName, user, isActive);

         return newLake;
     }
}
