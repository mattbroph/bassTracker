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
INSERT INTO Lake (LakeName, UserID, isActive)
VALUES ("Lake Kegonsa", "1", true),
	   ("Lake Mendota", "1", true),
       ("Lake Monona", "1", true),
       ("Fake Lake", "1", false),
       ("Boom Lake", "2", true),
       ("Lake Flannery", "2", true),
       ("Lake Michigan", "3", true);

################################
# Bass Goal
################################
INSERT INTO BassGoal (UserID, GoalYear, GoalCount)
VALUES ("1", "2025", "150"),
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
       ("3", "2025-02-24", "6", "2", "3", "90", "4", "3", "Today was rough", "https://myimage4.com", "1", "1", "0", "0", "6", "9"),
       ("1", "2025-02-23", "3", "4", "1", "72", "2", "3", "Calm and relaxing day", "http://fakeImage1.com", "2", "2", "1", "3", "0", "0"),
    ("1", "2025-02-22", "2", "3", "4", "65", "3", "1", "Caught a few nice ones", "http://fakeImage2.com", "1", "2", "0", "2", "1", "0"),
    ("1", "2025-02-21", "1", "6", "2", "78", "5", "5", "Best fishing this year!", "http://fakeImage3.com", "3", "4", "2", "5", "1", "1"),
    ("1", "2025-02-20", "1", "2", "3", "55", "1", "2", "Chilly but worth it", "http://fakeImage4.com", "0", "1", "0", "2", "1", "0"),
    ("1", "2025-02-19", "2", "5", "5", "82", "4", "4", "Great variety today", "http://fakeImage5.com", "2", "3", "1", "3", "2", "0"),
    ("1", "2025-02-18", "3", "3", "1", "70", "2", "3", "Had a blast!", "http://fakeImage6.com", "1", "1", "0", "4", "2", "1"),
    ("1", "2025-02-17", "2", "4", "2", "76", "3", "5", "Steady action all day", "http://fakeImage7.com", "2", "2", "1", "3", "3", "1"),
    ("1", "2025-02-16", "3", "5", "3", "80", "1", "2", "Weather was perfect", "http://fakeImage8.com", "3", "4", "2", "5", "2", "0"),
    ("1", "2025-02-15", "1", "2", "4", "60", "5", "1", "Bit slow, but enjoyable", "http://fakeImage9.com", "1", "0", "0", "1", "2", "0"),
    ("1", "2025-02-14", "2", "3", "5", "68", "2", "4", "Hooked some nice ones", "http://fakeImage10.com", "2", "3", "0", "4", "1", "0");

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







