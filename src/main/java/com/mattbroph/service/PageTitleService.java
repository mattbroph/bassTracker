package com.mattbroph.service;
import javax.servlet.ServletContext;
import java.util.Properties;

/**
 * Gets the page title which is loaded from a properties file in the ApplicationStartUp init() method.
 */
public class PageTitleService {

    /**
     * Gets page title.
     *
     * @param context   the context
     * @param pageTitle the page title
     * @return the page title
     */
    public String getPageTitle(ServletContext context, String pageTitle) {

        Properties properties = (Properties) context.getAttribute("pageProperties");
        return properties.getProperty(pageTitle);
    }
}
