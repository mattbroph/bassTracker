# Project Plan

### Week 2
- [X] Create project repository on GitHub
- [X] Create project structure in intellij and push
- [X] Add link to list of indie projects in student repo.
- [X] Complete Problem Statement
- [X] Update journal time log

### Week 3
- [X] Research possible Web Services/APIs to use
- [X] List technologies, versions and how they will be used
- [X] Document user stories and select MVP stories 
- [X] Confirm MVP stories meet Ent Java indie project objectives
- [X] Design screens - make sure all MVP user stories are covered
- [X] Start creating JSPs - html & css
- [X] First cut at database design
- [X] Update journal time log

### Week 4 - Class topic is Hibernate
#### This week my focus is:
1. Creating and loading the dev database w/ test data
2. The \#8 View Journals List story
3. The \#9 View Journal Details story
4. The \#10 Add Journal story

- [X] Create dev version of the database
- [X] Create a class for the DB connection
- [X] Create Journal entity
- [X] Create View Journals jsp
- [X] Create View Journal Details jsp
- [X] Create Add Journal jsp
- [X] Create controller to route to ViewJournals jsp
- [X] Create controller to route to View Journal Details jsp
- [X] Create controller to route to Add Journal jsp
- [X] Create class to perform CRUD for Add & View Journal functionality
- [X] Update journal time log


### Week 5 - Class topic is Hibernate (continued)
#### This week my focus is:
1. The \#11 Edit Journal story
2. The \#12 Delete Journal story

- [X] Create Edit Journal jsp
- [X] Create Delete Journal jsp
- [X] Create controller to route to editJournal.jsp
- [X] Create controller to route to deleteJournal.jsp
- [X] Add db UPDATE for Edit Journal functionality to CRUD class
- [X] Add db DELETE for Delete Journal functionality to CRUD class


### Week 6 - Class topic is deploying the application to AWS
#### This week my focus is:
1. The \#6 User Dashboard (current year) story

- [X] Create UserDashboard entity
- [X] Create class to run db queries to populate UserDashboard entity
- [X] Create User Dashboard jsp
- [X] Create controller to route to userDashboard.jsp
- [X] Update journal time log

### Week 7 - Class topic is AWS cognito (sign up and log in for users)
#### Checkpoint 2 is Due: Database designed and created, at least one DAO with full CRUD (create, read, update, delete) implemented with Hibernate, DAO is fully unit tested, Log4J is implemented (no System.out.printlns)
#### This week my focus is:
1. The \#1 Sign Up story
2. The \#2 Sign In story

- [X] Double-check all checkpoint 2 items (above) are complete and visible in github.
- [X] Set up Authentication in indie project (more tasks coming for this)
- [X] Create project DB on AWS.
- [X] Update project config files for AWS as needed
- [X] Deploy project to AWS
- [X] Add deployed link to indie project list in student repo
- [X] Update journal time log

### Week 8 - Class topic is RESTful web services
1. The \#3a. Create Profile story
2. The \#4 View profile story
3. The \#5 Edit profile story
- [X] Create User entity
- [X] Create class to perform CRU on the user - UserDAO (no delete on user? how does that work with congnito??)
- [X] Create the config files for the DB connection info (dev and test)
- [X] Create unit tests for the UserDAO
- [X] Create view profile jsp
- [X] Create edit profile jsp
- [X] Create controller to run INSERT for new users request
- [X] Create controller to route UPDATE request to edit a user's profile
- [X] Create controller to route to "view profile" jsp
- [X] Create controller to route to "edit profile" jsp
- [X] Update journal time log


### Week 9 - Class topic is RESTful web services continued 
#### Checkpoint 3 is Due: Deployed to AWS, at least one JSP that displays data from the database is implemented, authentication implemented, add AWS deployed app link to indie project list in student repo.
#### This week my focus is:
1. Wrapping up week 8 stories if overflow
2. The \#3b. User Profile Photo story
- [X] Double-check all checkpoint 3 items (above) are complete and visible in github.
- [X] Add functionality to hit AWS RESTful S3 bucket api and retrieve the user profile image to display throughout the web site
- [X] Wrap up any week 8 stories that were carry over
- [X] Update journal time log


### Week 10 Class topic is Team Project work week
#### This week my focus is:
1. The \#14 View Lakes List story
2. The \#15 Edit Lake story
3. The \#16 Add Lake story

- [X] Create Lake entity
- [X] Create View Lakes jsp
- [X] Create Add Lakes jsp
- [X] Create Edit Lakes jsp
- [X] Create controller to route to viewLakes.jsp
- [X] Create controller to route to addLakes.jsp
- [X] Create controller to route to editLakes.jsp
- [X] Create class to perform CRUD for Add, View and Edit lakes. User's won't be able to "delete" lakes, they can edit them or mark them inactive. This is so that journals with lakes that are marked inactive still retain their data.
- [X] Update journal time log

### Week 11 Class topic is Team Project work week
#### This week my focus is:
1. The \#13 Reports - Catch Rate story

- [X] Create Catch Rate Report entity
- [X] Create class that runs query to determine catch rate
- [X] Create report.jsp
- [X] Create controller to route to report.jsp
- [X] Display report on viewReport.jsp page
- [X] Update journal time log

### Week 12 Class topic is completing Team Project work
#### This week my focus is:
1. The \#17 Home story

- [X] Create controller that routes to index.jsp
- [X] Update journal time log

### Week 13 Class topic is OPTIONAL EJB (enterprise javabeans)
#### This week my focus is:
1. Finishing touches on code and prep for code review

- [X] Prep for code review
- [X] Finish Home page design
- [X] Update index.jsp
- [X] Hibernate form validation
  - [X] Add Lake
    - [X] Add Lake
    - [X] Edit Lake
    - [X] Add Journal
    - [X] Edit Journal
    - [X] Edit Bass Goal
    - [X] Edit Profile
    - [X] Weather
    - [X] Catch report
- [X] Update journal time log

### Week 14 Class topic is project code reviews
#### This week my focus is:
1. Code reviews and any items that need attention

- [X] Perform code reviews
- [X] All test plans
- [X] Update journal time log
- [X] Update session check sending to index.jsp to remove duplicate code - checkpoint 3
- [X] Remove printlns or printStackTraces - checkpoint 3
- [X] Generally overloaded constructors should call the no-arg constructor, allowing you to place common logic in a single place. This is true even if there is not currently logic in the no-arg constructor. - Checkpoint 3

### Week 15
- [X] Implement Feedback from Week 14 review
  - [X] Overide annotations in doGets doPosts
  - [X] Front end validation add / edit journal
  - [X] Error handling in weather API calls
  - [X] Add logging
- [ ] Final Presentation
- [ ] Create video, add video link to readme.md
- [X] Finalize all documentation
- [X] Code quality check
- [X] Review all java docs (params / returns ect.)
- [X] Weekly journal entry

### Spring Break
- [X] Gracefully handle user not being able to add or edit lake with same name
- [X] Disable certain nav bar pages if user not logged in
- [X] Show dynamic page titles
- [X] Add underline on last clicked nav bar
- [X] Set default profile pic image
- [X] Form for year in dashboard jsp
- [X] Work on jsp messaging if bass goal = 0
- [X] Work on jsp messaging if lake is empty on add journal
- [X] Add user profile pic to H1s?
- [X] Autoload 6 years of bass goals
- [X] Redesign view profile css
- [X] Make view profile page stats dynamic
- [X] Tool tip for add / edit journal photo & edit profile photo
- [X] Custom 404
- [X] Custom 500 error page
- [X] Unauthorized access page
- [X] Send Ashlie logo info

### Future
- [ ] Add journal validation - send em back to the form but keep it populated
- [ ] Add a download paper journal feature on the journals page
- [ ] Redesign view journal details page
- [ ] Redesign view profile page
- [ ] Add special character removal from data input / when rendering on page - XSS - maybe use Java HTML Sanitizer (by OWASP)