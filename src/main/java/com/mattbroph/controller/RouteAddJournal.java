package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.GenericDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/** Forwards the request to add journals jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeAddJournalServlet",
        urlPatterns = { "/addJournal" }
)
public class RouteAddJournal extends HttpServlet {

    /**
     * Forwards to the Add Journals JSP
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

        // Set the url param
        String url = "/addJournal.jsp";

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
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
        request.setAttribute("userLakes", userLakes);
        request.setAttribute("weatherList", weatherList);
        request.setAttribute("windList", windList);
        request.setAttribute("methodList", methodList);

        // Update the session user object to keep data fresh
        session.setAttribute("user", user);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
