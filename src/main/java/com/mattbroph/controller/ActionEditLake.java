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
 * Edit a lake entry that was submitted by the user
 *@author mbrophy
 */
@WebServlet(
        name = "actionEditLakeServlet",
        urlPatterns = { "/actionEditLake" }
)
public class ActionEditLake extends HttpServlet {


    /** Edits a lake in the application database
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
        GenericDao lakeDao = new GenericDao(Lake.class);

        // Declare the url
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
        Lake lakeToEdit = (Lake)lakeDao.getById(lakeId);

        if (lakeToEdit.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;
         }

        // Edit parameters of the existing Lake
        editLakeParameters(lakeToEdit, request);

        // Update the Lake
        lakeDao.update(lakeToEdit);

        // Provide a success message
        session.setAttribute("lakeMessage", lakeToEdit.getLakeName()
                + " was edited successfully.");

        // Send a redirect to the view journal detail page
        response.sendRedirect(url);
    }

    /**
     * Retrieve parameters from form and update journal attributes in database
     */
     public void editLakeParameters(Lake lakeToEdit, HttpServletRequest request) {

         // Get the new lake name and set it
         String lakeName = request.getParameter("lakeName");
         lakeToEdit.setLakeName(lakeName);
         // Get the new lake status and set it
         boolean isActive = Boolean.parseBoolean(request.getParameter("status"));
         lakeToEdit.setIsActive(isActive);

     }

}
