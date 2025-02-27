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

        // Set the url param
        String url = "/editProfile.jsp";

        // TODO don't hardcode this user id
//        int userId = 1;
        // TODO come clean this up - probably store the user in the session

        // Get the user id
        int userId = Integer.parseInt(request.getParameter("userId"));

        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(userId);

        // Get the list of journals matching the user id
        List<BassGoal> bassGoals = user.getBassGoal();

        // Store the journals in the request and forward onto jsp to be displayed
        request.setAttribute("bassGoals", bassGoals);
        request.setAttribute("user", user);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
