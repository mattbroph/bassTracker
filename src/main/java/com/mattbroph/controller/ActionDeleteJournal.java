package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;


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
        GenericDao userDao = new GenericDao(User.class);
        GenericDao journalDao = new GenericDao(Journal.class);

        // Get access to the session
        HttpSession session = request.getSession();

        // Get the Journal ID to delete
        int journalId = Integer.parseInt(request.getParameter("journalId"));

        // TODO Get the user from the session and validate they can delete this journal
        User user = (User)userDao.getById(1);

        // Get the journal to delete
        Journal journalToDelete = (Journal)journalDao.getById(journalId);

        // Delete the journal
        journalDao.delete(journalToDelete);

        // Create the url to forward
        String url = request.getContextPath() + "/viewJournals";

        // Send a redirect to the view journal detail page or the error page
        response.sendRedirect(url);

    }

}
