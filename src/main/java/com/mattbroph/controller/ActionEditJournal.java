package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.GenericDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;


/**
 * Edit a journal entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionEditJournalsServlet",
        urlPatterns = { "/actionEditJournal" }
)
public class ActionEditJournal extends HttpServlet {


    /** Edits a journal in the application database
     *
     *@param request the HttpServletRequest object
     *@param response the HttpServletRequest object
     *@exception ServletException if there is a Servlet failure
     *@exception IOException if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Get the necessary daos
        GenericDao userDao = new GenericDao(User.class);
        GenericDao journalDao = new GenericDao(Journal.class);

        // Declare the url
        String url;

        // Get the Journal ID to update
        int journalId = Integer.parseInt(request.getParameter("journalId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        /* If user does not have access to edit journal id, send them to unauthorized page
         * If user does have access to edit journal id and is logged in, edit the journal
         */
        Journal journalToEdit = (Journal)journalDao.getById(journalId);

         if (journalToEdit.getUser().getId() != sessionUser.getId()) {

             response.sendRedirect("unauthorized.jsp");
             return;

         } else {

             // Edit parameters of the existing Journal
             editJournalParameters(journalToEdit, request);

             // Update the journal
             journalDao.update(journalToEdit);

             // Build forwarding url
             url = request.getContextPath()
                    + "/viewJournalDetails?journalId=" + journalId;
         }

        // Send a redirect to the view journal detail page
        response.sendRedirect(url);
    }

    /**
     * Retrieve parameters from form and update journal attributes in database
     */
     public void editJournalParameters(Journal journalToEdit, HttpServletRequest request) {

         // Get the necessary DAOs
         GenericDao lakeDao = new GenericDao(Lake.class);
         GenericDao weatherDao = new GenericDao(Weather.class);
         GenericDao windDao = new GenericDao(Wind.class);
         GenericDao methodDao = new GenericDao(Method.class);

         // Get the journal date and convert to local date
         String journalDate = request.getParameter("date");
         LocalDate localJournalDate = LocalDate.parse(journalDate);
         journalToEdit.setJournalDate(localJournalDate);

         // Get the lake ID then get the lake
         String lakeId = request.getParameter("lake");
         Lake lake = (Lake)lakeDao.getById(Integer.parseInt(lakeId));
         journalToEdit.setLake(lake);

         // Get the hours fished
         String hoursFished = request.getParameter("hoursFished");
         double hoursFishedDouble = Double.parseDouble(hoursFished);
         journalToEdit.setHours(hoursFishedDouble);

         // Get the method ID then get the method
         String methodId = request.getParameter("fishingMethod");
         Method method = (Method)methodDao.getById(Integer.parseInt(methodId));
         journalToEdit.setMethod(method);

         // Get the air temp and convert to int
         String airTemp = request.getParameter("airTemp");
         int airTempInt = Integer.parseInt(airTemp);
         journalToEdit.setAirTemp(airTempInt);

         // Get the weather ID then get the weather object
         String weatherId = request.getParameter("weather");
         Weather weather = (Weather)weatherDao.getById(Integer.parseInt(weatherId));
         journalToEdit.setWeather(weather);

         // Get the wind ID then get the wind object
         String windId = request.getParameter("wind");
         Wind wind = (Wind)windDao.getById(Integer.parseInt(windId));
         journalToEdit.setWind(wind);

         // Get the small mouth bass counts by size
         String smallMouth1416 = request.getParameter("sm-14-16");
         int smallMouth1416Int = Integer.parseInt(smallMouth1416);
         journalToEdit.setSmallMouth1416(smallMouth1416Int);

         String smallMouth1619 = request.getParameter("sm-16-19");
         int smallMouth1619Int = Integer.parseInt(smallMouth1619);
         journalToEdit.setSmallMouth1619(smallMouth1619Int);

         String smallMouth19Plus = request.getParameter("sm-19-plus");
         int smallMouth19PlusInt = Integer.parseInt(smallMouth19Plus);
         journalToEdit.setSmallMouth19Plus(smallMouth19PlusInt);

         // Get the large mouth bass counts by size
         String largeMouth1416 = request.getParameter("lm-14-16");
         int largeMouth1416Int = Integer.parseInt(largeMouth1416);
         journalToEdit.setLargeMouth1416(largeMouth1416Int);

         String largeMouth1619 = request.getParameter("lm-16-19");
         int largeMouth1619Int = Integer.parseInt(largeMouth1619);
         journalToEdit.setLargeMouth1619(largeMouth1619Int);

         String largeMouth19Plus = request.getParameter("lm-19-plus");
         int largeMouth19PlusInt = Integer.parseInt(largeMouth19Plus);
         journalToEdit.setLargeMouth19Plus(largeMouth19PlusInt);

         // Get the comments
         String comments = request.getParameter("comments");
         journalToEdit.setComments(comments);

         // Get the photo
         String imageURL = request.getParameter("photo");
         journalToEdit.setImageURL(imageURL);
     }

}
