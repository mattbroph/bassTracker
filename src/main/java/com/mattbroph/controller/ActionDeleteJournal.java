package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.UserSessionValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Delete a journal entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionDeleteJournalsServlet",
        urlPatterns = { "/actionDeleteJournal" }
)
public class ActionDeleteJournal extends HttpServlet {


    /** Deletes a journal from the application database
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
        GenericDao journalDao = new GenericDao(Journal.class);

        // Declare the url
        String url;

        // Get the Journal ID to delete
        int journalId = Integer.parseInt(request.getParameter("journalId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
            return;
        }

        /* If user does not have access to delete journal id, send them to unauthorized page
         * If user does have access to delete journal id and is logged in, delete the journal
         */
        Journal journalToDelete = (Journal)journalDao.getById(journalId);

        if (journalToDelete.getUser().getId() != sessionUser.getId()) {
            response.sendRedirect("unauthorized.jsp");
            return;

        } else {

            // Delete the journal
            journalDao.delete(journalToDelete);

            // Create the url to forward
            url = request.getContextPath() + "/viewJournals";

        }

        // Send a redirect to the view journal detail page or the error page
        response.sendRedirect(url);

    }

}
