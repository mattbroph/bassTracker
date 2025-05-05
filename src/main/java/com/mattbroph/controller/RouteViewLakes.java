package com.mattbroph.controller;

import com.mattbroph.entity.Lake;
import com.mattbroph.entity.User;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.PageTitleService;
import com.mattbroph.service.UserSessionValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/** Forwards the request to view lakes jsp page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeViewLakesServlet",
        urlPatterns = { "/viewLakes" }
)
public class RouteViewLakes extends HttpServlet {

    /**
     * Forwards to the View Lakes JSP
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);

        // Set the url param
        String url = "/viewLakes.jsp";

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.viewLakes");
        request.setAttribute("pageTitle", pageTitle);

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);
        
        /*
         * Check if user is logged in.
         * If they are not logged in, send them to the index jsp.
         * If they are logged in, send the user to the view lakes jsp.
         */
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
            return;

        } else {

            // Reload user from database to avoid stale data
            User user = (User) userDao.getById(sessionUser.getId());

            // Get the list of lakes matching the user id
            List<Lake> userLakes = user.getLakes();

            // Store the lakes in the request and forward onto jsp to be displayed
            request.setAttribute("userLakes", userLakes);

        }

        // Mark the Lakes Nav as active for CSS underline
        session.setAttribute("lastClicked", "Lakes");

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
