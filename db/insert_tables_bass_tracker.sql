USE bass_tracker_test;

################################
# WIND
################################
INSERT INTO Wind (WindType)
VALUES ("0-5 mph"),
       ("5-10 mph"),
       ("10-15 mph"),
       ("15-20 mph"),
       ("20+ mph");

################################
# Weather
################################
INSERT INTO Weather (WeatherType)
VALUES ("Sunny"),
       ("Partly Sunny"),
       ("Cloudy"),
       ("Partly Cloudy"),
       ("Rain");

################################
# Method
###############################
INSERT INTO Method (MethodName)
VALUES ("Crankbaits"),
       ("Shoreline fishing"),
       ("Bed fishing"),
       ("Ned rig"),
       ("Wacky worm"),
       ("Lindy rig"),
       ("Swim bait"),
       ("Swim jig"),
       ("Drop shot"),
       ("Crib fishing"),
       ("Fly fishing"),
       ("Other");
	
################################
# AppUser
################################
INSERT INTO AppUser (UserName, FirstName, LastName, ProfilePicture)
VALUES ("MattyB", "Matt", "Brophy", "https://urltomattspic"),
	   ("JohnnyD", "John", "Brophy", "https://urltojohnspic"),
       ("FrodoB", "Frodo", "Baggins", "https://urltofrodospic");
       
################################
# Lake
################################
INSERT INTO Lake (LakeName, UserID)
VALUES ("Lake Kegonsa", "1"),
	   ("Lake Mendota", "1"),
       ("Lake Monona", "1"),
       ("Boom Lake", "2"),
       ("Lake Flannery", "2"),
       ("Lake Michigan", "3");

################################
# Bass Goal
################################
INSERT INTO BassGoal (UserID, GoalYear, GoalCount)
VALUES ("1", "2025", "65"),
       ("1", "2024", "120"),
	   ("2", "2025", "90"),
       ("3", "2025", "32");

################################
# Journal
################################
INSERT INTO Journal (UserID, JournalDate, LakeID, Hours, MethodID, AirTemp, WeatherID, WindID, Comments, ImageURL, SM_14_16, SM_16_19, SM_19_PLUS, LM_14_16, LM_16_19, LM_19_PLUS)
VALUES ("1", "2025-02-25", "2", "5", "2", "80", "2", "2", "Had a really good time fishing today", "https://myimage.com", "2", "3", "4", "8", "1", "0"),
	   ("1", "2025-02-24", "1", "2", "3", "75", "1", "1", "Had so much fun", "https://myimage2.com", "1", "1", "0", "0", "1", "0"),
       ("2", "2025-02-24", "4", "2", "3", "62", "3", "4", "What a day", "https://myimage3.com", "1", "11", "0", "10", "1", "0"),
       ("3", "2025-02-24", "6", "2", "3", "90", "4", "3", "Today was rough", "https://myimage4.com", "1", "1", "0", "0", "6", "9");

################################
# Check your queries
################################
SELECT FirstName, LastName, LakeName, Hours, MethodName, AirTemp, WeatherType, WindType, Comments, ImageURL, SM_14_16, SM_16_19, SM_19_PLUS, LM_14_16, LM_16_19, LM_19_PLUS
FROM Journal
INNER JOIN AppUSer ON Journal.UserID = AppUser.UserID
INNER JOIN Lake ON Journal.LakeID = Lake.LakeID
INNER JOIN Method ON Journal.MethodID = Method.MethodID
INNER JOIN Weather ON Journal.WeatherID = Weather.WeatherID
INNER JOIN Wind ON Journal.WindID = Wind.WindID;







