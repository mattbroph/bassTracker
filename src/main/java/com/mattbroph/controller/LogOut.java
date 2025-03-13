package com.mattbroph.controller;

import com.mattbroph.entity.User;
import com.mattbroph.persistence.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;

@WebServlet(
        urlPatterns = {"/logOut"}
)

/** Begins the authentication process using AWS Cognito
 *
 */
public class LogOut extends HttpServlet implements PropertiesLoader {
    Properties properties;
    private final Logger logger = LogManager.getLogger(this.getClass());
    public static String CLIENT_ID;
    public static String LOGOUT_URL;
    public static String LOGOUT_URI;

    @Override
    public void init() throws ServletException {
        super.init();
        loadProperties();
    }

    /**
     * Read in the cognito props file and get the client id and required urls
     * for authenticating a user.
     */
    // TODO This code appears in a couple classes, consider using a startup servlet similar to adv java project
    // 4 to do this work a single time and put the properties in the application scope
    private void loadProperties() {
        try {
            properties = loadProperties("/cognito.properties");
            CLIENT_ID = properties.getProperty("client.id");
            LOGOUT_URL = properties.getProperty("logOutURL");
            LOGOUT_URI = properties.getProperty("logOutURI");
        } catch (IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
        } catch (Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
        }
    }

    /**
     * Route to the aws-hosted cognito login page.
     * @param req servlet request
     * @param resp servlet response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(("user"));

        // If properties weren't loaded properly, route to an error page
        if (LOGOUT_URL == null || LOGOUT_URI == null || CLIENT_ID == null) {
            logger.error("LOGOUT URI, URL or CLIENT_ID properties are not set.");
            resp.sendRedirect("error.jsp");
            return;
        }

        // If there is a session, invalidate it.
        if (session != null) {
            session.invalidate();
            logger.info("Session has been cleared for user: " + user.getUserEmail());
        }

        // Log out of Cognito
        String url = LOGOUT_URL + "?client_id=" + CLIENT_ID + "&logout_uri=" + LOGOUT_URI;
        resp.sendRedirect(url);
    }
}
