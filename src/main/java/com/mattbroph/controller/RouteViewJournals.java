package com.mattbroph.controller;

import com.mattbroph.entity.Journal;
import com.mattbroph.entity.User;
import com.mattbroph.persistance.GenericDao;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/** Forwards the request to view journals jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeViewJournalsServlet",
        urlPatterns = { "/viewJournals" }
)
public class RouteViewJournals extends HttpServlet {

    /**
     * Forwards to the View Journals JSP
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
        String url = "/viewJournals.jsp";

        // TODO don't hardcode this user id
        int userId = 1;
        // TODO come clean this up - probably store the user in the session
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(userId);

        // Get the list of journals matching the user id
        List<Journal> journals = user.getJournals();

        // Store the journals in the request and forward onto jsp to be displayed
        request.setAttribute("journals", journals);
        request.setAttribute("user", user);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
