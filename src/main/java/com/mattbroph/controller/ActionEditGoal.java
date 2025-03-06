package com.mattbroph.controller;

import com.mattbroph.entity.BassGoal;
import com.mattbroph.entity.Lake;
import com.mattbroph.entity.User;
import com.mattbroph.persistance.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Edit a bass goal entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionEditGoalServlet",
        urlPatterns = { "/actionEditGoal" }
)
public class ActionEditGoal extends HttpServlet {


    /** Edits a bass goal in the application database
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

        // Declare the url
        String url = request.getContextPath()
                + "/viewProfile";

        // Get the bass goal id to update
        int goalId = Integer.parseInt(request.getParameter("goalId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        /* If user does not have access to edit goal id, send them to unauthorized page
         * If user does have access to edit goal id and is logged in, edit the goal
         */
        BassGoal bassGoalToEdit = (BassGoal)bassGoalDao.getById(goalId);

        if (bassGoalToEdit.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;
         }

        // Edit parameters of the existing bass goal
        editBassGoalParameters(bassGoalToEdit, request);

        // Update the bass goal
        bassGoalDao.update(bassGoalToEdit);

        // Provide a success message
        session.setAttribute("message", bassGoalToEdit.getGoalYear()
                + " bass goal was edited successfully.");

        // Send a redirect to the view profile page
        response.sendRedirect(url);
    }

    /**
     * Retrieve parameters from form and update bass goal attributes in database
     */
     public void editBassGoalParameters(BassGoal bassGoalToEdit, HttpServletRequest request) {

         // Get the new goal count and set it
         int goalCount = Integer.parseInt(request.getParameter("bassGoal"));
         bassGoalToEdit.setGoalCount(goalCount);


     }

}
