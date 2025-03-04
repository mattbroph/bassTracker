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

        // Set the url param
        String url = "/addJournal.jsp";

        // TODO get user from the session
        // Get the user ID
//        int userId = 1;
        // NEW CODE
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

//        GenericDao userDao = new GenericDao(User.class);
//        User user = (User)userDao.getById(userId);

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

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
