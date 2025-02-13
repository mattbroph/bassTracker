<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/journal.css">
</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Add a Journal Entry</h1>

    <form name="contactUs"
          action="http://itins3.madisoncollege.edu/echo.php"
          method="post">
        <!-- Date -->
        <label for="date">*Date</label>
        <input type="date"
               name="date"
               id="date"
               required>
        <br>
        <!-- Lake -->
        <label for="lake">*Lake</label>
        <select name="lake" id="lake">
            <option value="" selected disabled>Select an option</option>
            <%-- Populate the user lake options --%>
            <%-- TODO populate lakes with just ACTIVE--%>
            <c:forEach var="lake" items="${userLakes}">

            <option value="${lake.id}">${lake.lakeName}</option>

            </c:forEach>

        </select>
        <br>

        <!-- Hours Fished -->
        <label for="hoursFished">*Hours Fished</label>
        <input type="number"
               name="hoursFished"
               id="hoursFished"
               required>
        <br>
        <!-- Fishing Method -->
        <label for="fishingMethod">*Fishing Method</label>
        <select name="fishingMethod" id="fishingMethod" required>
            <option value="" selected disabled>Select an option</option>
            <option value="1">Fly Fishing</option>
            <option value="2">Crib Fishing</option>
            <option value="3">Shoreline</option>
        </select>
        <br>
        <!-- Air Temp -->
        <label for="airTemp">*Air Temp</label>
        <input type="number"
               name="airTemp"
               id="airTemp"
               required>
        <br>
        <!-- Weather -->
        <label for="weather">*Weather</label>
        <select name="weather" id="weather" required>
            <option value="" selected disabled>Select an option</option>
            <option value="1">Sunny</option>
            <option value="2">Partly Sunny</option>
            <option value="3">Cloudy</option>
            <option value="4">Partly Cloudy</option>
            <option value="5">Rain</option>
        </select>
        <br>
        <!-- Wind -->
        <label for="wind">*Wind</label>
        <select name="wind" id="wind" required>
            <option value="" selected disabled>Select an option</option>
            <option value="1">0-5 mph</option>
            <option value="2">5-10 mph</option>
            <option value="3">15-20 mph</option>
            <option value="4">20+ mph</option>
        </select>
        <br>
        <!-- Bass Count Fields -->
        <div id="bassCountFields">
            <div id="smallMouthFields">
                <label for="sm-14-16">*Small Mouth 14"-16"</label>
                <input type="number"
                       name="sm-14-16"
                       id="sm-14-16"
                       required>
                <br>
                <label for="sm-16-18">*Small Mouth 16"-19"</label>
                <input type="number"
                       name="sm-16-18"
                       id="sm-16-18"
                       required>
                <br>
                <label for="sm-19-plus">*Small Mouth Bass 19"+</label>
                <input type="number"
                       name="sm-19-plus"
                       id="sm-19-plus"
                       required>
                <br>
            </div>
            <div id="largeMouthFields">
                <label for="lg-14-16">*Large Mouth 14"-16"</label>
                <input type="number"
                       name="lg-14-16"
                       id="lg-14-16"
                       required>
                <br>
                <label for="lg-16-18">*Large Mouth 16"-19"</label>
                <input type="number"
                       name="lg-16-18"
                       id="lg-16-18"
                       required>
                <br>
                <label for="lg-19-plus">*Large Mouth 19"+</label>
                <input type="number"
                       name="lg-19-plus"
                       id="lg-19-plus"
                       required>
                <br>
            </div>
        </div>
        <!-- Comments -->
        <label for="comments">Comments</label>
        <textarea name="comments"
                  id="comments"
                  placeholder="enter comments here"></textarea>
        <br>
        <!-- Photo -->
        <label for="photo">Photo of the day</label>
        <input type="text"
               name="photo"
               placeholder="enter URL here"
               id="photo">
        <br>


        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Add Journal">
            <a href="viewJournals" class="cancelButton">Cancel</a>
        </div>
    </form>
    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>