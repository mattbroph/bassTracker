package com.mattbroph.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.*;
import com.mattbroph.persistence.PropertiesLoader;




/** Performs initialization of the application by loading the page properties
 * file to the ServletContext
 *
 * @author mbrophy
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/bassTracker-startup" },
        loadOnStartup = 1
)

public class ApplicationStartUp extends HttpServlet implements PropertiesLoader {

    /** Loads the properties file data to the ServletContext to display
     * page titles
     *
     * @throws ServletException if process fails
     */
    public void init() throws ServletException {

        // Create a Properties object and load the properties file
        Properties pageProperties = loadProperties("/pageTitle.properties");

        // Place the Properties object into the ServletContext
        ServletContext context = getServletContext();
        context.setAttribute("pageProperties", pageProperties);

    }






}
