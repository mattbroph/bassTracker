package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.ProfileStatsCalculator;
import com.mattbroph.service.UserSessionValidator;

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
 *
 *@author mbrophy
 */
@WebServlet(
        name = "actionCreateReportServlet",
        urlPatterns = { "/actionCreateReport" }
)
public class ActionCreateReport extends HttpServlet {


    /**
     *
     *@param request the HttpServletRequest object
     *@param response the HttpServletRequest object
     *@exception ServletException if there is a Servlet failure
     *@exception IOException if there is an IO failure
     */
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Get the necessary daos
        GenericDao userDao = new GenericDao(User.class);
        GenericDao journalDao = new GenericDao(Journal.class);

        // Build forwarding url variable
        String url = "/reports.jsp";

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
            return;
        }

        // Get the user
        User user = (User) userDao.getById(sessionUser.getId());

        // Retrieve the lake and method data from the form
        Map<String, Object> propertiesMap = retrieveFormData(request, user);

        // Get the list of journals matching the user, lake and method selection
        List<Journal> journals = (List<Journal>)journalDao.findByPropertyEqual(propertiesMap);

        // Get the start date and convert to local date
        String startDate = request.getParameter("startDate");
        LocalDate localStartDate;

        try {
            localStartDate = LocalDate.parse(startDate);

        } catch (Exception e) {
            session.setAttribute("errorMessages", "Invalid start date format. Please use yyyy-MM-dd.");
            response.sendRedirect("viewReports");
            return;
        }

        // Get the end date and convert to local date
        String endDate = request.getParameter("endDate");
        LocalDate localEndDate;

        try {
            localEndDate = LocalDate.parse(endDate);
        } catch (Exception e) {
            session.setAttribute("errorMessages", "Invalid end date format. Please use yyyy-MM-dd.");
            response.sendRedirect("viewReports");
            return;
        }

        // Validate that start date is not after end date
        if (localStartDate.isAfter(localEndDate)) {
            session.setAttribute("errorMessages", "Start date must be before end date.");
            response.sendRedirect("viewReports");
            return;
        }

        // Filter the journals by start date and end date
        List<Journal> filteredJournals = new ArrayList<>();

        for (Journal journal : journals) {

            LocalDate journalDate = journal.getJournalDate();

            // if journal date is between start date and end date add it filtered journals
            if ((journalDate.isEqual(localStartDate) || journalDate.isAfter(localStartDate)) &&
                    (journalDate.isEqual(localEndDate) || journalDate.isBefore(localEndDate))) {

                    filteredJournals.add(journal);
            }
        }

        // Use the Profile stats object to generate catch rate, total bass, hours
        ProfileStats catchRateStats = new ProfileStats(filteredJournals);
        ProfileStatsCalculator catchRateCalculator = new ProfileStatsCalculator();
        catchRateCalculator.calculateStatistics(catchRateStats);

        request.setAttribute("catchRateStats", catchRateStats);
        request.setAttribute("startDate", startDate);
        request.setAttribute("endDate", endDate);

        // Mark the Report Nav as active for CSS underline
        session.setAttribute("lastClicked", "Reports");

        // Forward to the reports page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }


    /**
     *
     * @return
     */
     private Map<String, Object> retrieveFormData(HttpServletRequest request, User user) {

         // Instantiate necessary DAOS
         GenericDao lakeDao = new GenericDao(Lake.class);
         GenericDao methodDao = new GenericDao(Method.class);

         Map<String, Object> propertyMap = new HashMap<String, Object>();
         propertyMap.put("user", user);

         // Get the lake ID then get the lake. If "all lakes" was selected then we don't need to filter
         // by lake and don't add it to the property map
         String lakeId = request.getParameter("lake");
         if (!lakeId.equals("allLakes")) {
             Lake lake = (Lake)lakeDao.getById(Integer.parseInt(lakeId));
             propertyMap.put("lake", lake);
             request.setAttribute("lakeName", lake.getLakeName());
         } else {
             request.setAttribute("lakeName", "All");
         }

         // Get the method ID then get the method. If "all methods" was selected then we don't need to filter
         // by method and don't add it to the property map
         String methodId = request.getParameter("fishingMethod");
         if (!methodId.equals("allMethods")) {
             Method method = (Method)methodDao.getById(Integer.parseInt(methodId));
             propertyMap.put("method", method);
             request.setAttribute("methodName", method.getMethodName());
         } else {
             request.setAttribute("methodName", "All");
         }

         return propertyMap;
     }

}
