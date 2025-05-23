# Presentation Notes

Part 1 - https://youtu.be/snmNbnFT4hU 

Part 2 - https://youtu.be/-v4OsyYydjE


1. Introduction (2 min)

    Hey this is Matt here, thanks for checking out my presentation. I'll be splitting this into two videos,
    the first being an overview and demo of the application itself. The second video we'll take a look into some
    interesting aspects of the code.    
    
    My application is called Bass Tracker,
    and it allows users to log their fishing trips, track progress towards yearly goals and analyze data to
    determine fishing strategies. The app features a dashboard with key statistic, detailed journal entries
    and a reporting tool for in-depth analysis. 

    This application was inspired last christmas when visting my Dad. He was showing me his fishing logs and how he
    tracks data in an excel spreadsheet. I thought it could really benefit to be turned into an application
    and so that's how this project started.

    - Some of the technologies in the project include

    Security/Authentication - AWS Cognito
    Database - MySQL 8.x
    ORM Framework - Hibernate 
    & Hibernate Validator for validation

    Web Services consumed using Java - Meteostat Weather API & GeoNames Location API

    Design - FIGMA
    CSS - Custom CSS - Minimal Bootstrap - for nav bar collapsable menu

    Hosting - AWS

    Interesting tech I explored - Chart.JS & DataTables


#### 2 MINUTE MARK

2. Demo (8 min)

    - Create a new user (if time allows)
    - Show lakes
      - Add, Edit
    - Show journals
       - Add a journal

    - Log in to mb account to show more interesting data
      - View journals
        - Discuss unique tech datatables
          - export reports
          - filter reports
      - Edit journal
      - Delete journal
    - Profile
    - Dashboard
      - Discuss unique tech chart.js
    - Reports
    - Weather API

    That'll do it for video 1, video 2 we'll take a look at the code itself.


#### 10 MINUTE MARK END VIDEO 1
#### 11 MIN 10 SEC - keep it under 9 min!!!


Thanks for joining part 2 of my application demo. In this video we'll look
at some of the code behind the app. 



Project structure:

Follownig MVC pattern
Controllers
Entity - with basic POJOs
Data access objects under persistence
Services - some classes I created to avoid duplicate code throughout the app
WEBAPP - JSPs, CSS, JavaScript

5. Unit test approach (2 min)
    - Show DB DAOs
    - Show API DAOs
    - Show coverage screenshots



Now I'll show some error handling that I implemented:

Using front end validation on my forms 

and a mix of Hibernate Validator and custom Java for the backend.

DEMO NOW

For example, Users cannot have two lakes with the same name:

I turned off front end validation on this form, to demonstrate hibernate validato

    - Demo 404 & 500
    - Demo unauthorized - try access journal 15
  
3. Error handling (3 min)
   - Demo hibernate validation of data
      - Hibernate Code
        - Show journal entity annotations
        - Show how each action controller implements FormValidator
      - Demonstrate lake name too long & non-unique lake name
    - Demo frontend validation of data
      - Add journal example
    - Demo 404 & 500
    - Demo unauthorized - try access journal 15

#### 13 MINUTE MARK


Next topic I wanted to demonstrate some logging with log4j:

4. Show log example (2 min)
     - Show UserService for new user creations
     - Show logs or screenshot

Lastly some reflections I have on the project itself

6. Lessons learned / key takeaways (2 min)
   - What went well / proud of
     - Really happy with Chart.js (The dashboard)
     - Happy with DataTables - especially the export & filters 
     - Overall site design (FIGMA)
       - Helped tremendously when building my site
   - What would I change in current state
     -  Change the photo file upload to S3
     -  Refactor the CSS
  
#### 19 MINUTE MARK

1. Project future state (1 min)
   - Polish the hibernate validation user experience
   - Redesign view journals page
   - Add additional reports
   - Deploy to another web hosting service for cheaper w/ a registered domain

#### <20 MINUTE MARK

   - Add special characters removal to avoid cross site scripting