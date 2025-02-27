package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        // Set the url param
        String url = "/editJournal.jsp";

        // TODO don't hardcode this user id
        // Get the user ID
        int userId = 1;

        // Get the journal id
        int journalId = Integer.parseInt(request.getParameter("journalId"));

        // TODO come clean this up
        // Get the user (probably from the session)
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(userId);

        GenericDao journalDao = new GenericDao(Journal.class);
        Journal journal = (Journal)journalDao.getById(journalId);

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

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
