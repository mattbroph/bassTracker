# Bass Tacker - Individual Project - Matt Brophy

### Problem Statement

Many bass fisherman use journals to log details about their fishing trips, including the date, lake, number of bass caught, weather conditions and fishing method. These records help identify trends and can be used to improve a fisherman’s success. Traditional paper journals and spreadsheets can be cumbersome to maintain and analyze.

The Bass Tracker application will allow users to log their fishing trips, track progress towards yearly goals and analyze data to determine fishing strategies. The app features a dashboard with key statistic, detailed journal entries and a reporting tool for in-depth analysis.


### Presentation
* Part 1 - App Demo - https://youtu.be/snmNbnFT4hU
* Part 2 - Code Review - https://youtu.be/-v4OsyYydjE

![Dashboard](https://private-user-images.githubusercontent.com/167562576/442224100-388348b5-1dea-4d1a-b517-b6d1c69ab4e2.gif?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NDY4MDg3MDEsIm5iZiI6MTc0NjgwODQwMSwicGF0aCI6Ii8xNjc1NjI1NzYvNDQyMjI0MTAwLTM4ODM0OGI1LTFkZWEtNGQxYS1iNTE3LWI2ZDFjNjlhYjRlMi5naWY_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjUwNTA5JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI1MDUwOVQxNjMzMjFaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT03MzkzMTBmMjIxYmNjMGY3ZDcyNWRiZWU2M2I1YTRkN2EzMDY0ZjA4OTA5OWI2M2E5ZDM4NTBiMjk1NTY0MzIxJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCJ9.hnWywU-qFU8AenrCQt6vh90ETEKjUnMMlorQpxele1I)

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
  * Hibernate
* Dependency Management
  * Maven
* Web Services consumed using Java
  * Meteostat Weather API
  * GeoNames Location API
* Design
  * FIGMA
* CSS 
  * Custom CSS
  * Minimal Bootstrap - for nav bar collapsable menu
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