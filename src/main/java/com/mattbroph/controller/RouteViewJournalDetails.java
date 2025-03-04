package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.GenericDao;
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

        GenericDao userDao = new GenericDao(User.class);

        // TODO validate that the user has permission to view journal -
        // i.e. user id must match user id for journal before deleting
        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        // Reload user from database to avoid stale data
        User user = (User) userDao.getById(sessionUser.getId());


        // Get the journal id
        int journalId = Integer.parseInt(request.getParameter("journalId"));

        // Set the url param
        String url = "/viewJournalDetails.jsp?journalId=" + journalId;

        // Get the journal and add it the request
        GenericDao journalDao = new GenericDao(Journal.class);
        Journal journal = (Journal)journalDao.getById(journalId);
        request.setAttribute("journal", journal);

        // Update the session user object to keep data fresh
        session.setAttribute("user", user);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
