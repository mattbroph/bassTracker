package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


/**
 *
 *@author mbrophy
 */
@WebServlet(
        name = "actionAddJournalsServlet",
        urlPatterns = { "/actionAddJournal" }
)
public class ActionAddJournal extends HttpServlet {


    /** Adds a new journal to the application database
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
        GenericDao lakeDao = new GenericDao(Lake.class);
        GenericDao weatherDao = new GenericDao(Weather.class);
        GenericDao windDao = new GenericDao(Wind.class);
        GenericDao methodDao = new GenericDao(Method.class);

        // Get access to the session
        HttpSession session = request.getSession();

        // Id of the row inserted
        int insertedJournalId = 0;

        // TODO Get the user from the session
        User user = (User)userDao.getById(1);

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

        // Build forwarding url variable
        String url;

        // Construct the journal object
        Journal newJournal = new Journal(user, localJournalDate, lake, hoursFishedDouble,
                method, airTempInt, weather, wind, comments, imageURL, smallMouth1416Int,
                smallMouth1619Int, smallMouth19PlusInt, largeMouth1416Int, largeMouth1619Int,
                largeMouth19PlusInt);

        // Add the journal
        insertedJournalId = journalDao.insert(newJournal);

        // If Journal Id = insertedJournalId then send to view details of the journal
        // and note that the journal has been added
        if (insertedJournalId > 0) {

            session.setAttribute("addJournalMessage", "The following journal has" +
                    " been added:");

            // Set the url for the redirect
            url = request.getContextPath() + "/viewJournalDetails?journalId=" + insertedJournalId;

        } else {

            session.setAttribute("addJournalMessage", "Something went wrong, " +
                    " your journal has not been added.");
            // TODO make this an error page!
            url = request.getContextPath() + "/viewJournalDetails";

        }


        // Send a redirect to the view journal detail page or the error page
        response.sendRedirect(url);


    }








}
