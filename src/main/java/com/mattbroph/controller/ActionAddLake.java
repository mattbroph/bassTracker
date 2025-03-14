package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Adds a lake entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionAddLakeServlet",
        urlPatterns = { "/actionAddLake" }
)
public class ActionAddLake extends HttpServlet {


    /** Adds a new lake to the application database
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
        GenericDao lakeDao = new GenericDao(Lake.class);

        // Build forwarding url variable
        String url = "";

        // Id of the row inserted
        int insertedLakeId = 0;

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Retrieve the data from the form
        Lake newLake = retrieveFormData(request, sessionUser);

        // Check to see if lake already exists for this user
        List<Lake> existingLakes = lakeDao.getByPropertyEqual("lakeName", newLake.getLakeName());

        if (existingLakes.size() > 0) {

            // Don't do the insert, send them back to the jsp with a message
            // saying that lake already exists.
            session.setAttribute("lakeMessage", newLake.getLakeName()
                    + " already exists. Lake name must be unique.");

            url = request.getContextPath() + "/addLake";

        } else {

            // Add the lake to the database
            insertedLakeId = lakeDao.insert(newLake);

        }


        // If insertedLakeId > 0 insert was successful, send to the view lakes jsp
        // and note that the lake has been added
        if (insertedLakeId > 0) {
            session.setAttribute("lakeMessage", newLake.getLakeName()
                    + " was added.");

            url = request.getContextPath() + "/viewLakes";
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
