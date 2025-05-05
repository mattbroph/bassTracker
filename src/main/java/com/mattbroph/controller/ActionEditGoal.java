package com.mattbroph.controller;

import com.mattbroph.entity.BassGoal;
import com.mattbroph.entity.User;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.FormValidation;
import com.mattbroph.service.UserSessionValidator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Edit a bass goal entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionEditGoalServlet",
        urlPatterns = { "/actionEditGoal" }
)
public class ActionEditGoal extends HttpServlet implements FormValidation {


    /** Edits a bass goal in the application database
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

        // Create a list to hold validator error messages
        List<String> violationMessages;

        // Get the necessary daos
        GenericDao bassGoalDao = new GenericDao(BassGoal.class);

        // Declare the url
        String url = request.getContextPath()
                + "/viewProfile";

        // Get the bass goal id to update
        int goalId = Integer.parseInt(request.getParameter("goalId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
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

        // Check for any hibernate using implemented FormValidation Interface
        violationMessages = validateFormData(bassGoalToEdit);

        // If there are violations, stop processing doPost and display errors on jsp
        if (!violationMessages.isEmpty()) {
            session.setAttribute("errorMessages", violationMessages);
            url = "editGoal?goalId=" + bassGoalToEdit.getId();
            response.sendRedirect(url);
            return;
        }

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
     *
     * @param bassGoalToEdit the bass goal object to be updated
     * @param request the http request
     */
     public void editBassGoalParameters(BassGoal bassGoalToEdit, HttpServletRequest request) {

         // Get the new goal count and set it
         int goalCount = Integer.parseInt(request.getParameter("bassGoal"));
         bassGoalToEdit.setGoalCount(goalCount);


     }

}
