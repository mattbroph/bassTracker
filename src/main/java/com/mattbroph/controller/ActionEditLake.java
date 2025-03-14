package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Edit a lake entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionEditLakeServlet",
        urlPatterns = { "/actionEditLake" }
)
public class ActionEditLake extends HttpServlet {

    // Instance variables
    private String url = "";


    /**
     * Edits a lake in the application database
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        // Get the necessary daos
        GenericDao lakeDao = new GenericDao(Lake.class);

        // Happy path url
        url = request.getContextPath()
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

        // Edit parameters of the existing Lake
        editLakeParameters(lakeToEdit, request, lakeDao, session);

        // Send a redirect to the view journal detail page
        response.sendRedirect(url);
    }

    /**
     * Retrieve parameters from form and update journal attributes in database
     *
     * @param
     * @param
     * @param
     * @param
     * @param
     */
    public void editLakeParameters(Lake lakeToEdit, HttpServletRequest request,
                                   GenericDao lakeDao, HttpSession session) {

        // Get the lake name and status from the form
        String lakeName = request.getParameter("lakeName");
        lakeName = lakeName.trim();
        boolean isActive = Boolean.parseBoolean(request.getParameter("status"));
        // Get a list of existing lakes that have the same lake name
        // TODO FIX THIS!!! It needs to check only the user lakes!!! Right now it checks all lakes
        List<Lake> existingLakes = lakeDao.getByPropertyEqual("lakeName", lakeName);

//        List<Lake> existingLakes2 = user.getLakes();

        // If user is not editing lake name - only the status - update the lake
        if (lakeName.equalsIgnoreCase(lakeToEdit.getLakeName())) {

            // Set the new lake status
            lakeToEdit.setIsActive(isActive);

            // Update the Lake
            lakeDao.update(lakeToEdit);

            // Provide a success message
            session.setAttribute("lakeMessage", lakeToEdit.getLakeName()
                    + " was edited successfully.");

        } else {

            // If user is editing the lake name, check to see if lake name already
            // exists. If it does, do not perform the update.
            if (existingLakes.size() > 0) {

                session.setAttribute("lakeMessage", lakeName
                        + " already exists. Lake name must be unique.");

                session.setAttribute("lake", lakeToEdit);

                url = "editLake.jsp";

            } else {

                // Set the lake name & status
                lakeToEdit.setLakeName(lakeName);
                lakeToEdit.setIsActive(isActive);

                // Update the Lake
                lakeDao.update(lakeToEdit);

                // Provide a success message
                session.setAttribute("lakeMessage", lakeToEdit.getLakeName()
                        + " was edited successfully.");
            }
        }
    }
}
