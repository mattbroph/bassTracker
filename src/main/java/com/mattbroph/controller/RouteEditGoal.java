package com.mattbroph.controller;

import com.mattbroph.entity.BassGoal;
import com.mattbroph.entity.Lake;
import com.mattbroph.entity.User;
import com.mattbroph.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/** Forwards the request to the edit profile jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeEditGoalServlet",
        urlPatterns = { "/editGoal" }
)
public class RouteEditGoal extends HttpServlet {

    /**
     * Forwards to the Edit Profile JSP
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Declare the url
        String url = "/editGoal.jsp";

        // Create the userDao
        GenericDao userDao = new GenericDao(User.class);
        GenericDao bassGoalDao = new GenericDao(BassGoal.class);

        // Get the goal id to update
        int goalId = Integer.parseInt(request.getParameter(("goalId")));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        /*
        * Check if user is logged in.
        * If they are not logged in, send them to the index jsp.
        */
        if (sessionUser == null) {

            response.sendRedirect("index.jsp");
            return;
        }

        /* If user does not have access to edit goal id, send them to unauthorized page
         * If user does have access to edit goal id and is logged in, send them
         * to the edit goal jsp.
         */
        BassGoal bassGoal = (BassGoal) bassGoalDao.getById(goalId);

        if (bassGoal.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;

        }

        // Reload user from database to avoid stale data
        User user = (User) userDao.getById(sessionUser.getId());

        // Store the user in the request and forward onto jsp to be displayed
        request.setAttribute("user", user);
        request.setAttribute("bassGoal", bassGoal);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
