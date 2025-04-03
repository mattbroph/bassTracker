<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
<link rel="stylesheet" href="css/weather.css">

</head>

<body>
<c:import url="header.jsp" />

<main id="mainContent">

    <h1>Weather Search</h1>
    <br>
    <form action="actionGetWeather"
          method="get">
        <fieldset>
            <legend>Weather</legend>
            <!-- Date -->
            <label for="date">*Date</label>
            <input type="date"
                   name="date"
                   id="date"
                   required>
            <br>
            <!-- Zip Code -->
            <label for="zipCode">*Zip Code</label>
            <input type="text"
                   id="zipCode"
                   name="zipCode"
                   placeholder="Enter zip code"
                   required
                   pattern="\d{5}"
                   title="Please enter a 5 digit zip code"
                   required>
        </fieldset>
        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Get Weather">
            <a href="weather" class="cancelButton">Clear</a>
        </div>

        <c:if test="${not empty hourlyData && not empty postalCode && not empty date}">
            <br>
            <br>
            <h2>${date} | ${postalCode.placeName}, ${postalCode.adminCode1}</h2>
            <table id="table">
                <tbody>
                <tr>
                    <th>Time</th>
                    <th>Temperature &#8457;</th>
                    <th>Condition</th>
                    <th>Wind Speed</th>
                </tr>
                <c:forEach var="hour" items="${hourlyData}">
                    <tr>
                        <td>${fn:substring(hour.time, 11, 19)}</td>
                        <td>${hour.temp}</td>
                        <td>${hour.cocoDescription}</td>
                        <td>${hour.wspd} mph</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>


    </form>
    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>