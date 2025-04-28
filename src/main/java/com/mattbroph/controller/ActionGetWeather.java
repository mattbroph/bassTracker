package com.mattbroph.controller;

import com.mattbroph.jsonentity.DataItem;
import com.mattbroph.jsonentity.Location;
import com.mattbroph.jsonentity.MeteoStat;
import com.mattbroph.jsonentity.PostalCodes;
import com.mattbroph.persistence.GeoNamesDao;
import com.mattbroph.persistence.MeteoStatWeatherDao;
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
import java.time.LocalDate;
import java.util.List;

/**
 * Get the weather based on date and zip code
 *@author mbrophy
 */
@WebServlet(
        name = "actionGetWeatherServlet",
        urlPatterns = { "/actionGetWeather" }
)
public class ActionGetWeather extends HttpServlet {


    /** Get the weather based on date and zip code
     *
     *@param request the HttpServletRequest object
     *@param response the HttpServletRequest object
     *@exception ServletException if there is a Servlet failure
     *@exception IOException if there is an IO failure
     */
    public void doGet(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Define variables
        LocalDate date;
        HttpSession session = request.getSession();

        // Get the necessary daos
        GeoNamesDao geoNamesDao = new GeoNamesDao();
        MeteoStatWeatherDao meteostatDao = new MeteoStatWeatherDao();

        // Build forwarding url variable
        String url = "/weather.jsp";

        // Retrieve the data from the form
        String zipCode = request.getParameter("zipCode");
        String countryCode = "US";

        // Retrieve and validate date value
        try {
            date = LocalDate.parse(request.getParameter("date"));
        } catch (Exception e) {
            session.setAttribute("errorMessages", "Invalid date format. Please enter a valid date (yyyy-MM-dd).");
            url = "weather";
            response.sendRedirect(url);
            return;
        }

        // Validate zip code data
        if (zipCode == null || !zipCode.matches("\\d{5}")) {
            session.setAttribute("errorMessages", "Invalid zip code. Please enter a 5-digit US ZIP code.");
            url = "weather";
            response.sendRedirect(url);
            return;
        }

        // Build the geonames Location object
        Location location = geoNamesDao.getLocationInformation(zipCode, countryCode);

        // Build the MeteoStat object containing the weather
        MeteoStat meteoStat = meteostatDao.getMeteoStatWeather(location, date, date);

        // Get the meteoStat hourly data
        List<DataItem> hourlyData = meteoStat.getData();

        // Get the Location information
        PostalCodes postalCode = location.getPostalCodes().get(0);

        // Pass the objects into the request for the JSP to use
        request.setAttribute("postalCode", postalCode);
        request.setAttribute("hourlyData", hourlyData);
        request.setAttribute("date", date);

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.weather");
        request.setAttribute("pageTitle", pageTitle);

        // Forward to the weather jsp
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
