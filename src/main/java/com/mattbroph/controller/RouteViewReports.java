package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.PageTitleService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Forwards the request to reports jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeViewReportsServlet",
        urlPatterns = { "/viewReports" }
)
public class RouteViewReports extends HttpServlet {

    /**
     * Forwards to the reports jsp page
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
        String url = "/reports.jsp";

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.reports");
        request.setAttribute("pageTitle", pageTitle);

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {

            response.sendRedirect("index.jsp");
            return;

        } else {

            // Reload user from database to avoid stale data
            User user = (User) userDao.getById(sessionUser.getId());

            // Get the list of active Lakes matching the user ID
            List<Lake> userLakes = user.getLakes();

            List<Lake> userActiveLakes = new ArrayList<>();

            for (Lake lake : userLakes) {

                if (lake.getIsActive()) {
                    userActiveLakes.add(lake);
                }
            }

            // Get the list of methods, winds and weather
            GenericDao methodDao = new GenericDao(Method.class);
            List<Method> methodList = (List<Method>)methodDao.getAll();

            // Set attributes to make available in jsp
            request.setAttribute("userLakes", userActiveLakes);
            request.setAttribute("methodList", methodList);

            // Update the session user object to keep data fresh
            session.setAttribute("user", user);

            // Mark the weather tab as active to underline the nav
            session.setAttribute("lastClicked", "Reports");


        }

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
