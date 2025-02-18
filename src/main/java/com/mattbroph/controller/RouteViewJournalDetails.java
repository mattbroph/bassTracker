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

/** Forwards the request to view journals jsp page
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

        // Set the url param
        String url = "/viewJournalDetails.jsp";


        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
