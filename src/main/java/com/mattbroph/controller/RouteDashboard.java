package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.PropertiesLoader;
import com.mattbroph.service.DashboardCalculator;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.PageTitleService;
import com.mattbroph.service.UserSessionValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Routes the user to the dashboard based on year
 *@author mbrophy
 */
@WebServlet(
        name = "routeDashboardServlet",
        urlPatterns = { "/dashboard" }
)
public class RouteDashboard extends HttpServlet implements PropertiesLoader {

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
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);
        GenericDao bassGoalDao = new GenericDao(BassGoal.class);

        // Set the url param
        String url = "/dashboard.jsp";

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.dashboard");
        request.setAttribute("pageTitle", pageTitle);

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
            return;
        }

        // Reload user from database to avoid stale data
        User user = (User) userDao.getById(sessionUser.getId());

        // If year has not been submitted, then use the current year
        int year;
        String dashboardYearParam = request.getParameter("dashboardYear");

        if (dashboardYearParam != null) {
            year = Integer.parseInt(request.getParameter("dashboardYear"));
        } else {
            LocalDate localDate = LocalDate.now();
            year = localDate.getYear();
        }

        // Get the user's bass goal for the year that will be displayed on
        // the dashboard
        Map<String, Object> propertyMap = new HashMap<String, Object>();
        propertyMap.put("user", user);
        propertyMap.put("goalYear", year);

        List<BassGoal> bassGoal =
                (List<BassGoal>)bassGoalDao.findByPropertyEqual(propertyMap);

        // Used for calculations in the DashboardCalculator
        int yearBassGoal = bassGoal.get(0).getGoalCount();

        // Add the bassGoal to the request. This is used to determine which
        // year of data to display on the dashboard
        request.setAttribute("bassGoal", bassGoal.get(0));

        // Add the entire list of bass goals to the request. This is used for
        // the dashboard form selection options
        List<BassGoal> bassGoalList = user.getBassGoal();
        request.setAttribute("bassGoalList", bassGoalList);

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

        // Update the session user object to keep data fresh
        session.setAttribute("user", user);

        // Mark the Dashboard Nav as active for CSS underline
        session.setAttribute("lastClicked", "Dashboard");

        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}