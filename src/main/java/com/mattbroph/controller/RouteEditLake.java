package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/** Forwards the request to edit lake jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeEditLakeServlet",
        urlPatterns = { "/editLake" }
)
public class RouteEditLake extends HttpServlet {

    /**
     * Forwards to the Edit Lake JSP
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Create Daos
        GenericDao lakeDao = new GenericDao(Lake.class);

        // Set the url param
        String url = "/editLake.jsp";

        // Get the lake id
        int lakeId = Integer.parseInt(request.getParameter("lakeId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        /* If user does not have access to edit lake id, send them to unauthorized page
         * If user does have access to edit lake id and is logged in, send them
         * to the edit lake jsp.
         */
        Lake lake = (Lake)lakeDao.getById(lakeId);

        if (lake.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;

        }

        // Set attributes to make available in jsp
        request.setAttribute("lake", lake);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
