package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.FormValidation;
import com.mattbroph.service.UserSessionValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.*;

/**
 * Adds a journal entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionAddJournalsServlet",
        urlPatterns = { "/actionAddJournal" }
)
public class ActionAddJournal extends HttpServlet implements FormValidation {


    /** Adds a new journal to the application database
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

        // Create a list to hold validator error messages
        List<String> violationMessages;

        // Get the necessary daos
        GenericDao journalDao = new GenericDao(Journal.class);

        // Build forwarding url variable
        String url;

        // Id of the row inserted
        int insertedJournalId = 0;

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
            return;
        }

        // Retrieve the data from the form
        Journal newJournal = retrieveFormData(request, sessionUser);

        // Check for any hibernate using implemented FormValidation Interface
        violationMessages = validateFormData(newJournal);

        // If there are violations, stop processing doPost and display errors on jsp
        if (!violationMessages.isEmpty()) {
            session.setAttribute("errorMessages", violationMessages);
            url = request.getContextPath() + "/addJournal";
            response.sendRedirect(url);
            return;
        }

        // Add the journal to the database if no hibernate validator issues
        insertedJournalId = journalDao.insert(newJournal);

        // If insertedJournalId > 0 insert was successful, send to view details of the journal
        // and note that the journal has been added
        if (insertedJournalId > 0) {
            session.setAttribute("addJournalMessage", "The following journal has" +
                    " been added:");
            // Set the url for the redirect
            url = request.getContextPath() + "/viewJournalDetails?journalId=" + insertedJournalId;

        } else {

            session.setAttribute("addJournalMessage", "Something went wrong, " +
                    " your journal has not been added.");

            url = request.getContextPath() + "/error.jsp";
        }

        // Send a redirect to the view journal detail page or the error page
        response.sendRedirect(url);
    }


    /**
     * Retrieves the data from the add journal form and creates a Journal object with it.
     *
     * @param request the http request
     * @param user the session user
     * @return the journal to add to the database
     */
    private Journal retrieveFormData(HttpServletRequest request, User user) {

        // Instantiate necessary DAOS
        GenericDao lakeDao = new GenericDao(Lake.class);
        GenericDao weatherDao = new GenericDao(Weather.class);
        GenericDao windDao = new GenericDao(Wind.class);
        GenericDao methodDao = new GenericDao(Method.class);

        // Get the journal date and convert to local date
        String journalDate = request.getParameter("date");
        LocalDate localJournalDate = LocalDate.parse(journalDate);

        // Get the lake ID then get the lake
        String lakeId = request.getParameter("lake");
        Lake lake = (Lake)lakeDao.getById(Integer.parseInt(lakeId));

        // Get the hours fished
        String hoursFished = request.getParameter("hoursFished");
        double hoursFishedDouble = Double.parseDouble(hoursFished);

        // Get the method ID then get the method
        String methodId = request.getParameter("fishingMethod");
        Method method = (Method)methodDao.getById(Integer.parseInt(methodId));

        // Get the air temp and convert to int
        String airTemp = request.getParameter("airTemp");
        int airTempInt = Integer.parseInt(airTemp);

        // Get the weather ID then get the weather object
        String weatherId = request.getParameter("weather");
        Weather weather = (Weather)weatherDao.getById(Integer.parseInt(weatherId));

        // Get the wind ID then get the wind object
        String windId = request.getParameter("wind");
        Wind wind = (Wind)windDao.getById(Integer.parseInt(windId));

        // Get the small mouth bass counts by size
        String smallMouth1416 = request.getParameter("sm-14-16");
        int smallMouth1416Int = Integer.parseInt(smallMouth1416);

        String smallMouth1619 = request.getParameter("sm-16-19");
        int smallMouth1619Int = Integer.parseInt(smallMouth1619);

        String smallMouth19Plus = request.getParameter("sm-19-plus");
        int smallMouth19PlusInt = Integer.parseInt(smallMouth19Plus);

        // Get the large mouth bass counts by size
        String largeMouth1416 = request.getParameter("lm-14-16");
        int largeMouth1416Int = Integer.parseInt(largeMouth1416);

        String largeMouth1619 = request.getParameter("lm-16-19");
        int largeMouth1619Int = Integer.parseInt(largeMouth1619);

        String largeMouth19Plus = request.getParameter("lm-19-plus");
        int largeMouth19PlusInt = Integer.parseInt(largeMouth19Plus);

        // Get the comments
        String comments = request.getParameter("comments");

        // Get the photo
        String imageURL = request.getParameter("photo");

        // Construct the journal object
        Journal newJournal = new Journal(user, localJournalDate, lake, hoursFishedDouble,
                method, airTempInt, weather, wind, comments, imageURL, smallMouth1416Int,
                smallMouth1619Int, smallMouth19PlusInt, largeMouth1416Int, largeMouth1619Int,
                largeMouth19PlusInt);

        return newJournal;

    }





}