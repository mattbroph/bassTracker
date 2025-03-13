package com.mattbroph.controller;

import com.mattbroph.entity.BassGoal;
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
 * Adds a bass goal entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionAddGoalServlet",
        urlPatterns = { "/actionAddGoal" }
)
public class ActionAddGoal extends HttpServlet {


    /** Adds a new bass goal to the application database
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
        GenericDao bassGoalDao = new GenericDao(BassGoal.class);

        // Build forwarding url variable
        String url;

        // Id of the row inserted
        int insertedBassGoalId = 0;

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        // Retrieve the data from the form
        BassGoal newBassGoal = retrieveFormData(request, sessionUser);

        // Add the bass goal to the database
        insertedBassGoalId = bassGoalDao.insert(newBassGoal);

        // If insertedBassGoalId > 0 insert was successful, send to the view bass goals jsp
        // and note that the bass goal has been added
        if (insertedBassGoalId > 0) {
            session.setAttribute("message", newBassGoal.getGoalYear()
                    + " bass goal was added.");

            // Set the url for the redirect
            url = request.getContextPath() + "/viewProfile";

        } else {

            session.setAttribute("errorMessage", "Something went wrong, "
                    + " your bass goal has not been added.");

            url = request.getContextPath() + "/error.jsp";
        }

        // Send a redirect to the view bass goals page or the error page
        response.sendRedirect(url);
    }


    /**
     * Retrieves the data from the add bass goal form and creates a bass goal object with it.
     * @return the bass goal to add to the database
     */
     private BassGoal retrieveFormData(HttpServletRequest request, User user) {

         // Get the form data
         int goalYear = Integer.parseInt(request.getParameter("year"));
         int goalCount = Integer.parseInt(request.getParameter("bassGoal"));
         
         // Construct the bass goal object
         BassGoal newBassGoal = new BassGoal(user, goalYear, goalCount);

         return newBassGoal;

     }


}
