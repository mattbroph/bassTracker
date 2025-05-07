# Presentation Notes

1. Introduction (2 min)
    - Read overview in readme
    - Read technologies in readme

#### 2 MINUTE MARK

2. Demo (8 min)
    - Log in to mb account
    - Show lakes
      - Add, Edit
    - Show journals
      - View journals
        - Discuss unique tech datatables
          - export reports
          - filter reports
      - Add journal
      - Edit journal
      - Delete journal
    - Profile
    - Dashboard
      - Discuss unique tech chart.js
    - Reports
    - Weather API
    - Create a new user (if time allows)

#### 10 MINUTE MARK
  
3. Error handling (3 min)
   - Demo hibernate validation of data
      - Hibernate Code
        - Show journal entity annotations
        - Show how each action controller implements FormValidator
      - Demonstrate lake name too long & non-unique lake name
    - Demo frontend validation of data
      - Add journal example
    - Demo 404 & 500
    - Demo unauthorized - try access journal that ain't theirs

#### 13 MINUTE MARK

4. Show log example (2 min)
     - Show UserService for new user creations
     - Show logs or screenshot

#### 15 MINUTE MARK

5. Unit test approach (2 min)
    - Show DB DAOs
    - Show API DAOs
    - Show coverage screenshots

#### 17 MINUTE MARK

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
   - Add special characters removal to avoid cross site scripting
   - Redesign view journals page
   - Add additional reports
   - Deploy to another web hosting service for cheaper w/ a registered domain

#### <20 MINUTE MARK