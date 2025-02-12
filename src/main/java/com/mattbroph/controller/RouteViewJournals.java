package com.mattbroph.controller;

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

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
