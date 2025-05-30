package com.mattbroph.controller;

import com.mattbroph.entity.*;
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
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Create Daos
        GenericDao lakeDao = new GenericDao(Lake.class);

        // Set the url param
        String url = "/editLake.jsp";

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.editLake");
        request.setAttribute("pageTitle", pageTitle);

        // Get the lake id
        int lakeId = Integer.parseInt(request.getParameter("lakeId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
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
