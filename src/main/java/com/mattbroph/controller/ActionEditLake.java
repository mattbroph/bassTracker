package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.FormValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Edit a lake entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionEditLakeServlet",
        urlPatterns = { "/actionEditLake" }
)
public class ActionEditLake extends HttpServlet implements FormValidation {


    /**
     * Edits a lake in the application database
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Create a list to hold validator error messages
        List<String> violationMessages;

        // Get the necessary daos
        GenericDao lakeDao = new GenericDao(Lake.class);

        // Happy path url
        String url = request.getContextPath()
                + "/viewLakes";

        // Get the lake id to update
        int lakeId = Integer.parseInt(request.getParameter("lakeId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute("user");

        // If no user is logged in, send them to index jsp.
        if (sessionUser == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        /* If user does not have access to edit lake id, send them to unauthorized page
         * If user does have access to edit lake id and is logged in, edit the lake
         */
        Lake lakeToEdit = (Lake) lakeDao.getById(lakeId);

        if (lakeToEdit.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;
        }

        /* Create a new lake storing the original lake values.
         * This gets used in the session messages if there is an issue with the update.
         */
        Lake origLakeValues = new Lake(lakeToEdit.getLakeName(), lakeToEdit.getUser(), lakeToEdit.getIsActive());

        // Update the lakes variables based on the form submission
        boolean editTheLake = editLakeParameters(lakeToEdit, request, sessionUser);

        // If the lake passes initial validation, send it through hibernate validator
        if (editTheLake) {
            // Check for any hibernate using implemented FormValidation Interface
            violationMessages = validateFormData(lakeToEdit);

            // If there are violations, stop processing doPost and display errors on jsp
            if (!violationMessages.isEmpty()) {
                session.setAttribute("errorMessages", violationMessages);
                url = "editLake?lakeId=" + lakeToEdit.getId();
                session.setAttribute("lake", origLakeValues);
                response.sendRedirect(url);
                return;
            }

            // Update the Lake if hibernate validation passes
            lakeDao.update(lakeToEdit);

            session.setAttribute("lakeMessage", lakeToEdit.getLakeName()
                    + " was edited successfully.");

            } else {

                // If the lake name already exists, display that onto the page
                session.setAttribute("lake", origLakeValues);

                url = "editLake?lakeId=" + lakeToEdit.getId();

                    session.setAttribute("lakeMessage", lakeToEdit.getLakeName()
                            + " already exists. Lake name must be unique.");
        }


        // Send a redirect to the view journal detail page
        response.sendRedirect(url);
    }

    /**
     * Retrieve parameters from form and update lake attributes. Track the
     * editTheLake status and use that for further processing in doPost
     *
     * @param lakeToEdit the lake to edit
     * @param request the http request
     * @param sessionUser the user
     */
    public boolean editLakeParameters(Lake lakeToEdit,
             HttpServletRequest request, User sessionUser) {

        // Declare Variables
        boolean editTheLake;

        // Get the lake name and status from the form
        String lakeName = request.getParameter("lakeName");
        lakeName = lakeName.trim();
        boolean isActive = Boolean.parseBoolean(request.getParameter("status"));

        // Get a list of existing lakes that the user has
        List<Lake> existingLakes = sessionUser.getLakes();
        // Create an empty list to hold lakes with the same lake name as submission
        List<Lake> matchingLakeNames = new ArrayList<Lake>();

        // Determine if the submitted lake name exists in existingLakes
        for (Lake lake : existingLakes) {

            // If lakeName equals lake.getLakeName() then add it to a List of
            // Lakes with a matching lake name
            if (lakeName.equalsIgnoreCase(lake.getLakeName())) {
                matchingLakeNames.add(lake);
            }
        }

        // If user is not editing lake name - only the status - update the lake
        if (lakeName.equalsIgnoreCase(lakeToEdit.getLakeName())) {

            // Set the new lake status
            lakeToEdit.setIsActive(isActive);
            editTheLake = true;

        } else {

            // If user is editing the lake name, check to see if lake name already
            // exists. If it does, do not perform the update.
            if (matchingLakeNames.size() > 0) {

                lakeToEdit.setLakeName(lakeName);
                editTheLake = false;

            } else {

                // Set the lake name & status
                lakeToEdit.setLakeName(lakeName);
                lakeToEdit.setIsActive(isActive);
                editTheLake = true;
            }
        }

        return editTheLake;
    }
}
