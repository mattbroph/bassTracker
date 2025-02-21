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
import java.util.List;

/**
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeDashboardServlet",
        urlPatterns = { "/dashboard" }
)
public class RouteDashboard extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Forwards to the Dashboard JSP
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
        String url = "/dashboard.jsp";

        // TODO don't hardcode this user id
        // Get the user ID
        int userId = 1;

        // TODO GET THE YEAR - UPDATE THIS TO AN INCOMING REQUEST ATTRIBUTE
        int year = 2025;

        // TODO GET THE USER
        // Get the user (probably from the session)
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getById(userId);

        // TODO Get the users bass goals
        List<BassGoal> bassGoals = user.getBassGoal();

        // TODO Get the users journals
        List<Journal> journals = user.getJournals();

        // If the journal isn't from the desired year, remove it
        List<Journal> filteredJournals = new ArrayList<>();
        for (Journal journal : journals) {

            if (journal.getJournalDate().getYear() == year) {
                filteredJournals.add(journal);
            }
        }

        // Instantiate Dashboard entity with desired list of journals
        Dashboard dashboard = new Dashboard(filteredJournals);

        // Run calculations in the Dashboard class and set the values
        DashboardCalculator dashboardCalculator = new DashboardCalculator();
        dashboardCalculator.calculateStatistics(dashboard);

        // Add the dashboard to the request
        request.setAttribute("dashboard", dashboard);

        // Get the goal count that matches the requested year
        for (BassGoal bassGoal : bassGoals) {

            if (bassGoal.getGoalYear() == year) {
                request.setAttribute("bassGoal", bassGoal);
                logger.info("the bass goal for 2025 is: " + bassGoal.getGoalCount());
            }

        }


        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
