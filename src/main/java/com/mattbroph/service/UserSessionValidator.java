package com.mattbroph.service;


import com.mattbroph.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Validates user session variables and restricts access to pages if unauthorized
 */
public class UserSessionValidator {


    /**
     * Validates if a user is logged in.
     * If not, redirect them to another page.
     *
     * @param request the http request
     * @param response the http response
     * @param session the http session
     * @throws IOException if an error occurs during processing
     * @return the user that is logged into the session
     */
     public static User validateUserSession(HttpServletRequest request,
            HttpServletResponse response, HttpSession session) throws IOException {

        // Get user from the session
         User sessionUser = (User) session.getAttribute("user");

         // If no user is logged in, send them to index jsp.
         if (sessionUser == null) {
             response.sendRedirect("index.jsp");
             return null;
         }

         return sessionUser;

     }




}
