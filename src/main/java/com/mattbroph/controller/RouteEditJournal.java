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
import java.util.List;

/** Forwards the request to edit journal jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeEditJournalServlet",
        urlPatterns = { "/editJournal" }
)
public class RouteEditJournal extends HttpServlet {

    /**
     * Forwards to the Edit Journal JSP
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
        GenericDao userDao = new GenericDao(User.class);
        GenericDao journalDao = new GenericDao(Journal.class);

        // Set the url param
        String url = "/editJournal.jsp";

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

        /* If user does not have access to edit journal id, send them to unauthorized page
         * If user does have access to edit journal id and is logged in, send them
         * to the edit journal jsp.
         */
        Journal journal = (Journal)journalDao.getById(journalId);

        if (journal.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;

        } else {

            // Reload user from database to avoid stale data
            User user = (User) userDao.getById(sessionUser.getId());

            // Get the list of Lakes matching the user ID
            List<Lake> userLakes = user.getLakes();

            // Get the list of methods, winds and weather
            GenericDao weatherDao = new GenericDao(Weather.class);
            List<Weather> weatherList = (List<Weather>)weatherDao.getAll();

            GenericDao windDao = new GenericDao(Wind.class);
            List<Wind> windList = (List<Wind>)windDao.getAll();

            GenericDao methodDao = new GenericDao(Method.class);
            List<Method> methodList = (List<Method>)methodDao.getAll();

            // Set attributes to make available in jsp
            request.setAttribute("journal", journal);
            request.setAttribute("userLakes", userLakes);
            request.setAttribute("weatherList", weatherList);
            request.setAttribute("windList", windList);
            request.setAttribute("methodList", methodList);

            // Update the session user object to keep data fresh
            session.setAttribute("user", user);

        }

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
