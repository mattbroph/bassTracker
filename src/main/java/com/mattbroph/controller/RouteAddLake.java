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

/** Forwards the request to add lake jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeAddLakeServlet",
        urlPatterns = { "/addLake" }
)
public class RouteAddLake extends HttpServlet {

    /**
     * Forwards to the Add Lake JSP
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
        String url = "/addLake.jsp";

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {

            response.sendRedirect("index.jsp");
            return;

        }

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
