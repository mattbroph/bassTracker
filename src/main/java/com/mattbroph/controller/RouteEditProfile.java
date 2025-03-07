package com.mattbroph.controller;

import com.mattbroph.entity.BassGoal;
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
import java.util.List;


/** Forwards the request to the edit profile jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeEditProfileServlet",
        urlPatterns = { "/editProfile" }
)
public class RouteEditProfile extends HttpServlet {

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
        String url = "/editProfile.jsp";

        // Create the userDao
        GenericDao userDao = new GenericDao(User.class);

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        /*
        * Check if user is logged in.
        * If they are not logged in, send them to the index jsp.
        * If they are logged in, send the user to the edit profile jsp.
        */
        if (sessionUser == null) {

            response.sendRedirect("index.jsp");
            return;

        } else {

            // Reload user from database to avoid stale data
            User user = (User) userDao.getById(sessionUser.getId());

            // Store the user in the request and forward onto jsp to be displayed
            request.setAttribute("user", user);

        }

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
