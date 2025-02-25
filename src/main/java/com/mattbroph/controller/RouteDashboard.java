package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.DashboardCalculator;
import com.mattbroph.persistance.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes the user to the dashboard based on year
 *@author mbrophy
 */
@WebServlet(
        name = "routeDashboardServlet",
        urlPatterns = { "/dashboard" }
)
public class RouteDashboard extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Forwards to the Dashboard JSP to display dashboard information for a given
     * year
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
        GenericDao bassGoalDao = new GenericDao(BassGoal.class);

        // Set the url param
        String url = "/dashboard.jsp";

        // TODO get user id from session
        // Get the user ID
        int userId = 1;

        // TODO GET THE YEAR - UPDATE THIS TO AN INCOMING REQUEST ATTRIBUTE
        int year = 2025;

        // TODO GET THE USER

        User user = (User)userDao.getById(userId);

        // Get the users bass goal for the year
        Map<String, Object> propertyMap = new HashMap<String, Object>();
        propertyMap.put("user", user);
        propertyMap.put("goalYear", year);

        List<BassGoal> bassGoal =
                (List<BassGoal>)bassGoalDao.findByPropertyEqual(propertyMap);

        int userBassGoal = bassGoal.get(0).getGoalCount();

        request.setAttribute("bassGoal", bassGoal.get(0));

        // Get the users journals
        List<Journal> journals = user.getJournals();

        // Build a list of journals for the desired year
        List<Journal> filteredJournals = new ArrayList<>();

        for (Journal journal : journals) {

            if (journal.getJournalDate().getYear() == year) {
                filteredJournals.add(journal);
            }
        }

        // Instantiate Dashboard entity with desired list of journals
        Dashboard dashboard = new Dashboard(filteredJournals);

        // Run calculations in the DashboardCalculator class and set the values
        // for the Dashboard object
        DashboardCalculator dashboardCalculator = new DashboardCalculator();
        dashboardCalculator.calculateStatistics(dashboard, userBassGoal);

        // Add the dashboard and user to the request
        request.setAttribute("dashboard", dashboard);
        request.setAttribute("user", user);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}