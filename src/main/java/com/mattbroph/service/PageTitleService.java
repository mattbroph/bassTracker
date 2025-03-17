package com.mattbroph.service;


import javax.servlet.ServletContext;
import java.util.Properties;

public class PageTitleService {

    public String getPageTitle(ServletContext context, String pageTitle) {

        Properties properties = (Properties) context.getAttribute("pageProperties");
        return properties.getProperty(pageTitle);
    }
}
