package com.mattbroph.controller;

import com.mattbroph.entity.User;
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

/** Forwards the request to the weather form page
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeWeatherServlet",
        urlPatterns = { "/weather" }
)
public class RouteWeather extends HttpServlet {

    /**
     * Forwards to the weather form page
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
        String url = "/weather.jsp";

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.weather");
        request.setAttribute("pageTitle", pageTitle);

        // Mark the weather tab as active to underline the nav
        HttpSession session = request.getSession();
        session.setAttribute("lastClicked", "Weather");

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
