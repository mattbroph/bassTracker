package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.GenericDao;
import org.apache.logging.log4j.core.appender.routing.Route;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** Forwards the request to view journal details jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeViewJournalDetailsServlet",
        urlPatterns = { "/viewJournalDetails" }
)
public class RouteViewJournalDetails extends HttpServlet {

    /**
     * Forwards to the View Journal Details JSP
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Create the journalDao
        GenericDao journalDao = new GenericDao(Journal.class);

        // Declare the url
        String url = "/viewJournalDetails.jsp";

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

         /* If user does not have access to journal id, send them to unauthorized page
         * If user does have access to journal id and is logged in, send them to
         * view journal details page.
         */
        Journal journal = (Journal)journalDao.getById(journalId);

        if (journal.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;

        } else {

            // Set the url param
            // TODO delete me if not needed url = "/viewJournalDetails.jsp?journalId=" + journalId;

            // Add journal to request
            request.setAttribute("journal", journal);

        }


        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
