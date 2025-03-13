package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/** Forwards the request to view journals details jsp page with a delete
* message at the top
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeDeleteJournalServlet",
        urlPatterns = { "/deleteJournal" }
)
public class RouteDeleteJournal extends HttpServlet {

    /**
     * Forwards to the View Journal Detail JSP with Delete message and buttons
     * at the top
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Create Daos
        GenericDao journalDao = new GenericDao(Journal.class);

        // Set the url
        String url;

        // Get the journal id
        int journalId = Integer.parseInt(request.getParameter("journalId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        /* If user does not have access to delete journal id, send them to unauthorized page
         * If user does have access to delete journal id and is logged in, send them to delete
         * journal jsp.
         */
        Journal journal = (Journal)journalDao.getById(journalId);

        if (journal.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;

        } else {

            // Set attributes to make available in jsp
            request.setAttribute("journal", journal);

            // Update the session message
            session.setAttribute("deleteJournalMessage",
                    "Confirm deletion of the following journal entry:");

        }
        // Set the url param
        url = "/viewJournalDetails.jsp?journalId=" + journalId;



        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
