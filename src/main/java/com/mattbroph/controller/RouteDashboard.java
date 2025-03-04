package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.service.DashboardCalculator;
import com.mattbroph.persistance.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
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

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");
        // Reload user from database to avoid stale data
        User user = (User) userDao.getById(sessionUser.getId());

        // TODO GET THE YEAR - UPDATE THIS TO AN INCOMING REQUEST ATTRIBUTE
        // If year has not been submitted, then use the current year
        // Basically setting this up for 2026
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();

        // Get the users bass goal for the year
        Map<String, Object> propertyMap = new HashMap<String, Object>();
        propertyMap.put("user", user);
        propertyMap.put("goalYear", year);

        List<BassGoal> bassGoal =
                (List<BassGoal>)bassGoalDao.findByPropertyEqual(propertyMap);

        // Used for calculations in the DashboardCalculator
        int yearBassGoal = bassGoal.get(0).getGoalCount();

        // Add the bassGoal to the request
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
        dashboardCalculator.calculateStatistics(dashboard, yearBassGoal);

        // Add the dashboard and user to the request
        request.setAttribute("dashboard", dashboard);

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}