package com.mattbroph.controller;

import com.mattbroph.entity.BassGoal;
import com.mattbroph.entity.User;
import com.mattbroph.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/** Forwards the request to view profile jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeViewProfileServlet",
        urlPatterns = { "/viewProfile" }
)
public class RouteViewProfile extends HttpServlet {

    /**
     * Forwards to the View Profile JSP
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Create the userDao
        GenericDao userDao = new GenericDao(User.class);

        // Declare the url
        String url = "/viewProfile.jsp";

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        /*
         * Check if user is logged in.
         * If they are not logged in, send them to the index jsp.
         * If they are logged in, send the user to the view profile jsp.
         */
        if (sessionUser == null) {

            response.sendRedirect("index.jsp");
            return;

        } else {

            // Reload user from database to avoid stale data
            User user = (User) userDao.getById(sessionUser.getId());

            // Get the list of journals matching the user id
            List<BassGoal> bassGoals = user.getBassGoal();

            // Store the journals in the request and forward onto jsp to be displayed
            request.setAttribute("bassGoals", bassGoals);
            request.setAttribute("user", user);

        }

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
