## Code Review 03-12-2025

### ActionAddJournal Controller
- [ ] How to handle GenericDao insert() passing back insert ID
- [ ] Try catch block for exceptions? How to know which exceptions to catch?


### RouteViewJournalDetails Controller
- [ ] Show user / journal validation rerouting to unauthorized
- [ ] Gracefully handle journal that d/n exist (if coded into the URL)  

### ActionAddLake Controller
- [ ] Gracefully handle duplicate DB entry hibernate error
- [ ] Discuss same scenario for edit Lake

### CRUD
- [ ] Should all be in a try catch block?

### Log4J
- [ ] logger.info - add these throughout code for debugging
- [ ] logger.error - add these in my try catch blocks?
- [ ] Don't always understand which log to look

### General Workflow
- [ ] Discuss my approach on this


- User signs up and first name / last name is created
- User needs to add lakes and update their bass goals
