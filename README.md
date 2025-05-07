# Bass Tacker - Individual Project - Matt Brophy

### Problem Statement

Many bass fisherman use journals to log details about their fishing trips, including the date, lake, number of bass caught, weather conditions and fishing method. These records help identify trends and can be used to improve a fisherman’s success. Traditional paper journals and spreadsheets can be cumbersome to maintain and analyze.

The Bass Tracker application will allow users to log their fishing trips, track progress towards yearly goals and analyze data to determine fishing strategies. The app features a dashboard with key statistic, detailed journal entries and a reporting tool for in-depth analysis.


### Design

* [User Stories](designDocuments/userStories.md)
* [Screen Design](designDocuments/siteDesign)
* [Database Design](designDocuments/databaseDesign)

### [Project Plan](ProjectPlan.md)

### Project Technologies/Techniques

* Security/Authentication
  * AWS Cognito
* Database
  * MySQL 8.x
* ORM Framework
  * Hibernate Version
* Dependency Management
  * Maven
* Web Services consumed using Java
  * Meteostat Weather API
  * GeoNames Location API
* CSS 
  * Custom CSS
  * Minimal Bootstrap for nav bar collapsable menu
* Data Validation
  * Hibernate Validator
* Logging
  * Log4J2
* Hosting
  * AWS
* Tech I'd like to explore as part of this work
  * Chart.JS
  * DataTables
  * AWS
* Unit Testing
  * JUnit 
* IDE: IntelliJ IDEA

## Screenshots

### Dashboard
<img src="https://github.com/mattbroph/bassTracker/blob/main/screenshots/app/dashboard.png">

### View Journals
<img src="https://github.com/mattbroph/bassTracker/blob/main/screenshots/app/viewJournals.png">

### Weather (API)
<img src="https://github.com/mattbroph/bassTracker/blob/main/screenshots/app/weather.png">

### View Profile
<img src="https://github.com/mattbroph/bassTracker/blob/main/screenshots/app/profile.png">