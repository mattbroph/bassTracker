package com.mattbroph.controller;

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
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Declare the url
        String url = "/editProfile.jsp";

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.editProfile");
        request.setAttribute("pageTitle", pageTitle);

        // Create the userDao
        GenericDao userDao = new GenericDao(User.class);

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
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
