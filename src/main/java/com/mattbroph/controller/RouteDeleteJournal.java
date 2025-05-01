package com.mattbroph.controller;

import com.mattbroph.entity.*;
import com.mattbroph.persistence.GenericDao;
import com.mattbroph.service.PageTitleService;
import com.mattbroph.service.UserSessionValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/** Forwards the request to view journals details jsp page with a delete
* message at the top
 *
 *@author mbrophy
 */
@WebServlet(
        name = "routeDeleteJournalServlet",
        urlPatterns = { "/deleteJournal" }
)
public class RouteDeleteJournal extends HttpServlet {

    /**
     * Forwards to the View Journal Detail JSP with Delete message and buttons
     * at the top
     *
     * @param request  the HttpServletRequest object
     * @param response the HttpServletRequest object
     * @throws ServletException if there is a Servlet failure
     * @throws IOException      if there is an IO failure
     */
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        // Create Daos
        GenericDao journalDao = new GenericDao(Journal.class);

        // Set the url
        String url;

        // Get the page title from the servlet context and set it in the request
        ServletContext context = getServletContext();
        PageTitleService pageTitleService = new PageTitleService();
        String pageTitle = pageTitleService.getPageTitle(context, "page.deleteJournal");
        request.setAttribute("pageTitle", pageTitle);

        // Get the journal id
        int journalId = Integer.parseInt(request.getParameter("journalId"));

        // Get user from the session
        HttpSession session = request.getSession();
        User sessionUser = UserSessionValidator.validateUserSession(request, response, session);

        // Check if user is logged in
        if (sessionUser == null) {
            // User was redirected via validateUserSession(), stop further processing
            return;
        }

        /* If user does not have access to delete journal id, send them to unauthorized page
         * If user does have access to delete journal id and is logged in, send them to delete
         * journal jsp.
         */
        Journal journal = (Journal)journalDao.getById(journalId);

        if (journal.getUser().getId() != sessionUser.getId()) {

            response.sendRedirect("unauthorized.jsp");
            return;

        } else {

            // Set attributes to make available in jsp
            request.setAttribute("journal", journal);

            // Update the session message
            session.setAttribute("deleteJournalMessage",
                    "Confirm deletion of the following journal entry:");

        }
        // Set the url param
        url = "/viewJournalDetails.jsp?journalId=" + journalId;



        // Forward to the HTTP request data jsp page
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
