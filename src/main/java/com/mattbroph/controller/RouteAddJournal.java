package com.mattbroph.controller;

import com.mattbroph.entity.Lake;
import com.mattbroph.persistance.LakeDao;

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
        name = "routeAddJournalServlet",
        urlPatterns = { "/addJournal" }
)
public class RouteAddJournal extends HttpServlet {

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
        String url = "/addJournal.jsp";

        // TODO don't hardcode this user id
        // Get the user ID
        String userID = "1";

        // Get the list of Lakes matching the user ID
        LakeDao lakeDao = new LakeDao();
        List<Lake> userLakes =
                lakeDao.getByPropertyEqual("userId", userID);
        request.setAttribute("userLakes", userLakes);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
