<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp" />
<!DOCTYPE html>
<html lang="en">
<!-- JavaScript -->
<script src="js/dashboard.js"></script>
<%-- CSS --%>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/forms.css">
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
                   placeholder="Enter zip code"
                   required
                   pattern="\d{5}"
                   title="Please enter a 5 digit zip code"
                   required>
        </fieldset>
        <!-- Button fields -->
        <div id="buttonContainer">
            <input type="submit" value="Get Weather">
        </div>
    </form>
    <br>
    <br>
</main>
<c:import url="footer.jsp" />
</body>
</html>