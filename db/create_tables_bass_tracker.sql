USE bass_tracker_test;

#########################################################
# Remove all tables if they exist, prior to creating them
#########################################################
DROP TABLE IF EXISTS Journal;
DROP TABLE IF EXISTS Wind;
DROP TABLE IF EXISTS Weather;
DROP TABLE IF EXISTS Method;
DROP TABLE IF EXISTS Lake;
DROP TABLE IF EXISTS BassGoal;
DROP TABLE IF EXISTS AppUser;

#########################################################
# Create initial tables
#########################################################

CREATE TABLE Journal (
                         JournalID INTEGER AUTO_INCREMENT PRIMARY KEY,
                         UserID INTEGER NOT NULL,
                         JournalDate DATE NOT NULL,
                         LakeID INTEGER NOT NULL,
                         Hours DOUBLE NOT NULL,
                         MethodID INTEGER NOT NULL,
                         AirTemp INTEGER NOT NULL,
                         WeatherID INTEGER NOT NULL,
                         WindID INTEGER NOT NULL,
                         Comments TEXT,
                         ImageURL varchar(255),
                         SM_14_16 INTEGER NOT NULL,
                         SM_16_19 INTEGER NOT NULL,
                         SM_19_PLUS INTEGER NOT NULL,
                         LM_14_16 INTEGER NOT NULL,
                         LM_16_19 INTEGER NOT NULL,
                         LM_19_PLUS INTEGER NOT NULL
);

CREATE TABLE Wind (
                      WindID INTEGER AUTO_INCREMENT PRIMARY KEY,
                      WindType varchar(50) NOT NULL
);

CREATE TABLE Weather (
                         WeatherID INTEGER AUTO_INCREMENT PRIMARY KEY,
                         WeatherType varchar(50) NOT NULL
);

CREATE TABLE Method (
                        MethodID INTEGER AUTO_INCREMENT PRIMARY KEY,
                        MethodName varchar(50) NOT NULL
);

CREATE TABLE AppUser (
                         UserID INTEGER AUTO_INCREMENT PRIMARY KEY,
                         UserName varchar(50) NOT NULL,
                         FirstName varchar(50) NOT NULL,
                         LastName varchar(50) NOT NULL,
                         ProfilePicture varchar(255)
);

CREATE TABLE BassGoal (
                          GoalID INTEGER AUTO_INCREMENT PRIMARY KEY,
                          UserID INTEGER NOT NULL,
                          GoalYear YEAR NOT NULL,
                          GoalCount int NOT NULL,
                          UNIQUE (UserID, GoalYear)
);

CREATE TABLE Lake (
                      LakeID INTEGER AUTO_INCREMENT PRIMARY KEY,
                      LakeName varchar(50) NOT NULL,
                      UserID INTEGER NOT NULL,
                      isActive BOOLEAN DEFAULT TRUE,
                      UNIQUE (UserID, LakeName)
);

#########################################################
# Create Foreign Key Constraints
#########################################################

ALTER TABLE BassGoal
    ADD CONSTRAINT FK_BassGoal_User FOREIGN KEY (UserID)
        REFERENCES AppUser(UserID)
        ON DELETE CASCADE; -- If user is deleted, then bassgoal is deleted

ALTER TABLE Lake
    ADD CONSTRAINT FK_Lake_User FOREIGN KEY (UserID)
        REFERENCES AppUser(UserID)
        ON DELETE CASCADE; -- If user is deleted, then lakes are deleted

ALTER TABLE Journal
    ADD CONSTRAINT FK_Wind FOREIGN KEY (WindID)
        REFERENCES Wind(WindID);

ALTER TABLE Journal
    ADD CONSTRAINT FK_Weather FOREIGN KEY (WeatherID)
        REFERENCES Weather(WeatherID);

ALTER TABLE Journal
    ADD CONSTRAINT FK_Method FOREIGN KEY (MethodID)
        REFERENCES Method(MethodID);

ALTER TABLE Journal
    ADD CONSTRAINT FK_Journal_User FOREIGN KEY (UserID)
        REFERENCES AppUser(UserID);

ALTER TABLE Journal
    ADD CONSTRAINT FK_Lake FOREIGN KEY (LakeID)
        REFERENCES Lake(LakeID);